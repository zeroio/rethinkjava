package z.rethink.ql;

import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import z.rethink.TermType;

public class R {
    public RObject dbCreate(String name) {
        return new RObject(TermType.DB_CREATE, ToJson.of(name));
    }

    public RObject dbDrop(String name) {
        return new RObject(TermType.DB_CREATE, ToJson.of(name));
    }

    public Array dbList() {
        return new Array(TermType.DB_LIST);
    }

    public RObject tableCreate(String name) {
        return new RObject(TermType.TABLE_CREATE, ToJson.of(name));
    }

    public RObject tableCreate(String name, Options options) {
        return new RObject(TermType.TABLE_CREATE, ToJson.of(name), options);
    }

    public Db db(String name) {
        return new Db(name);
    }

    public Table table(String name) {
        return new Table(name);
    }

    public Table table(String name, Options options) {
        return new Table(name, options);
    }

    public Stream map(RFunction function, Sequence... sequences) {
        return new Stream(TermType.MAP, ToJson.concat(sequences, function));
    }

    public Array map(RFunction function, Array... arrays) {
        return new Array(TermType.MAP, ToJson.concat(arrays, function));
    }

    public Value row() {
        return new Value(TermType.IMPLICIT_VAR);
    }

    public Value row(String field) {
        return new Value(TermType.GET_FIELD, new Value(TermType.IMPLICIT_VAR), ToJson.of(field));
    }

    public Special literal(RObject object) {
        return new Special(TermType.LITERAL, object);
    }

    public RObject object(KeyValue... keyValues) {
        ToJson[] params = new ToJson[keyValues.length * 2];
        for (int i = 0; i < keyValues.length; i++) {
            KeyValue keyValue = keyValues[i];
            params[i*2] = ToJson.of(keyValue.getKey());
            params[i*2 + 1] = keyValue.getValue();
        }
        return new RObject(TermType.MAKE_OBJ, params);
    }

    public RBoolean and(RBoolean bool, RBoolean... bools) {
        RBoolean ret = new RBoolean(TermType.DATUM, bool);
        if (bools.length > 0) {
            ret = ret.and(bools);
        }
        return ret;
    }

    public RBoolean or(RBoolean bool, RBoolean... bools) {
        RBoolean ret = new RBoolean(TermType.DATUM, bool);
        if (bools.length > 0) {
            ret = ret.or(bools);
        }
        return ret;
    }

    public RBoolean not(RBoolean bool) {
        return new RBoolean(TermType.DATUM, bool).not();
    }

    public RNumber random(long number) {
        return new RNumber(TermType.RANDOM, ToJson.of(number));
    }

    public RNumber random(long left, long right) {
        return new RNumber(TermType.RANDOM, ToJson.of(left), ToJson.of(right));
    }

    public RNumber round(RNumber number) {
        return new RNumber(TermType.ROUND, number);
    }

    public RNumber cell(RNumber number) {
        return new RNumber(TermType.CEIL, number);
    }

    public RNumber floor(RNumber number) {
        return new RNumber(TermType.FLOOR, number);
    }

    public RTime now() {
        return new RTime(TermType.NOW);
    }

    public RTime time(int year, int month, int day) {
        return new RTime(TermType.TIME, ToJson.of(year), ToJson.of(month), ToJson.of(day));
    }

    public RTime time(int year, int month, int day, String timeZone) {
        return new RTime(TermType.TIME, ToJson.of(year), ToJson.of(month), ToJson.of(day), ToJson.of(timeZone));
    }

    public RTime time(int year, int month, int day, int hour, int mins, int seconds, String timeZone) {
        return new RTime(TermType.TIME, ToJson.of(year), ToJson.of(month), ToJson.of(day), ToJson.of(hour), ToJson.of(mins), ToJson.of(seconds), ToJson.of(timeZone));
    }

    public RTime time(int year, int month, int day, int hour, int mins, int seconds) {
        return new RTime(TermType.TIME, ToJson.of(year), ToJson.of(month), ToJson.of(day), ToJson.of(hour), ToJson.of(mins), ToJson.of(seconds));
    }

    public RTime epochTime(long value) {
        return new RTime(TermType.EPOCH_TIME, ToJson.of(value));
    }

    public RTime iso8601(String value) {
        return new RTime(TermType.ISO8601, ToJson.of(value));
    }

    public RTime iso8601(String value, Options options) {
        return new RTime(TermType.ISO8601, ToJson.of(value), options);
    }

    public Special args(Array array) {
        return new Special(TermType.ARGS, array);
    }

    public RBinary binary(byte[] data) {
        return new RBinary(TermType.DATUM, data);
    }

    public Any call(RFunction function) {
        return new Any(TermType.FUNCALL, function);
    }

    public Any branch(RBoolean con, Any trueAction, Any falseAction) {
        return new RBinary(TermType.BRANCH, con, trueAction, falseAction);
    }

    public Any branch(RBoolean con1, Any trueAction1, RBoolean con2, Any trueAction2, Any falseAction) {
        return new RBinary(TermType.BRANCH, con1, trueAction1, con2, trueAction2, falseAction);
    }

    public Any branch(RBoolean con1, Any trueAction1, RBoolean con2, Any trueAction2, RBoolean con3, Any trueAction3, Any falseAction) {
        return new RBinary(TermType.BRANCH, con1, trueAction1, con2, trueAction2, con3, trueAction3, falseAction);
    }

    public Any branch(RBoolean con1, Any trueAction1, RBoolean con2, Any trueAction2, RBoolean con3, Any trueAction3, RBoolean con4, Any trueAction4,  Any falseAction) {
        return new RBinary(TermType.BRANCH, con1, trueAction1, con2, trueAction2, con3, trueAction3, con4, trueAction4, falseAction);
    }

    public Stream range(int end) {
        return new Stream(TermType.RANGE, ToJson.of(end));
    }

    public Stream range(int start, int end) {
        return new Stream(TermType.RANGE, ToJson.of(start), ToJson.of(end));
    }

    public Error error(String message) {
        return new Error(TermType.ERROR, ToJson.of(message));
    }

    public RBoolean expr(boolean val) {
        return new RBoolean(TermType.DATUM, ToJson.of(val));
    }

    public RString expr(char val) {
        return new RString(TermType.DATUM, ToJson.of(val));
    }

    public RString expr(String val) {
        return new RString(TermType.DATUM, ToJson.of(val));
    }

    public RNumber expr(byte val) {
        return new RNumber(TermType.DATUM, ToJson.of(val));
    }

    public RNumber expr(short val) {
        return new RNumber(TermType.DATUM, ToJson.of(val));
    }

    public RNumber expr(int val) {
        return new RNumber(TermType.DATUM, ToJson.of(val));
    }

    public RNumber expr(long val) {
        return new RNumber(TermType.DATUM, ToJson.of(val));
    }

    public RNumber expr(float val) {
        return new RNumber(TermType.DATUM, ToJson.of(val));
    }

    public RNumber expr(double val) {
        return new RNumber(TermType.DATUM, ToJson.of(val));
    }

    public RNumber expr(Number val) {
        return new RNumber(TermType.DATUM, ToJson.of(val));
    }

    public RTime expr(Date date) {
        return epochTime(date.getTime());
    }

    public RTime expr(TemporalAccessor date) {
        return epochTime(Instant.from(date).toEpochMilli());
    }

    public RString expr(UUID val) {
        return new RString(TermType.DATUM, ToJson.of(val));
    }

    public Array expr(boolean[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public Array expr(char[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public Array expr(byte[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public Array expr(short[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public Array expr(int[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public Array expr(long[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public Array expr(float[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public Array expr(double[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public Array expr(Number[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public Array expr(String[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public Array expr(UUID[] values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.of(values));
    }

    public <T> Array expr(Collection<T> values) {
        return new Array(TermType.MAKE_ARRAY, ToJson.from(values));
    }

    public RJS js(String jsString) {
        return new RJS(TermType.JAVASCRIPT, ToJson.of(jsString));
    }

    public RJS js(String jsString, Options options) {
        return new RJS(TermType.JAVASCRIPT, ToJson.of(jsString), options);
    }

    public Value json(String jsonString) {
        return new Value(TermType.JSON, ToJson.of(jsonString));
    }

    public Value http(String url) {
        return new Value(TermType.HTTP, ToJson.of(url));
    }

    public Value http(String url, Options options) {
        return new Value(TermType.HTTP, ToJson.of(url), options);
    }

    public RString uuid() {
        return new RString(TermType.UUID);
    }

    public RString uuid(String value) {
        return new RString(TermType.UUID, ToJson.of(value));
    }

    public Geometry circle(double longitude, double latitude, double radius) {
        return new Geometry(TermType.CIRCLE, ToJson.array(ToJson.of(new double[]{longitude, latitude})), ToJson.of(radius));
    }

    public Geometry circle(double longitude, double latitude, double radius, Options options) {
        return new Geometry(TermType.CIRCLE, ToJson.array(ToJson.of(new double[]{longitude, latitude})), ToJson.of(radius), options);
    }

    public RNumber distance(Geometry from, Geometry to) {
        return new RNumber(TermType.DISTANCE, from, to);
    }

    public Geometry geojson(GeoJson geojson) {
        return new Geometry(TermType.GEOJSON, geojson);
    }

    public Sequence intersects(Sequence sequence, Geometry geometry) {
        return new DefaultSequence(TermType.INTERSECTS, sequence, geometry);
    }

    public RBoolean intersects(Geometry geo1, Geometry geo2) {
        return new RBoolean(TermType.INTERSECTS, geo1, geo2);
    }

    public Line line(LongLat... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new Line(TermType.LINE, values);
    }

    public Line line(Point... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new Line(TermType.LINE, values);
    }

    public Point point(double lon, double lat) {
        return new Point(TermType.POINT, ToJson.of(lon), ToJson.of(lat));
    }

    public Polygon polygon(LongLat... longLats) {
        return new Polygon(TermType.POLYGON, longLats);
    }

    public Polygon polygon(Point... points) {
        return new Polygon(TermType.POLYGON, points);
    }

    public RObject waitFor() {
        return new RObject(TermType.WAIT);
    }

    public RObject waitFor(Options options) {
        return new RObject(TermType.WAIT, options);
    }
}
