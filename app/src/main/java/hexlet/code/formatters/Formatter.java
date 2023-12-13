package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String printByTypeFormat(String formatName, Map<String, List<Object>> dataForPrint) throws Exception {
        return switch (formatName) {
            case "stylish" -> FormatStylish.formatPrintStylish(dataForPrint);
            case "plain" -> FormatPlain.formatPrintPlain(dataForPrint);
            case "json" -> FormatJson.formatPrintJson(dataForPrint);
            default -> throw new RuntimeException("Unknown fileFormat");
        };
    }
}
