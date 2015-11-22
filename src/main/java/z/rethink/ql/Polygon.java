package z.rethink.ql;

import z.rethink.TermType;

public class Polygon extends Any {
    public Polygon(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public Polygon polygonSub(Polygon polygon) {
        return new Polygon(TermType.POLYGON_SUB, polygon);
    }
}
