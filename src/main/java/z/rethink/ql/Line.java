package z.rethink.ql;

import z.rethink.TermType;

public class Line extends Any {
    public Line(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public Polygon fill() {
        return new Polygon(TermType.FILL, this);
    }
}
