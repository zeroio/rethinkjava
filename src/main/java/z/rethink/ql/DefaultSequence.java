package z.rethink.ql;

import z.rethink.TermType;

public class DefaultSequence extends Any implements Sequence {
    public DefaultSequence(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }
}
