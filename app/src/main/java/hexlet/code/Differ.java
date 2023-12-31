package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.util.List;
import java.util.Map;

import static hexlet.code.Parser.getData;

public class Differ {
    public static String generate(String filePath1, String filePath2,
                                  String formatName) throws Exception {
        Map<String, Object>  fileDataMap1 = getData(filePath1);
        Map<String, Object>  fileDataMap2 = getData(filePath2);
        Map<String, List<Object>>  resultDiffer = DifferEngine.computeDiff(fileDataMap1, fileDataMap2);
        return Formatter.printByTypeFormat(formatName, resultDiffer);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
