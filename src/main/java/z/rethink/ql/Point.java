package z.rethink.ql;

import z.rethink.TermType;

public class Point extends Any {
    public Point(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }
}
