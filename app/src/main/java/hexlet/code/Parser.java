package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getData(String filePath) throws Exception {
        Path filePathParser = Paths.get(filePath).toAbsolutePath().normalize();
        String contentFile = Files.readString(filePathParser);

        if (filePath.endsWith(".json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(contentFile, new TypeReference<Map<String, Object>>() { });

        } else if (filePath.endsWith(".yaml")) {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            return objectMapper.readValue(contentFile, new TypeReference<Map<String, Object>>() { });
        }
        return null;
    }
}
