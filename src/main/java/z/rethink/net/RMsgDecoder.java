package z.rethink.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.CharsetUtil;

import java.nio.ByteOrder;

public class RMsgDecoder extends LengthFieldBasedFrameDecoder {
    private static final int MAX_MSG_SIZE = 1024 * 1024 * 4;

    public RMsgDecoder() {
        super(MAX_MSG_SIZE, 8, 4);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        in.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuf buf = (ByteBuf) super.decode(ctx, in);
        if (buf != null) {
            long id = buf.readLong();
            buf.skipBytes(4);
            String text = buf.toString(CharsetUtil.UTF_8);
            return new RMsg(id, text);
        }
        return null;
    }
}
