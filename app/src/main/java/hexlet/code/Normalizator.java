package hexlet.code;

import java.util.Collection;
import java.util.Map;

public class Normalizator {
    public static Map<String, Object> normalizeNestedToString(Map<String, Object> enterMap, String formatName)
            throws Exception {
        for (var entry : enterMap.entrySet()) {
            if ((entry.getValue() instanceof Collection<?> || entry.getValue() instanceof Map<?, ?>)
                    && formatName.equals("plain")) {
                enterMap.put(entry.getKey(), "[complex value]");
            }
            if (entry.getValue() instanceof Collection<?> || entry.getValue() instanceof Map<?, ?>) {
                enterMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return enterMap;
    }
    public static Map<String, Object> replaceNullData(Map<String, Object> enterMap) {
        for (var entry : enterMap.entrySet()) {
            if (entry.getValue() == null) {
                enterMap.put(entry.getKey(), "null");
            }
        }
        return enterMap;
    }
}
