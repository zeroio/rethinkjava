package z.rethink.ql;

public class KeyValue {
    private final String key;
    private final Value value;
    private KeyValue(String key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public static KeyOnly key(String key) {
        return new KeyOnly(key);
    }

    public static final class KeyOnly {
        private final String key;
        private KeyOnly(String key) {
            this.key = key;
        }

        public KeyValue value(Value value) {
            return new KeyValue(key, value);
        }
    }
}
