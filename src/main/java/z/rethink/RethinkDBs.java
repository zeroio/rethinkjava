package z.rethink;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import z.rethink.net.HandshakeHandler;
import z.rethink.net.RMsgDecoder;
import z.rethink.net.RMsgEncoder;

import java.util.concurrent.CompletableFuture;

public class RethinkDBs {
    private static final ByteBuf NULL_DELIMITER = Unpooled.copiedBuffer(new byte[]{0});

    private final EventLoopGroup workerGroup;

    public RethinkDBs() {
        workerGroup = new NioEventLoopGroup();

    }

    public CompletableFuture<RethinkDB> from(String host, int port, String auth) {
        byte[] authAsByte = auth.getBytes(CharsetUtil.US_ASCII);

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        HandshakeHandler handsake = new HandshakeHandler(authAsByte);
        bootstrap.handler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(handsake, new RMsgDecoder(), new RMsgEncoder());
            }
        });

        CompletableFuture<RethinkDB> future = new CompletableFuture<>();
        ChannelFuture channelFuture = bootstrap.connect(host, port);
        RethinkDB conn = new RethinkDB(channelFuture.channel());
        handsake.promise().addListener(f-> {
           if (f.isSuccess()) {
               future.complete(conn);
           } else {
               future.completeExceptionally(f.cause());
           }
        });
        return future;
    }

}