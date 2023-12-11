package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(Map<String, Object> fileDataMap1, Map<String, Object>  fileDataMap2,
                                  String formatName) throws Exception {
        Map<String, List<Object>>  resultDiffer = DifferEngine.computeDiff(fileDataMap1, fileDataMap2);

        return Formatter.printByTypeFormat(formatName, resultDiffer);
    }
}
