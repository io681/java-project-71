package hexlet.code;

//import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.concurrent.Callable;

import static hexlet.code.Differ.*;

@Command(name = "gendiff", description = "Compares two configuration files and shows a difference.")
public class HelperConsole implements Callable<Integer> {
    @Parameters(index = "0", description = "path to first file")
    String filepath1;
    @Parameters(index = "1", description = "path to second file")
    String filepath2;
    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested = false;

    @Option(names = { "-V", "--version" }, description = "Print version information and exit.")
    private boolean version = false;

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]")
    private String format = "=format";

    @Override
    public Integer call() throws Exception{
        Path filePath1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path filePath2 = Paths.get(filepath2).toAbsolutePath().normalize();

        String contentFile1 = Files.readString(filePath1);
        String contentFile2 = Files.readString(filePath2);

        var textDiff = generate(contentFile1, contentFile2);

        return 0;
    }
}
