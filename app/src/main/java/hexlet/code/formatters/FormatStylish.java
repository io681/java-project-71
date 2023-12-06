package hexlet.code.formatters;

import java.util.Map;

public class FormatStylish {
    public static String formatPrintStylish(Map<String, Object> data) {
        String resulString = "";

        for (var entry : data.entrySet()) {
            if (entry.getKey().endsWith("_added")) {
                String newKeyForSprint = entry.getKey().split("_")[0];
                resulString += " + " + newKeyForSprint + ": " + entry.getValue() + "\n";
            } else if (entry.getKey().endsWith("_deleted")) {
                String newKeyForSprint = entry.getKey().split("_")[0];
                resulString += " - " + newKeyForSprint + ": " + entry.getValue() + "\n";
            } else if (entry.getKey().endsWith("_unchanged")) {
                String newKeyForSprint = entry.getKey().split("_")[0];
                resulString += "   " + newKeyForSprint + ": " + entry.getValue() + "\n";
            } else if (entry.getKey().endsWith("_changed")) {
                if (entry.getKey().split("_")[1].equals("old")) {
                    String newKeyForSprint = entry.getKey().split("_")[0];
                    resulString += " - " + newKeyForSprint + ": " + entry.getValue() + "\n";
                } else if ((entry.getKey().split("_")[1].equals("new"))) {
                    String newKeyForSprint = entry.getKey().split("_")[0];
                    resulString += " + " + newKeyForSprint + ": " + entry.getValue() + "\n";
                }
            }
        }
        resulString = "{\n" + resulString + "}";
        System.out.println(resulString);

        return resulString;
    }
}
