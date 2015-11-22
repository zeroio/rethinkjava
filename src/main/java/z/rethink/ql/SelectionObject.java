package z.rethink.ql;

import z.rethink.TermType;

public class SelectionObject extends RObject implements Selection {
    protected SelectionObject(Any node) {
        super(node);
    }

    public SelectionObject(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }
}
