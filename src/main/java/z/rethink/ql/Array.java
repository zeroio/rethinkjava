package z.rethink.ql;

import z.rethink.TermType;

public class Array extends Any {

    public Array(Any node) {
        super(node);
    }

    public Array(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public Array filter(PredicateFunction function, Options options) {
        return new Array(TermType.FILTER, this, function, options);
    }

    public Array filter(PredicateFunction function) {
        return new Array(TermType.FILTER, this, function);
    }

    public Array innerJoin(Sequence sequence, PredicateFunction function) {
        return new Array(TermType.INNER_JOIN, this, function);
    }

    public Array outerJoin(Sequence sequence, PredicateFunction function) {
        return new Array(TermType.OUTER_JOIN, this, function);
    }

    public Array zip() {
        return new Array(TermType.ZIP, this);
    }

    public Array map(RFunction function, Array... arrays) {
        return new Array(TermType.MAP, ToJson.concat(this, arrays, function));
    }
    public Array withField(String... selectors) {
        return new Array(TermType.WITH_FIELDS, ToJson.concat(this, ToJson.of(selectors)));
    }

    public Array concatMap(RFunction function) {
        return new Array(TermType.CONCAT_MAP, this, function);
    }

    public Array skip(int n) {
        return new Array(TermType.SKIP, this, ToJson.of(n));
    }

    public Array limit(int n) {
        return new Array(TermType.LIMIT, this, ToJson.of(n));
    }

    public Array slice(int startIdx) {
        return new Array(TermType.SLICE, this, ToJson.of(startIdx));
    }

    public Array slice(int startIdx, Options options) {
        return new Array(TermType.SLICE, this, ToJson.of(startIdx), options);
    }

    public Array slice(int startIdx, int endIdx) {
        return new Array(TermType.SLICE, this, ToJson.of(startIdx), ToJson.of(endIdx));
    }

    public Array slice(int startIdx, int endIdx, Options options) {
        return new Array(TermType.SLICE, this, ToJson.of(startIdx), ToJson.of(endIdx), options);
    }

    public Array union(Sequence... sequences) {
        return new Array(TermType.UNION, ToJson.concat(this, sequences));
    }

    public Array sample(int number) {
        return new Array(TermType.SAMPLE, this, ToJson.of(number));
    }

    public Array pluck(String... selectors) {
        return new Array(TermType.PLUCK, ToJson.concat(this, ToJson.of(selectors)));
    }

    public Array without(String... selectors) {
        return new Array(TermType.WITHOUT, ToJson.concat(this, ToJson.of(selectors)));
    }

    public Array merge(RObject... objects) {
        if (objects.length == 0) {
            throw new IllegalArgumentException("objects length should be more than 0");
        }
        return new Array(TermType.MERGE, ToJson.concat(this, objects));
    }

    public Array append(Value value) {
        return new Array(TermType.APPEND, this, value);
    }

    public Array prepend(Value value) {
        return new Array(TermType.PREPEND, this, value);
    }

    public Array difference(Array array) {
        return new Array(TermType.DIFFERENCE, this, array);
    }

    public Array setInsert(Value value) {
        return new Array(TermType.SET_INSERT, this, value);
    }

    public Array setUnion(Array array) {
        return new Array(TermType.SET_UNION, this, array);
    }

    public Array setIntersection(Array array) {
        return new Array(TermType.SET_INTERSECTION, this, array);
    }

    public Array setDifference(Array array) {
        return new Array(TermType.SET_DIFFERENCE, this, array);
    }

    public Array hasFields(String... selectors) {
        return new Array(TermType.HAS_FIELDS, ToJson.concat(this, ToJson.of(selectors)));
    }

    public Array insertAt(int idx, Value value) {
        return new Array(TermType.INSERT_AT, this, ToJson.of(idx), value);
    }

    public Array spliceAt(int idx, Array array) {
        return new Array(TermType.SPLICE_AT, this, ToJson.of(idx), array);
    }

    public Array deleteAt(int idx) {
        return new Array(TermType.DELETE_AT, this, ToJson.of(idx));
    }


    public Array deleteAt(int idx, int endIdx) {
        return new Array(TermType.DELETE_AT, this, ToJson.of(idx), ToJson.of(endIdx));
    }

    public Array changeAt(int idx, Value value) {
        return new Array(TermType.CHANGE_AT, this, ToJson.of(idx), value);
    }

    public RObject coerceToObject() {
        return new RObject(TermType.COERCE_TO, this, ToJson.of("object"));
    }

    public RObject info() {
        return new RObject(TermType.INFO, this);
    }
}
