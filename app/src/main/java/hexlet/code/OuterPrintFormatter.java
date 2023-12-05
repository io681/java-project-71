package hexlet.code;

import java.util.Map;

public class OuterPrintFormatter {

    public static String formatPrint(String format, Map<String, Object> data) {
        String resulString = "";

        if (format.equals("stylish")) {
            for (var entry : data.entrySet()) {
                resulString += entry.getKey() + ": " + entry.getValue() + "\n";
            }
            resulString = "{\n" + resulString + "}";
        }

        System.out.println(resulString);

        return resulString;
    }
}
