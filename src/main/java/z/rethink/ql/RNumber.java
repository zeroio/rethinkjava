package z.rethink.ql;

import z.rethink.TermType;

public class RNumber extends Value {
    public RNumber(Any node) {
        super(node);
    }

    public RNumber(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public RNumber add(RNumber... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RNumber(TermType.ADD, ToJson.concat(this, values));
    }

    public RNumber sub(RNumber... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RNumber(TermType.SUB, ToJson.concat(this, values));
    }

    public RNumber mul(RNumber... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RNumber(TermType.MUL, ToJson.concat(this, values));
    }

    public RNumber div(RNumber... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RNumber(TermType.DIV, ToJson.concat(this, values));
    }

    public RNumber mod(RNumber... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RNumber(TermType.MOD, ToJson.concat(this, values));
    }

    public RNumber round() {
        return new RNumber(TermType.ROUND, this);
    }

    public RNumber floor() {
        return new RNumber(TermType.FLOOR, this);
    }
}
