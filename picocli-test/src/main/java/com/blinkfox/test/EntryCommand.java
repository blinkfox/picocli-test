package com.blinkfox.test;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import org.fusesource.jansi.AnsiConsole;
import picocli.CommandLine;

/**
 * top command.
 *
 * @author blinkfox on 2021-02-05.
 * @since 1.0.0
 */
@TopCommand
@CommandLine.Command(
        version = "1.0.0",
        description = "@|bold,green Hello World!|@",
        synopsisHeading = "%n",
        descriptionHeading = "%n@|bold,blue,underline Description|@:%n",
        parameterListHeading = "%n@|bold,blue,underline Parameters|@:%n",
        optionListHeading = "%n@|bold,blue,underline Options|@:%n",
        commandListHeading = "%n@|bold,blue,underline Commands|@:%n")
public class EntryCommand implements Runnable {

    /**
     * 是否可查看帮助信息.
     */
    @CommandLine.Option(names = {"-h", "-H", "--help"}, usageHelp = true,
            description = "@|cyan Display help information|@")
    boolean help;

    @CommandLine.Option(names = {"-v", "-V", "--version"}, versionHelp = true,
            description = "@|cyan Display version information|@")
    boolean version;

    @Override
    public void run() {
        AnsiConsole.systemInstall();
        System.out.println();
        System.out.println(CommandLine.Help.Ansi.AUTO
                .string("@|blue ------------------------|@"));
        System.out.println(CommandLine.Help.Ansi.AUTO
                .string("@|bold,magenta Hello World!|@"));
        System.out.println(CommandLine.Help.Ansi.AUTO
                .string("@|blue ------------------------|@"));
        System.out.println();
        AnsiConsole.systemUninstall();
    }

}
