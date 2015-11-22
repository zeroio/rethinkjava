package z.rethink.ql;

import z.rethink.TermType;

public class RObject extends Any {

    protected RObject(Any node) {
        super(node);
    }

    public RObject(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public RObject pluck(String... selectors) {
        return new RObject(TermType.PLUCK, ToJson.concat(this, ToJson.of(selectors)));
    }

    public RObject without(String... selectors) {
        return new RObject(TermType.WITHOUT, ToJson.concat(this, ToJson.of(selectors)));
    }

    public RObject merge(RObject... objects) {
        if (objects.length == 0) {
            throw new IllegalArgumentException("objects length should be more than 0");
        }
        return new RObject(TermType.MERGE, ToJson.concat(this, objects));
    }

    public Value getField(String name) {
        return new Value(TermType.GET_FIELD, this, ToJson.of(name));
    }

    public RBoolean hasFields(String... selectors) {
        return new RBoolean(TermType.HAS_FIELDS, ToJson.of(selectors));
    }

    public Array keys() {
        return new Array(TermType.KEYS, this);
    }

    public Array values() {
        return new Array(TermType.VALUES, this);
    }

    public Array coerceToArray() {
        return new Array(TermType.COERCE_TO, this, ToJson.of("array"));
    }
}
