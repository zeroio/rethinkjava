package z.rethink.ql;

import z.rethink.TermType;

public class Error extends Any {
    public Error(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }
}
