package z.rethink.ql;

import z.rethink.TermType;

public class DefaultSelection extends Any implements Selection {
    public DefaultSelection(Any any) {
        super(any);
    }

    public DefaultSelection(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }
}
