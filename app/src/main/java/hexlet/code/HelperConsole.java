package hexlet.code;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

import static hexlet.code.Differ.generate;

@Command(name = "gendiff", description = "Compares two configuration files and shows a difference.")
public final class HelperConsole implements Callable<Integer> {
    @Parameters(index = "0", description = "path to first file")
    private String filepath1;
    @Parameters(index = "1", description = "path to second file")
    private String filepath2;
    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested = false;
    @Option(names = { "-V", "--version" }, description = "Print version information and exit.")
    private boolean version = false;
    @Option(names = { "-f", "--format" }, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format = "=format";
    @Override
    public Integer call() throws Exception {
        System.out.println(generate(filepath1, filepath2, format));
        return 0;
    }
}
