package z.rethink.ql;

import java.util.ArrayList;
import java.util.List;

public class ToJsons implements ToJson {
    private final List<ToJson> children = new ArrayList<>(10);

    protected void add(ToJson child) {
        children.add(child);
    }

    @Override
    public void toJson(StringBuilder sb) {
        int i = 0;
        for (ToJson toJson: children) {
            if (i > 0) {
                sb.append(",");
            }
            toJson.toJson(sb);
            i++;
        }
    }
}
