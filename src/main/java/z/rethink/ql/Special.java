package z.rethink.ql;

import z.rethink.TermType;

public class Special extends Any {
    public Special(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }
}
