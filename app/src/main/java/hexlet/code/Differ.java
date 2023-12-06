package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashMap;

public class Differ {
    public static String generate(Map<String, Object> fileDataMap1, Map<String, Object>  fileDataMap2,
                                  String formatName) throws Exception {
        Map<String, Object>  fileDataMapNormalizedWithoutNull1 = Normalizator.replaceNullData(fileDataMap1);
        Map<String, Object>  fileDataMapNormalizedWithoutNull2 = Normalizator.replaceNullData(fileDataMap2);

        Set<String> keysForDiffer = new TreeSet<>(fileDataMapNormalizedWithoutNull1.keySet());
        keysForDiffer.addAll(fileDataMapNormalizedWithoutNull2.keySet());
        Map<String, Object> result = new LinkedHashMap<>();

        for (String key: keysForDiffer) {

            if (!fileDataMapNormalizedWithoutNull1.containsKey(key)) {
//                added
                var value = fileDataMapNormalizedWithoutNull2.get(key);
                String newKey = key + "_added";
                result.put(newKey, value);
            } else if (!fileDataMapNormalizedWithoutNull2.containsKey(key)) {
//                deleted
                var value = fileDataMapNormalizedWithoutNull1.get(key);
                String newKey = key + "_deleted";
                result.put(newKey, value);
            } else if (fileDataMapNormalizedWithoutNull1.get(key).equals(fileDataMapNormalizedWithoutNull2.get(key))) {
//                unchanged
                var value = fileDataMapNormalizedWithoutNull1.get(key);
                String newKey = key + "_unchanged";
                result.put(newKey, value);
            } else {
//                changed
                var oldValue = fileDataMapNormalizedWithoutNull1.get(key);
                var newValue = fileDataMapNormalizedWithoutNull2.get(key);
                String keyByOldValue = key + "_old_changed";
                String keyByNewValue = key + "_new_changed";
                result.put(keyByOldValue, oldValue);
                result.put(keyByNewValue, newValue);
            }
        }

        return Formatter.printByTypeFormat(formatName, Normalizator.normalizeNestedToString(result, formatName));
    }
}
