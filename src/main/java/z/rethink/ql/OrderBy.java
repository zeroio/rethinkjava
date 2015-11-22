package z.rethink.ql;

public class OrderBy extends ToJsons {
    public void by(String field) {
        add(ToJson.of(field));
    }

    public void by(RFunction function) {
        add(function);
    }
}
