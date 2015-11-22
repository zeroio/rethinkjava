package z.rethink.ql;

import java.util.Base64;
import z.rethink.TermType;

public class RBinary extends Any {
    public RBinary(TermType term, byte[] data) {
        super(term, sb -> sb.append("{").append("\"$reql_type$\":\"BINARY\",\"data\":\"").append(Base64.getEncoder().encodeToString(data)).append("\"}"));
    }

    public RBinary(TermType term, ToJson... childNodes) {
        super(term, childNodes);
    }

    public RString coerceToString() {
        return new RString(TermType.COERCE_TO, this, ToJson.of("string"));
    }
}
