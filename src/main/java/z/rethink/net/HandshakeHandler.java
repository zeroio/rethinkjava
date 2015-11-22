package z.rethink.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import z.rethink.ConnectingException;

import java.nio.ByteOrder;

public class HandshakeHandler extends ChannelInboundHandlerAdapter {
    private static final String SUCCESS = "SUCCESS";
    private static final int V4 = 1074539808;
    public static final int JSON_PROTOCOL = 2120839367;

    private final byte[] auth;
    private volatile ChannelHandlerContext ctx;
    private final Promise<Void> promise;
    private ByteBuf internalBuf;
    private boolean done = false;

    public HandshakeHandler(byte[] auth) {
        this.auth = auth;
        this.promise = new LazyPromise();
        this.internalBuf = Unpooled.buffer(1024, 1024);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = ctx.alloc().buffer(4 + 4 + auth.length + 4);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.writeInt(V4);
        buf.writeInt(auth.length);
        buf.writeBytes(auth);
        buf.writeInt(JSON_PROTOCOL);
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (done) {
            ctx.fireChannelRead(msg);
        }
        ByteBuf buf = (ByteBuf) msg;
        int readIdx = buf.readerIndex();
        boolean metZero = false;
        while (readIdx < buf.writerIndex() && (metZero = buf.getByte(readIdx) != 0)) {
            readIdx++;
        }
        int bytesToRead = readIdx - buf.readerIndex();
        if (bytesToRead > internalBuf.writableBytes()) {
            throw new ConnectingException("Too long response from server when doing handshake");
        }
        internalBuf.writeBytes(buf, bytesToRead);
        if (metZero) {
            String serverMsg =  internalBuf.toString(CharsetUtil.US_ASCII);
            if (SUCCESS.equals(serverMsg)) {
                promise.setSuccess(null);
            } else {
                throw new ConnectingException("Failed to connect to server due to server reject handshake with message " + serverMsg);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)throws Exception {
        if (!done) {
            promise.setFailure(new ConnectingException("Exception during handshake", cause));
        } else {
            super.exceptionCaught(ctx, cause);
        }
    }

    public Promise<Void> promise() {
        return promise;
    }

    private class LazyPromise extends DefaultPromise<Void> {
        @Override
        protected EventExecutor executor() {
            if (ctx == null) {
                throw new IllegalStateException();
            }
            return ctx.executor();
        }

        @Override
        protected void checkDeadLock() {
            if (ctx == null) {
                return;
            }
            super.checkDeadLock();
        }
    }
}
