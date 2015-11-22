package z.rethink.ql;

import z.rethink.TermType;

public class Db extends Any {

    public Db(String name)
    {
        super(TermType.DB, ToJson.of(name));
    }

    public Table table(String name) {
        return new Table(this, name);
    }

    public Table table(String name, Options options) {
        return new Table(this, name, options);
    }

    public RObject tableCreate(String name) {
        return new RObject(TermType.TABLE_CREATE, this, ToJson.of(name));
    }

    public RObject tableCreate(String name, Options options) {
        return new RObject(TermType.TABLE_CREATE, this, ToJson.of(name), options);
    }

    public RObject tableDrop(String name) {
        return new RObject(TermType.TABLE_DROP, this, ToJson.of(name));
    }

    public Array tableList() {
        return new Array(TermType.TABLE_LIST, this);
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

    public RObject waitFor() {
        return new RObject(TermType.WAIT, this);
    }

    public RObject waitFor(Options options) {
        return new RObject(TermType.WAIT, this, options);
    }
}
