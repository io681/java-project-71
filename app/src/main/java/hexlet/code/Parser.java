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
        String[] filePathSplit = filePath.split("\\.");
        String fileFormat = filePathSplit[filePathSplit.length - 1];

        return switch (fileFormat) {
            case "json" -> {
                ObjectMapper objectMapperJson = new ObjectMapper();
                yield objectMapperJson.readValue(contentFile, new TypeReference<>() {
                });
            }
            case "yaml" -> {
                ObjectMapper objectMapperYaml = new ObjectMapper(new YAMLFactory());
                yield objectMapperYaml.readValue(contentFile, new TypeReference<>() {
                });
            }
            default -> throw new RuntimeException("Unknown fileFormat: '" + fileFormat + "'");
        };
    }
}
