package hexlet.code.formatters;

import java.util.Map;

public class FormatPlain {
    public static String formatPrintPlain(Map<String, Object> data) throws Exception {
        String resulString = "";
        for (var entry : data.entrySet()) {
            if (entry.getValue() instanceof String && !entry.getValue().equals("[complex value]")
                    && !entry.getValue().equals("null")) {
                data.put(entry.getKey(), "'" + entry.getValue()  + "'");
            }
        }

        for (var entry : data.entrySet()) {
            if (entry.getKey().endsWith("_added")) {
                String newKeyForSprint = entry.getKey().split("_")[0];
                resulString += "Property '" + newKeyForSprint + "' was added with value: " + entry.getValue() + "\n";
            } else if (entry.getKey().endsWith("_deleted")) {
                String newKeyForSprint = entry.getKey().split("_")[0];
                resulString += "Property '" + newKeyForSprint + "' was removed\n";
            } else if (entry.getKey().endsWith("old_changed")) {
                String newKeyForSprint = entry.getKey().split("_")[0];
                var oldValue = entry.getValue();
                var newValue = data.get(newKeyForSprint + "_new_changed");
                resulString += "Property '" + newKeyForSprint + "' was updated. From " + oldValue
                        + " to " + newValue + "\n";
            }
        }
        System.out.println(resulString);

        return resulString.substring(0, resulString.length() - 1);
    }
}
