package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static hexlet.code.DifferEngine.STATUS_ADDED;
import static hexlet.code.DifferEngine.STATUS_DELETED;
import static hexlet.code.DifferEngine.STATUS_CHANGED;

public class FormatPlain {
    public static String formatPrintPlain(Map<String, List<Object>> data) throws Exception {
        String resulString = "";

        for (var entry : data.entrySet()) {
            Object statusKey = entry.getValue().get(0);
            Object currentValue = normalizedNestedObjectData(entry.getValue().get(1));

            if (statusKey.equals(STATUS_ADDED)) {
                resulString += "Property '" + entry.getKey() + "' was added with value: " + currentValue + "\n";
            } else if (statusKey.equals(STATUS_DELETED)) {
                resulString += "Property '" + entry.getKey() + "' was removed\n";
            } else if (statusKey.equals(STATUS_CHANGED)) {
                resulString += "Property '" + entry.getKey() + "' was updated. From " + currentValue
                        + " to " + normalizedNestedObjectData(entry.getValue().get(2)) + "\n";
            }
        }
        System.out.println(resulString);

        return resulString.substring(0, resulString.length() - 1);
    }
    private static String normalizedNestedObjectData(Object object) {
        if (object instanceof String) {
            return "'" + object + "'";
        }
        if (object instanceof Map || object instanceof Collection<?>) {
            return "[complex value]";
        }
        if (Objects.isNull(object)) {
            return "null";
        }
        return object.toString();
    }
}
