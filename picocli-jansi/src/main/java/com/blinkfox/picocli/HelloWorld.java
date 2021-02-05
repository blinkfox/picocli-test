package com.blinkfox.picocli;

import java.util.concurrent.Callable;
import org.fusesource.jansi.AnsiConsole;
import picocli.CommandLine;

/**
 * CheckSum.
 *
 * @author blinkfox on 2020-09-08.
 * @since v1.0.0
 */
@CommandLine.Command(
        version = "1.0.0",
        description = "@|bold,green Hello World!|@",
        synopsisHeading = "%n",
        descriptionHeading = "%n@|bold,blue,underline Description|@:%n",
        parameterListHeading = "%n@|bold,blue,underline Parameters|@:%n",
        optionListHeading = "%n@|bold,blue,underline Options|@:%n",
        commandListHeading = "%n@|bold,blue,underline Commands|@:%n")
public class HelloWorld implements Callable<Integer> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        AnsiConsole.systemInstall();
        System.out.println(CommandLine.Help.Ansi.AUTO.string("@|bold,green ------------|@"));
        System.out.println(CommandLine.Help.Ansi.AUTO.string("@|red Hello|@ @|cyan World|@"));
        System.out.println(CommandLine.Help.Ansi.AUTO.string("@|bold,green ------------|@"));
        AnsiConsole.systemUninstall();
        return 0;
    }

    /**
     * main.
     *
     * @param args 数组
     */
    public static void main(String... args) {
        int exitCode = new CommandLine(new HelloWorld()).execute(args);
        System.exit(exitCode);
    }

}
