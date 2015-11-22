package z.rethink.net;

public class RMsg {
    private final long id;
    private final String text;

    public RMsg(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
