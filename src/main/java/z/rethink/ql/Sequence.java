package z.rethink.ql;


import z.rethink.TermType;

public interface Sequence extends ToJson {

    default Sequence filter(PredicateFunction function) {
        return new DefaultSequence(TermType.FILTER, this, function);
    }

    default Sequence filter(PredicateFunction function, Options options) {
        return new DefaultSequence(TermType.FILTER, this, function, options);
    }

    default Stream innerJoin(Sequence sequence, PredicateFunction function) {
        return new Stream(TermType.INNER_JOIN, this, function);
    }

    default Stream outerJoin(Sequence sequence, PredicateFunction function) {
        return new Stream(TermType.OUTER_JOIN, this, function);
    }

    default Sequence eqJoin(String leftField, Table rightTable, Options options) {
        return new DefaultSequence(TermType.EQ_JOIN, this, ToJson.of(leftField), rightTable, options);
    }

    default Sequence eqJoin(String leftField, Table rightTable) {
        return new DefaultSequence(TermType.EQ_JOIN, this, ToJson.of(leftField), rightTable);
    }

    default Stream outerJoin(PredicateFunction function, Table rightTable) {
        return new Stream(TermType.EQ_JOIN, this, function, rightTable);
    }

    default Sequence map(RFunction function, Sequence... sequences) {
        return new DefaultSequence(TermType.MAP, ToJson.concat(this, sequences, function));
    }

    default Stream withFieldAll(String... selectors) {
        return new Stream(TermType.WITH_FIELDS, ToJson.concat(this, ToJson.of(selectors)));
    }

    default Array orderBy(OrderBy order) {
        return new Array(TermType.ORDER_BY, this, order);
    }

    default Stream skip(int n) {
        return new Stream(TermType.SKIP, this, ToJson.of(n));
    }

    default Stream limit(int n) {
        return new Stream(TermType.LIMIT, this, ToJson.of(n));
    }

    default RObject nth(int idx) {
        return new RObject(TermType.NTH, this, ToJson.of(idx));
    }

    default Array offsetOf(PredicateFunction function) {
        return new Array(TermType.OFFSETS_OF, this, function);
    }

    default RBoolean isEmpty() {
        return new RBoolean(TermType.IS_EMPTY, this);
    }

    default Sequence sample(int number) {
        return new DefaultSequence(TermType.SAMPLE, this, ToJson.of(number));
    }

    default Value reduce(RFunction function) {
        return new Value(TermType.REDUCE, this, function);
    }

    default RNumber count() {
        return new RNumber(TermType.COUNT, this);
    }

    default RNumber count(PredicateFunction function) {
        return new RNumber(TermType.COUNT, this, function);
    }

    default RNumber sum() {
        return new RNumber(TermType.SUM, this);
    }

    default RNumber sum(String field) {
        return new RNumber(TermType.SUM, this, ToJson.of(field));
    }

    default RNumber sum(RFunction function) {
        return new RNumber(TermType.SUM, this, function);
    }

    default RNumber avg() {
        return new RNumber(TermType.AVG, this);
    }

    default RNumber avg(String field) {
        return new RNumber(TermType.AVG, this, ToJson.of(field));
    }

    default RNumber avg(RFunction function) {
        return new RNumber(TermType.AVG, this, function);
    }

    default RNumber min(String field) {
        return new RNumber(TermType.MIN, this, ToJson.of(field));
    }

    default RNumber min(RFunction function) {
        return new RNumber(TermType.MIN, this, function);
    }

    default RNumber min(Options options) {
        return new RNumber(TermType.MIN, this, options);
    }

    default RNumber max(String field) {
        return new RNumber(TermType.MAX, this, ToJson.of(field));
    }

    default RNumber max(RFunction function) {
        return new RNumber(TermType.MAX, this, function);
    }

    default RNumber max(Options options) {
        return new RNumber(TermType.MAX, this, options);
    }

    default Array distinct() {
        return new Array(TermType.DISTINCT, this);
    }

    default Array distinct(Options options) {
        return new Array(TermType.DISTINCT, this, options);
    }

    default RBoolean contains(String value) {
        return new RBoolean(TermType.CONTAINS, this, ToJson.of(value));
    }

    default RBoolean contains(boolean value) {
        return new RBoolean(TermType.CONTAINS, this, ToJson.of(value));
    }

    default RBoolean contains(char value) {
        return new RBoolean(TermType.CONTAINS, this, ToJson.of(value));
    }

    default  <T extends Number> RBoolean contains(T value) {
        return new RBoolean(TermType.CONTAINS, this, ToJson.of(value));
    }

    default RBoolean contains(PredicateFunction function) {
        return new RBoolean(TermType.CONTAINS, this, function);
    }

    default Stream pluckAll(String... selectors) {
        return new Stream(TermType.PLUCK, ToJson.concat(this, ToJson.of(selectors)));
    }

    default Stream withoutAll(String... selectors) {
        return new Stream(TermType.WITHOUT, ToJson.concat(this, ToJson.of(selectors)));
    }

    default Stream mergeAll(RObject... objects) {
        Validations.checkLengthNotZero("objects", objects.length);
        return new Stream(TermType.MERGE, ToJson.concat(this, objects));
    }

    default Sequence getFieldAll(String attr) {
        return new DefaultSequence(TermType.GET_FIELD, ToJson.of(attr));
    }

    default Stream hasFieldsAll(String... selectors) {
        return new Stream(TermType.HAS_FIELDS, ToJson.of(selectors));
    }

    default RObject forEach(RFunction function) {
        return new RObject(TermType.FOR_EACH, this, function);
    }

    default Any defaultVal(Value value) {
        return new Any(TermType.DEFAULT, this, value);
    }

    default Any defaultVal(RFunction function) {
        return new Any(TermType.DEFAULT, this, function);
    }

    default Array coerceToArray() {
        return new Array(TermType.COERCE_TO, this, ToJson.of("array"));
    }

    default RObject coerceToObject() {
        return new RObject(TermType.COERCE_TO, this, ToJson.of("object"));
    }

    default Sequence includes(Geometry geometry) {
        return new DefaultSequence(TermType.INCLUDES, this, geometry);
    }

    default Sequence intersects(Geometry geometry) {
        return new DefaultSequence(TermType.INTERSECTS, this, geometry);
    }
}