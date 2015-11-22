package z.rethink.ql;

import z.rethink.TermType;

public class RJS extends Any {
    public RJS(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }
}
