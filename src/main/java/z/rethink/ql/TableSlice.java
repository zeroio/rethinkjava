package z.rethink.ql;

import z.rethink.TermType;

public class TableSlice extends SelectionArray {

    protected TableSlice(Any node) {
        super(node);
    }

    public TableSlice(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public TableSlice between(String left, String right, Options options) {
        return new TableSlice(TermType.BETWEEN, ToJson.of(left), ToJson.of(right), options);
    }

    public <T extends Number> TableSlice between(T left, T right, Options options) {
        return new TableSlice(TermType.BETWEEN, ToJson.of(left), ToJson.of(right), options);
    }

    public TableSlice between(String left, String right) {
        return new TableSlice(TermType.BETWEEN, ToJson.of(left), ToJson.of(right));
    }

    public <T extends Number> TableSlice between(T left, T right) {
        return new TableSlice(TermType.BETWEEN, ToJson.of(left), ToJson.of(right));
    }
}
