import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    void testTake() throws Exception {
        Path filePath1 = Paths.get("./src/test/resources/testFile1.json").toAbsolutePath().normalize();
        Path filePath2 = Paths.get("./src/test/resources/testFile2.json").toAbsolutePath().normalize();

        String contentFile1 = Files.readString(filePath1);
        String contentFile2 = Files.readString(filePath2);

        String expectedResult = "- followfalse ,  hosthexlet.io ,- proxy123.234.53.22 ,- timeout50 ,+ timeout20 ,+ verbosetrue ,";
        String actualResult = generate(contentFile1, contentFile2);

        assertEquals(expectedResult, actualResult, "Error Equals");
    }
}