package z.rethink.ql;

import java.util.Arrays;
import z.rethink.TermType;

import java.util.ArrayList;
import java.util.List;

public class Any implements ToJson {
    protected final TermType term;
    protected final List<ToJson> children = new ArrayList<>();

    public Any(Any node) {
        this.term = node.term;
        children.addAll(node.children);
    }

    public Any(TermType term, ToJson... childNodes) {
        this.term = term;
        children.addAll(Arrays.asList(childNodes));
    }

    public Any call(RFunction function) {
        return new Any(TermType.FUNCALL, this, function);
    }

    public RString typeOf() {
        return new RString(TermType.TYPE_OF, this);
    }

    @Override
    public void toJson(StringBuilder builder) {
        builder.append('[').append(String.valueOf(term.getValue())).append(",[");
        int length = children.size();
        for (int i = 0; i < length; i++) {
            ToJson child = children.get(i);
            if (i > 0) {
                builder.append(',');
            }
            if (child == null) {
                builder.append(String.valueOf(null));
            } else {
                child.toJson(builder);
            }
        }
        builder.append("]]");
    }
}
