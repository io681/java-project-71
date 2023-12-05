package hexlet.code;

import java.util.Collection;
import java.util.Map;

public class InnerFormatter {
    public static Map<String, Object> formatNestedData(Map<String, Object> enterMap) throws Exception {
        for (var entry : enterMap.entrySet()) {
            if (entry.getValue() instanceof Collection<?> || entry.getValue() instanceof Map<?, ?>) {
                enterMap.put(entry.getKey(), entry.getValue().toString());
            }
            if (entry.getValue() == null) {
                enterMap.put(entry.getKey(), "null");
            }
        }
        return enterMap;
    }
}
