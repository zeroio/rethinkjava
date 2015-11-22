package z.rethink.ql;

import z.rethink.TermType;

public class SingleSelection extends Any implements Selection {
    public SingleSelection(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public Stream changes() {
        return new Stream(TermType.CHANGES, this);
    }

    public Stream changes(Options options) {
        return new Stream(TermType.CHANGES, this, options);
    }

    public RObject without(String... selectors) {
        return new RObject(TermType.WITHOUT, ToJson.concat(this, ToJson.of(selectors)));
    }
}
