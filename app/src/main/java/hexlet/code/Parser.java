package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getData(String filePath) throws Exception {
        Path filePathParser = Paths.get(filePath).toAbsolutePath().normalize();
        String contentFile = Files.readString(filePathParser);
        Map<String, Object> resultMap = new HashMap<>();

        if (filePath.endsWith(".json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            resultMap = objectMapper.readValue(contentFile, new TypeReference<>() {
            });

        } else if (filePath.endsWith(".yaml")) {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            resultMap = objectMapper.readValue(contentFile, new TypeReference<>() {
            });
        }
        return resultMap;
    }
}
