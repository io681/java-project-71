import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Differ.generate;
import static hexlet.code.Parser.getData;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    @Test
    void generateTestJsonNestedFormatStylish() throws Exception {
        String filePath1 = "./src/test/resources/testFileNested1.json";
        String filePath2 = "./src/test/resources/testFileNested2.json";

        String expectedResult = "{\n"
                + "   chars1: [a, b, c]\n"
                + " - chars2: [d, e, f]\n"
                + " + chars2: false\n"
                + " - checked: false\n"
                + " + checked: true\n"
                + " - default: null\n"
                + " + default: [value1, value2]\n"
                + " - id: 45\n"
                + " + id: null\n"
                + " - key1: value1\n"
                + " + key2: value2\n"
                + "   numbers1: [1, 2, 3, 4]\n"
                + " - numbers2: [2, 3, 4, 5]\n"
                + " + numbers2: [22, 33, 44, 55]\n"
                + " - numbers3: [3, 4, 5]\n"
                + " + numbers4: [4, 5, 6]\n"
                + " + obj1: {nestedKey=value, isNested=true}\n"
                + " - setting1: Some value\n"
                + " + setting1: Another value\n"
                + " - setting2: 200\n"
                + " + setting2: 300\n"
                + " - setting3: true\n"
                + " + setting3: none\n"
                + "}";

        String actualResult = generate(getData(filePath1), getData(filePath2), "stylish");

        assertEquals(expectedResult, actualResult, "Error Equals Strings");
    }
    @Test
    void generateTestYamlNestedFormatStylish() throws Exception {
        String filePath1 = "./src/test/resources/testFileNested3.yaml";
        String filePath2 = "./src/test/resources/testFileNested4.yaml";

        String expectedResult = "{\n"
                + "   chars1: [a, b, c]\n"
                + " - chars2: [d, e, f]\n"
                + " + chars2: false\n"
                + " - checked: false\n"
                + " + checked: true\n"
                + " - default: null\n"
                + " + default: [value1, value2]\n"
                + " - id: 45\n"
                + " + id: null\n"
                + " - key1: value1\n"
                + " + key2: value2\n"
                + "   numbers1: [1, 2, 3, 4]\n"
                + " - numbers2: [2, 3, 4, 5]\n"
                + " + numbers2: [22, 33, 44, 55]\n"
                + " - numbers3: [3, 4, 5]\n"
                + " + numbers4: [4, 5, 6]\n"
                + " + obj1: {nestedKey=value, isNested=true}\n"
                + " - setting1: Some value\n"
                + " + setting1: Another value\n"
                + " - setting2: 200\n"
                + " + setting2: 300\n"
                + " - setting3: true\n"
                + " + setting3: none\n"
                + "}";

        String actualResult = generate(getData(filePath1), getData(filePath2), "stylish");

        assertEquals(expectedResult, actualResult, "Error Equals Strings");
    }
    @Test
    void generateTestJsonNestedFormatPlain() throws Exception {
        String filePath1 = "./src/test/resources/testFileNested1.json";
        String filePath2 = "./src/test/resources/testFileNested2.json";

        String expectedResult = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";

        String actualResult = generate(getData(filePath1), getData(filePath2), "plain");

        assertEquals(expectedResult, actualResult, "Error Equals Strings");
    }
    @Test
    void generateTestYamlNestedFormatPlain() throws Exception {
        String filePath1 = "./src/test/resources/testFileNested3.yaml";
        String filePath2 = "./src/test/resources/testFileNested4.yaml";

        String expectedResult = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";


        String actualResult = generate(getData(filePath1), getData(filePath2), "plain");

        assertEquals(expectedResult, actualResult, "Error Equals Strings");
    }
    @Test
    void generateTestOutByFormatJson() throws Exception {
        String filePath1 = "./src/test/resources/testFileNested1.json";
        String filePath2 = "./src/test/resources/testFileNested2.json";

        String filePathExpectedResult = "./src/test/resources/expectedOutByFormatJson.json";
        Path filePathParser = Paths.get(filePathExpectedResult).toAbsolutePath().normalize();
        String jsonContentExpectedResult = Files.readString(filePathParser);

        String jsonActualResult = generate(getData(filePath1), getData(filePath2), "json");

        assertEquals(jsonContentExpectedResult, jsonActualResult, "Error Equals Strings");
    }
}
