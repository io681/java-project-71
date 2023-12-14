package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

import static hexlet.code.DifferEngine.STATUS_ADDED;
import static hexlet.code.DifferEngine.STATUS_DELETED;
import static hexlet.code.DifferEngine.STATUS_CHANGED;
import static hexlet.code.DifferEngine.STATUS_UNCHANGED;

public class FormatStylish {
    public static String formatPrintStylish(Map<String, List<Object>> dataForPrint) {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{\n");
        for (var entry : dataForPrint.entrySet()) {
            Object statusKey = entry.getValue().get(0);
            Object currentValue = entry.getValue().get(1);
            switch (statusKey.toString()) {
                case STATUS_ADDED -> resultString.append(" + ")
                        .append(entry.getKey()).append(": ").append(currentValue).append("\n");
                case STATUS_DELETED -> resultString.append(" - ")
                        .append(entry.getKey()).append(": ").append(currentValue).append("\n");
                case STATUS_UNCHANGED -> resultString.append("   ")
                        .append(entry.getKey()).append(": ").append(currentValue).append("\n");
                case STATUS_CHANGED -> resultString.append(" - ")
                        .append(entry.getKey()).append(": ").append(currentValue).append("\n")
                        .append(" + ")
                        .append(entry.getKey()).append(": ").append(entry.getValue().get(2)).append("\n");
                default -> throw new RuntimeException("Unknown statusKey");
            }

        }
        resultString.append("}");
        return resultString.substring(0, resultString.length());
    }
}
