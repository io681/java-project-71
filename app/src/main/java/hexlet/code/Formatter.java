package hexlet.code;

import hexlet.code.formatters.FormatPlain;
import hexlet.code.formatters.FormatStylish;

import java.util.Map;



public class Formatter {
    public static String printByTypeFormat(String formatName, Map<String, Object> dataForPrint) throws Exception {
        if (formatName.equals("stylish")) {
            return FormatStylish.formatPrintStylish(dataForPrint);
        } else if (formatName.equals("plain")) {
            return FormatPlain.formatPrintPlain(dataForPrint);
        }
        return "";
    }
}
