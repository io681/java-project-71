import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static hexlet.code.Parser.getData;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    void generateTestJsonNested() throws Exception {
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

        String actualResult = generate(getData(filePath1), getData(filePath2));

        assertEquals(expectedResult, actualResult, "Error Equals Strings");
    }

    @Test
    void generateTestYamlNested() throws Exception {
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

        String actualResult = generate(getData(filePath1), getData(filePath2));

        assertEquals(expectedResult, actualResult, "Error Equals Strings");
    }
}
