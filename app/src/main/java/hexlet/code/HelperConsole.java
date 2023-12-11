package hexlet.code;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

import static hexlet.code.Differ.generate;
import static hexlet.code.Parser.getData;

@Command(name = "gendiff", description = "Compares two configuration files and shows a difference.")
public class HelperConsole implements Callable<Integer> {
    @Parameters(index = "0", description = "path to first file")
    String filepath1;
    @Parameters(index = "1", description = "path to second file")
    String filepath2;
    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    boolean helpRequested = false;

    @Option(names = { "-V", "--version" }, description = "Print version information and exit.")
    boolean version = false;

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", description = "output format [default: stylish]")
    String format = "=format";

    @Override
    public Integer call() throws Exception {
        System.out.println(generate(getData(filepath1), getData(filepath2), format));
        return 0;
    }
}
