package z.rethink.ql;
import z.rethink.TermType;

public class Table extends Any implements Sequence {

    public Table(String name) {
        super(TermType.TABLE, ToJson.of(name));
    }

    public Table(String name, Options options) {
        super(TermType.TABLE, ToJson.of(name), options);
    }

    public Table(Any prev, String name) {
        super(TermType.TABLE, prev, ToJson.of(name));
    }

    public Table(Any prev, String name, Options options) {
        super(TermType.TABLE, prev, ToJson.of(name), options);
    }

    public RObject indexCreate(String name) {
        return new RObject(TermType.INDEX_CREATE, this, ToJson.of(name));
    }

    public RObject indexCreate(String name, RFunction function) {
        return new RObject(TermType.INDEX_CREATE, this, ToJson.of(name), function);
    }

    public RObject indexDrop(String name) {
        return new RObject(TermType.INDEX_DROP, this, ToJson.of(name));
    }

    public Array indexList() {
        return new Array(TermType.INDEX_LIST, this);
    }

    public RObject indexRename(String name, String newName) {
        return new RObject(TermType.INDEX_RENAME, this, ToJson.of(name), ToJson.of(newName));
    }

    public RObject indexRename(String name, String newName, Options options) {
        return new RObject(TermType.INDEX_RENAME, this, ToJson.of(name), ToJson.of(newName), options);
    }

    public Array indexStatus(String... names) {
        return new Array(TermType.INDEX_STATUS, ToJson.concat(this, ToJson.of(names)));
    }

    public Array indexWait(String... names) {
        return new Array(TermType.INDEX_WAIT, ToJson.concat(this, ToJson.of(names)));
    }

    public RObject insert(Options options, RObject... objects) {
        return new RObject(TermType.INSERT, ToJson.concat(this, objects, options));
    }

    public RObject insert(RObject... objects) {
        return new RObject(TermType.INSERT, ToJson.concat(this, objects));
    }

    public RObject update(RObject object) {
        return new RObject(TermType.UPDATE, this, object);
    }

    public RObject update(RObject object, Options options) {
        return new RObject(TermType.UPDATE, this, object, options);
    }

    public RObject update(RFunction object) {
        return new RObject(TermType.UPDATE, this, object);
    }

    public RObject update(RFunction object, Options options) {
        return new RObject(TermType.UPDATE, this, object, options);
    }

    public RObject replace(RObject object) {
        return new RObject(TermType.REPLACE, this, object);
    }

    public RObject replace(RObject object, Options options) {
        return new RObject(TermType.REPLACE, this, object, options);
    }

    public RObject replace(RFunction object) {
        return new RObject(TermType.REPLACE, this, object);
    }

    public RObject replace(RFunction object, Options options) {
        return new RObject(TermType.REPLACE, this, object, options);
    }

    public RObject delete() {
        return new RObject(TermType.DELETE, this);
    }

    public RObject delete(Options options) {
        return new RObject(TermType.DELETE, this, options);
    }

    public RObject sync() {
        return new RObject(TermType.SYNC, this);
    }

    public SingleSelection get(Value key) {
        return new SingleSelection(TermType.GET, this, key);
    }

    public Selection getAll(Options options, Value... keys) {
        Validations.checkLengthNotZero("keys", keys.length);
        return new DefaultSelection(TermType.GET_ALL, ToJson.concat(this, keys, options));
    }

    public Selection getAll(Value... keys) {
        Validations.checkLengthNotZero("keys", keys.length);
        return new DefaultSelection(TermType.GET_ALL, ToJson.concat(this, keys));
    }

    public TableSlice between(Value left, Value right) {
        return new TableSlice(TermType.BETWEEN, this, left, right);
    }

    public TableSlice between(Value left, Value right, Options options) {
        return new TableSlice(TermType.BETWEEN, this, left, right, options);
    }

    public SelectionObject config() {
        return new SelectionObject(TermType.CONFIG, this);
    }

    public RObject rebalance() {
        return new RObject(TermType.REBALANCE, this);
    }

    public RObject reconfigure(Options options) {
        return new RObject(TermType.RECONFIGURE, this, options);
    }

    public SelectionObject status() {
        return new SelectionObject(TermType.STATUS, this);
    }


    public TableSlice orderBy(OrderBy order) {
        return new TableSlice(TermType.ORDER_BY, this, order);
    }

    public TableSlice orderBy(OrderBy order, Options options) {
        return new TableSlice(TermType.ORDER_BY, this, order, options);
    }

    public Stream getIntersecting(Geometry geometry) {
        return new Stream(TermType.GET_INTERSECTING, this, geometry);
    }

    public Stream getIntersecting(Geometry geometry, Options options) {
        return new Stream(TermType.GET_INTERSECTING, this, geometry, options);
    }

    public SelectionArray getNearest(Point point) {
        return new SelectionArray(TermType.GET_NEAREST, this);
    }

    public SelectionArray getNearest(Point point, Options options) {
        return new SelectionArray(TermType.GET_NEAREST, this, options);
    }

    public RObject waitFor() {
        return new RObject(TermType.WAIT, this);
    }

    public RObject waitFor(Options options) {
        return new RObject(TermType.WAIT, this, options);
    }
}
