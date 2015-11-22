package z.rethink.ql;

import z.rethink.TermType;

public class RBoolean extends Value {
    public RBoolean(Any node) {
        super(node);
    }

    public RBoolean(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public RBoolean and(RBoolean... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RBoolean(TermType.AND, ToJson.concat(this, values));
    }

    public RBoolean or(RBoolean... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RBoolean(TermType.OR, ToJson.concat(this, values));
    }

    public RBoolean not() {
        return new RBoolean(TermType.NOT, this);
    }
}
