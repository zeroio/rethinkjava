package z.rethink.ql;

import z.rethink.TermType;

public class Stream extends Any implements Sequence {
    public Stream(Any node) {
        super(node);
    }

    public Stream(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public Selection asSelection() {
        return new DefaultSelection(this);
    }

    public Stream changes() {
        return new Stream(TermType.CHANGES, this);
    }

    public Stream changes(Options options) {
        return new Stream(TermType.CHANGES, this, options);
    }

    public Stream filter(PredicateFunction function, Options options) {
        return new Stream(TermType.FILTER, this, function, options);
    }

    public Stream filter(PredicateFunction function) {
        return new Stream(TermType.FILTER, this, function);
    }

    public Stream zip() {
        return new Stream(TermType.ZIP, this);
    }

    public Stream concatMap(RFunction function) {
        return new Stream(TermType.CONCAT_MAP, this, function);
    }

    public Stream slice(int startIdx) {
        return new Stream(TermType.SLICE, this, ToJson.of(startIdx));
    }

    public Stream slice(int startIdx, Options options) {
        return new Stream(TermType.SLICE, this, ToJson.of(startIdx), options);
    }

    public Stream slice(int startIdx, int endIdx) {
        return new Stream(TermType.SLICE, this, ToJson.of(startIdx), ToJson.of(endIdx));
    }

    public Stream slice(int startIdx, int endIdx, Options options) {
        return new Stream(TermType.SLICE, this, ToJson.of(startIdx), ToJson.of(endIdx), options);
    }

    public Stream union(Sequence... sequences) {
        return new Stream(TermType.UNION, ToJson.concat(this, sequences));
    }

    public Stream sample(int number) {
        return new Stream(TermType.SAMPLE, this, ToJson.of(number));
    }

    public GroupedStream group(GroupBy groupBy) {
        return new GroupedStream(TermType.GROUP, this, groupBy);
    }

    public GroupedStream group(GroupBy groupBy, Options options) {
        return new GroupedStream(TermType.GROUP, this, groupBy, options);
    }
}
