package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashMap;

public class Differ {
    public static String generate(Map<String, Object> fileDataMap1, Map<String, Object>  fileDataMap2)
            throws Exception {
        Map<String, Object>  fileFormattedMap1 = InnerFormatter.formatNestedData(fileDataMap1);
        Map<String, Object>  fileFormattedMap2 = InnerFormatter.formatNestedData(fileDataMap2);

        Set<String> keysForDiffer = new TreeSet<>(fileFormattedMap1.keySet());
        keysForDiffer.addAll(fileFormattedMap2.keySet());

        Map<String, Object> result = new LinkedHashMap<>();

        for (String key: keysForDiffer) {

            if (!fileFormattedMap1.containsKey(key)) {
//                added
                var value = fileFormattedMap2.get(key);
                String newKey = " + " + key;
                result.put(newKey, value);
            } else if (!fileFormattedMap2.containsKey(key)) {
//                deleted
                var value = fileFormattedMap1.get(key);
                String newKey = " - " + key;
                result.put(newKey, value);
            } else if (fileFormattedMap1.get(key).equals(fileFormattedMap2.get(key))) {
//                unchanged
                var value = fileFormattedMap1.get(key);
                String newKey = "   " + key;
                result.put(newKey, value);
            } else {
//                changed
                var oldValue = fileFormattedMap1.get(key);
                var newValue = fileFormattedMap2.get(key);
                String keyByOldValue = " - " + key;
                String keyByNewValue = " + " + key;

                result.put(keyByOldValue, oldValue);
                result.put(keyByNewValue, newValue);
            }
        }

        return OuterPrintFormatter.formatPrint("stylish", result);
    }
}
