import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Differ.generate;
import static hexlet.code.Differ.generateYamlDiffer;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    void generateTestJson() throws Exception {
        Path filePath1 = Paths.get("./src/test/resources/testFile1.json").toAbsolutePath().normalize();
        Path filePath2 = Paths.get("./src/test/resources/testFile2.json").toAbsolutePath().normalize();

        String contentFile1 = Files.readString(filePath1);
        String contentFile2 = Files.readString(filePath2);

        String expectedResult =
                "{\n"
                    + " - follow: false\n"
                    + "   host: hexlet.io\n"
                    + " - proxy: 123.234.53.22\n"
                    + " - timeout: 50\n"
                    + " + timeout: 20\n"
                    + " + verbose: true\n"
                    + "}";

        String actualResult = generate(contentFile1, contentFile2);

        assertEquals(expectedResult, actualResult, "Error Equals Strings");
    }

    @Test
    void generateTestYaml() throws Exception {
        Path filePath1 = Paths.get("./src/test/resources/testFile3.yaml").toAbsolutePath().normalize();
        Path filePath2 = Paths.get("./src/test/resources/testFile4.yaml").toAbsolutePath().normalize();

        String contentFile1 = Files.readString(filePath1);
        String contentFile2 = Files.readString(filePath2);

        String expectedResult =
                "{\n"
                        + " - follow: false\n"
                        + "   host: hexlet.io\n"
                        + " - proxy: 123.234.53.22\n"
                        + " - timeout: 50\n"
                        + " + timeout: 20\n"
                        + " + verbose: true\n"
                        + "}";

        String actualResult = generateYamlDiffer(contentFile1, contentFile2);

        assertEquals(expectedResult, actualResult, "Error Equals Strings");
    }
}
