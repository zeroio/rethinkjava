package z.rethink.ql;

import z.rethink.TermType;

public class SelectionArray extends Array {
    public SelectionArray(Any node) {
        super(node);
    }

    public SelectionArray(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }
}
