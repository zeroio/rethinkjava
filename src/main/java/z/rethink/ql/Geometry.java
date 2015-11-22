package z.rethink.ql;

import z.rethink.TermType;

public class Geometry extends Any {
    public Geometry(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public RNumber distance(Geometry geometry) {
        return new RNumber(TermType.DISTANCE, this, geometry);
    }

    public RNumber distance(Geometry geometry, Options options) {
        return new RNumber(TermType.DISTANCE, this, geometry, options);
    }

    public RBoolean includes(Geometry geometry) {
        return new RBoolean(TermType.INCLUDES, this, geometry);
    }

    public RBoolean intersects(Geometry geometry) {
        return new RBoolean(TermType.INTERSECTS, this, geometry);
    }
}
