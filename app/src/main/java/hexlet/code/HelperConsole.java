package hexlet.code;

//import picocli.CommandLine;
//import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
//import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;
//@Command(name = "checksum", mixinStandardHelpOptions = true, version = "checksum 4.0",
//        description = "Prints the checksum (SHA-256 by default) of a file to STDOUT.")
public class HelperConsole implements Callable<Integer> {
    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested = false;

    @Option(names = { "-V", "--version" }, description = "Print version information and exit.")
    private boolean version = false;

    @Override
    public Integer call() throws Exception{
        return null;
    }
}
