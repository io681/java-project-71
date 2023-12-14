package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static hexlet.code.DifferEngine.STATUS_ADDED;
import static hexlet.code.DifferEngine.STATUS_DELETED;
import static hexlet.code.DifferEngine.STATUS_CHANGED;
import static hexlet.code.DifferEngine.STATUS_UNCHANGED;

public class FormatPlain {
    public static String formatPrintPlain(Map<String, List<Object>> data) {
        StringBuilder resultString = new StringBuilder();
        for (var entry : data.entrySet()) {
            Object statusKey = entry.getValue().get(0);
            Object currentValue = normalizedNestedObjectData(entry.getValue().get(1));
            switch (statusKey.toString()) {
                case STATUS_ADDED -> resultString.append("Property '")
                        .append(entry.getKey()).append("' was added with value: ").append(currentValue).append("\n");
                case STATUS_DELETED -> resultString.append("Property '")
                        .append(entry.getKey()).append("' was removed\n");
                case STATUS_CHANGED -> resultString.append("Property '")
                        .append(entry.getKey()).append("' was updated. From ")
                        .append(currentValue).append(" to ")
                        .append(normalizedNestedObjectData(entry.getValue().get(2))).append("\n");
                case STATUS_UNCHANGED -> {
                }
                default -> throw new RuntimeException("Unknown statusKey");
            }
        }
        return resultString.substring(0, resultString.length() - 1);
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
