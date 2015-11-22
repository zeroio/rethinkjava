package z.rethink.ql;

import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public interface ToJson {
    void toJson(StringBuilder builder);

    static ToJson of(String string) {
        return sb -> {
            if (string == null) {
                sb.append("null");
                return;
            }
            if (string.length() == 0) {
                sb.append("\"\"");
                return;
            }
            char c;
            int i;
            int len = string.length();
            String t;
            sb.append('"');
            for (i = 0; i < len; i += 1) {
                c = string.charAt(i);
                switch (c) {
                    case '\\':
                    case '"':
                        sb.append('\\');
                        sb.append(c);
                        break;
                    case '/':
                        //                if (b == '<') {
                        sb.append('\\');
                        //                }
                        sb.append(c);
                        break;
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    case '\f':
                        sb.append("\\f");
                        break;
                    case '\r':
                        sb.append("\\r");
                        break;
                    default:
                        if (c < ' ') {
                            t = "000" + Integer.toHexString(c);
                            sb.append("\\u").append(t.substring(t.length() - 4));
                        } else {
                            sb.append(c);
                        }
                }
            }
            sb.append('"');
        };
    }

    static ToJson[] of(String[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(char value) {
        return of(String.valueOf(value));
    }

    static ToJson[] of(char[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(long value) {
        return sb -> sb.append(String.valueOf(value));
    }

    static ToJson[] of(long[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(int value) {
        return sb -> sb.append(String.valueOf(value));
    }

    static ToJson[] of(int[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(byte value) {
        return sb -> sb.append(String.valueOf(value));
    }

    static ToJson[] of(byte[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(boolean value) {
        return sb -> sb.append(String.valueOf(value));
    }

    static ToJson[] of(boolean[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(short value) {
        return sb -> sb.append(String.valueOf(value));
    }

    static ToJson[] of(short[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(float value) {
        return sb -> sb.append(String.valueOf(value));
    }

    static ToJson[] of(float[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(double value) {
        return sb -> sb.append(String.valueOf(value));
    }

    static ToJson[] of(double[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(Number value) {
        return sb -> sb.append(String.valueOf(value));
    }

    static ToJson[] of(Number... values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(UUID value) {
        return of(value.toString());
    }

    static ToJson[] of(UUID[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson ofEpoch(long value) {
        return sb -> sb.append("{\"$reql_type$\":\"TIME\",\"epoch_time\":").append(String.valueOf(value)).append(",\"timezone\":\"+00:00\"");
    }

    static ToJson of(Date value) {
        return ofEpoch(value.getTime());
    }

    static ToJson[] of(Date[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson of(TemporalAccessor value) {
        return ofEpoch(Instant.from(value).toEpochMilli());
    }

    static ToJson[] of(TemporalAccessor[] values) {
        ToJson[] ret = new ToJson[values.length];
        for (int i = ret.length - 1; i >=0; i--) {
            ret[i] = of(values[i]);
        }
        return ret;
    }

    static ToJson[] concat(ToJson first, ToJson[] more) {
        ToJson[] ret = new ToJson[more.length + 1];
        ret[0] = first;
        System.arraycopy(more, 0, ret, 1, more.length);
        return ret;
    }

    static ToJson[] concat(ToJson first, ToJson[] more, ToJson last) {
        ToJson[] ret = new ToJson[more.length + 2];
        ret[0] = first;
        System.arraycopy(more, 0, ret, 1, more.length);
        ret[ret.length - 1] = last;
        return ret;
    }

    static ToJson[] concat(ToJson[] first, ToJson last) {
        ToJson[] ret = new ToJson[first.length + 1];
        System.arraycopy(first, 0, ret, 0, first.length);
        ret[ret.length - 1] = last;
        return ret;
    }

    static ToJson from(Object obj) {
        if (obj == null) {
            return ToJson.of((String) null);
        }
        if (obj instanceof ToJson) {
            return (ToJson) obj;
        }
        if (obj instanceof Boolean) {
            return of((Boolean) obj);
        }
        if (obj instanceof String) {
            return of((String) obj);
        }
        if (obj instanceof Character) {
            return of((Character) obj);
        }
        if (obj instanceof Number) {
            return of((Number) obj);
        }
        if (obj instanceof UUID) {
            return of((UUID) obj);
        }
        if (obj instanceof Date) {
            return of((Date) obj);
        }
        if (obj instanceof TemporalAccessor) {
            return of((TemporalAccessor) obj);
        }
        throw new IllegalArgumentException("obj type " + obj.getClass() + " is not supported");
    }

    static <T> ToJson[] from(Collection<T> values) {
        ToJson[] ret = new ToJson[values.size()];
        int i = 0;
        for (T value : values) {
            ret[i] = from(value);
            i++;
        }
        return ret;
    }

    static ToJson array(Iterable<ToJson> values) {
        return sb -> {
            sb.append("[");
            int i = 0;
            for (ToJson toJson: values) {
                if (i > 0) {
                    sb.append(",");
                }
                toJson.toJson(sb);
                i++;
            }
            sb.append("]");
        };
    }

    static ToJson array(ToJson[] values) {
        return sb ->  {
            sb.append("[");
            int i = 0;
            for (ToJson toJson: values) {
                if (i > 0) {
                    sb.append(",");
                }
                toJson.toJson(sb);
                i++;
            }
            sb.append("]");
        };
    }
}
