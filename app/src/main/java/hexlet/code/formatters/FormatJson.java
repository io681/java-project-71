package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.List;

public class FormatJson {
    public static String formatPrintJson(Map<String, List<Object>> data) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(data);
    }
}
