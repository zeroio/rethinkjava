package z.rethink.ql;

import z.rethink.TermType;

public interface Selection extends Sequence {

    default RObject update(RObject object, Options options) {
        return new RObject(TermType.UPDATE, this, options);
    }

    default RObject update(RObject object) {
        return new RObject(TermType.UPDATE, this);
    }

    default RObject update(RFunction function, Options options) {
        return new RObject(TermType.UPDATE, this, options);
    }

    default RObject update(RFunction function) {
        return new RObject(TermType.UPDATE, this);
    }

    default RObject replace(RObject object, Options options) {
        return new RObject(TermType.REPLACE, this, options);
    }

    default RObject replace(RObject object) {
        return new RObject(TermType.REPLACE, this);
    }

    default RObject replace(RFunction function, Options options) {
        return new RObject(TermType.REPLACE, this, options);
    }

    default RObject replace(RFunction function) {
        return new RObject(TermType.REPLACE, this);
    }

    default RObject delete(Options options) {
        return new RObject(TermType.DELETE, this, options);
    }

    default RObject delete() {
        return new RObject(TermType.DELETE, this);
    }

    default Selection filter(PredicateFunction function, Options options) {
        return new DefaultSelection(TermType.FILTER, this, function, options);
    }

    default Selection filter(PredicateFunction function) {
        return new DefaultSelection(TermType.FILTER, this, function);
    }

    default SelectionArray orderBy(OrderBy order) {
        return new SelectionArray(TermType.ORDER_BY, this, order);
    }

    default Selection selSlice(int startIdx) {
        return new DefaultSelection(TermType.SLICE, this, ToJson.of(startIdx));
    }

    default Selection selSlice(int startIdx, Options options) {
        return new DefaultSelection(TermType.SLICE, this, ToJson.of(startIdx), options);
    }

    default Selection selSlice(int startIdx, int endIdx) {
        return new DefaultSelection(TermType.SLICE, this, ToJson.of(startIdx), ToJson.of(endIdx));
    }

    default Selection selSlice(int startIdx, int endIdx, Options options) {
        return new DefaultSelection(TermType.SLICE, this, ToJson.of(startIdx), ToJson.of(endIdx), options);
    }

    default SelectionObject nth(int idx) {
        return new SelectionObject(TermType.NTH, this, ToJson.of(idx));
    }
}
