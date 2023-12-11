package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

import static hexlet.code.DifferEngine.STATUS_ADDED;
import static hexlet.code.DifferEngine.STATUS_DELETED;
import static hexlet.code.DifferEngine.STATUS_CHANGED;
import static hexlet.code.DifferEngine.STATUS_UNCHANGED;

public class FormatStylish {
    public static String formatPrintStylish(Map<String, List<Object>> dataForPrint) {
        String resulString = "";

        for (var entry : dataForPrint.entrySet()) {
            Object statusKey = entry.getValue().get(0);
            Object currentValue = entry.getValue().get(1);

            if (statusKey.equals(STATUS_ADDED)) {
                resulString += " + " + entry.getKey() + ": " + currentValue + "\n";
            } else if (statusKey.equals(STATUS_DELETED)) {
                resulString += " - " + entry.getKey() + ": " + currentValue + "\n";
            } else if (statusKey.equals(STATUS_UNCHANGED)) {
                resulString += "   " + entry.getKey() + ": " + currentValue + "\n";
            } else if (statusKey.equals(STATUS_CHANGED)) {
                resulString += " - " + entry.getKey() + ": " + currentValue + "\n";
                resulString += " + " + entry.getKey() + ": " + entry.getValue().get(2) + "\n";
            }
        }
        resulString = "{\n" + resulString + "}";
        System.out.println(resulString);

        return resulString;
    }
}
