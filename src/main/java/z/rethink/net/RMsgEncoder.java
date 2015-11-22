package z.rethink.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class RMsgEncoder extends MessageToByteEncoder<RMsg> {
    static final Charset UTF8_CHARSET = Charset.forName("UTF8");

    @Override
    protected void encode(ChannelHandlerContext ctx, RMsg msg, ByteBuf out) throws Exception {
        out.order(ByteOrder.LITTLE_ENDIAN);
        out.writeLong(msg.getId());
        ByteBuf textBuf =  ByteBufUtil.encodeString(ctx.alloc(), CharBuffer.wrap(msg.getText()), UTF8_CHARSET);
        out.writeInt(textBuf.readableBytes());
        out.writeBytes(textBuf);
    }
}
