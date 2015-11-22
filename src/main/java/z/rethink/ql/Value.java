package z.rethink.ql;

import z.rethink.TermType;

public class Value extends Any {
    public Value(Any node) {
        super(node);
    }

    public Value(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public RObject object() {
        return new RObject(this);
    }

    public RString string() {
        return new RString(this);
    }

    public RNumber number() {
        return new RNumber(this);
    }

    public RTime time() {
        return new RTime(this);
    }

    public RBoolean bool() {
        return new RBoolean(this);
    }

    public RBoolean eq(Value... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RBoolean(TermType.EQ, ToJson.concat(this, values));
    }

    public RBoolean ne(Value... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RBoolean(TermType.NE, ToJson.concat(this, values));
    }

    public RBoolean gt(Value... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RBoolean(TermType.GT, ToJson.concat(this, values));
    }

    public RBoolean ge(Value... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RBoolean(TermType.GT, ToJson.concat(this, values));
    }

    public RBoolean lt(Value... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RBoolean(TermType.LT, ToJson.concat(this, values));
    }

    public RBoolean le(Value... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RBoolean(TermType.LE, ToJson.concat(this, values));
    }

    public Any defaultVal(Value value) {
        return new Any(TermType.DEFAULT, this, value);
    }

    public Any defaultVal(RFunction function) {
        return new Any(TermType.DEFAULT, this, function);
    }

    public RString coerceToString() {
        return new RString(TermType.COERCE_TO, this, ToJson.of("string"));
    }

    public RString toJsonString() {
        return new RString(TermType.TO_JSON_STRING, this);
    }

    public RString toJSON() {
        return new RString(TermType.TO_JSON_STRING, this);
    }

}
