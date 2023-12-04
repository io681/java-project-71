package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String fileContent1, String fileContent2) throws Exception {
        Map<String, Object> fileMap1 = getData(fileContent1);
        Map<String, Object> fileMap2 = getData(fileContent2);
        Set<String> keysByJson = new TreeSet<>(fileMap1.keySet());
        keysByJson.addAll(fileMap2.keySet());

        Map<String, Object> result = new LinkedHashMap<>();

        String resulString = "";

        for (String key: keysByJson) {

            if (!fileMap1.containsKey(key)) {
//                added
                var value = fileMap2.get(key);
                String newKey = " + " + key;
                result.put(newKey, value);
            } else if (!fileMap2.containsKey(key)) {
//                deleted
                var value = fileMap1.get(key);
                String newKey = " - " + key;
                result.put(newKey, value);
            } else if (fileMap1.get(key).equals(fileMap2.get(key))) {
//                unchanged
                var value = fileMap1.get(key);
                String newKey = "   " + key;
                result.put(newKey, value);
            } else {
//                changed
                var oldValue = fileMap1.get(key);
                var newValue = fileMap2.get(key);
                String keyByOldValue = " - " + key;
                String keyByNewValue = " + " + key;

                result.put(keyByOldValue, oldValue);
                result.put(keyByNewValue, newValue);
            }
        }

        for (var entry : result.entrySet()) {
            resulString += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        resulString = "{\n" + resulString + "}";
        System.out.println(resulString);

        return resulString;
    }

    public static Map<String, Object> getData(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
