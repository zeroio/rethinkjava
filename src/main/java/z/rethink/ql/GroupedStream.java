package z.rethink.ql;

import z.rethink.TermType;

public class GroupedStream extends Stream {
    public GroupedStream(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public Array ungroup() {
        return new Array(TermType.UNGROUP, this);
    }
}
