package z.rethink.ql;

import z.rethink.TermType;

public class RTime extends Value {

    public RTime(Any node) {
        super(node);
    }

    public RTime(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public RTime add(RTime... values) {
        Validations.checkLengthNotZero("values", values.length);
        return new RTime(TermType.ADD, ToJson.concat(this, values));
    }

    public RTime inTimezone(String timeZone) {
        return new RTime(TermType.IN_TIMEZONE, this, ToJson.of(timeZone));
    }

    public RString timezone() {
        return new RString(TermType.TIMEZONE, this);
    }

    public RBoolean during(RTime start, RTime end) {
        return new RBoolean(TermType.DURING, this, start, end);
    }

    public RBoolean during(RTime start, RTime end, Options options) {
        return new RBoolean(TermType.DURING, this, start, end, options);
    }

    public RTime date() {
        return new RTime(TermType.DATE, this);
    }

    public RNumber timeOfDay() {
        return new RNumber(TermType.TIME_OF_DAY, this);
    }

    public RNumber year() {
        return new RNumber(TermType.YEAR, this);
    }

    public RNumber month() {
        return new RNumber(TermType.MONTH, this);
    }

    public RNumber day() {
        return new RNumber(TermType.DAY, this);
    }

    public RNumber dayOfWeek() {
        return new RNumber(TermType.DAY_OF_WEEK, this);
    }

    public RNumber dayOfYear() {
        return new RNumber(TermType.DAY_OF_YEAR, this);
    }

    public RNumber hours() {
        return new RNumber(TermType.HOURS, this);
    }

    public RNumber minutes() {
        return new RNumber(TermType.MINUTES, this);
    }

    public RNumber seconds() {
        return new RNumber(TermType.MINUTES, this);
    }

    public RNumber toEpochTime() {
        return new RNumber(TermType.TO_EPOCH_TIME, this);
    }
}
