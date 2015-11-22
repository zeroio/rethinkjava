package z.rethink;


import io.netty.channel.Channel;

public class RethinkDB {
    private final Channel channel;

    public RethinkDB(Channel channel) {
        this.channel = channel;
    }



}
