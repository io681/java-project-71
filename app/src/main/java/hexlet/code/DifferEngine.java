package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Objects;

public class DifferEngine {

    public static final String STATUS_UNCHANGED = "unchanged";
    public static final String STATUS_CHANGED = "changed";
    public static final String STATUS_DELETED = "deleted";
    public static final String STATUS_ADDED = "added";
    public static Map<String, List<Object>> computeDiff(Map<String, Object>  map1, Map<String, Object>  map2) {
        SortedMap<String, List<Object>> resultMap = new TreeMap<>();
        Set<String> keySetDiffer = new TreeSet<>(map1.keySet());
        keySetDiffer.addAll(map1.keySet());
        keySetDiffer.addAll(map2.keySet());

        for (String key: keySetDiffer) {

            if (!map1.containsKey(key)) {
                resultMap.put(key, Arrays.asList(STATUS_ADDED, map2.get(key)));
            } else if (!map2.containsKey(key)) {
                resultMap.put(key, Arrays.asList(STATUS_DELETED, map1.get(key)));
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                resultMap.put(key, Arrays.asList(STATUS_UNCHANGED, map1.get(key)));
            } else {
                resultMap.put(key, Arrays.asList(STATUS_CHANGED, map1.get(key), map2.get(key)));
            }
        }

        return resultMap;
    }
}
