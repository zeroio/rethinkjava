package z.rethink.ql;

import z.rethink.TermType;

public class RString extends Value {
    public RString(Any node) {
        super(node);
    }

    public RString(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public RObject match(String regExp) {
        return new RObject(TermType.MATCH, this, ToJson.of(regExp));
    }

    public Array split() {
        return new Array(TermType.SPLIT, this);
    }

    public Array split(String separator) {
        return new Array(TermType.SPLIT, this, ToJson.of(separator));
    }

    public Array split(String separator, int maxSplits) {
        return new Array(TermType.SPLIT, this, ToJson.of(separator), ToJson.of(maxSplits));
    }

    public RString upcase() {
        return new RString(TermType.UPCASE, this);
    }

    public RString downcase() {
        return new RString(TermType.DOWNCASE, this);
    }

    public RNumber coerceToNumber() {
        return new RNumber(TermType.COERCE_TO, this, ToJson.of("number"));
    }

    public RBinary coerceToBinary() {
        return new RBinary(TermType.COERCE_TO, this, ToJson.of("binary"));
    }
}
