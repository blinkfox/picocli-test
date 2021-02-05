package com.blinkfox.test;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import javax.inject.Inject;
import org.fusesource.jansi.AnsiConsole;
import picocli.CommandLine;

/**
 * HelloWorld.
 *
 * @author blinkfox on 2021-02-05.
 * @since v1.0.0
 */
@QuarkusMain
@CommandLine.Command(
        version = "1.0.0",
        description = "@|bold,green Hello World!|@",
        synopsisHeading = "%n",
        descriptionHeading = "%n@|bold,blue,underline Description|@:%n",
        parameterListHeading = "%n@|bold,blue,underline Parameters|@:%n",
        optionListHeading = "%n@|bold,blue,underline Options|@:%n",
        commandListHeading = "%n@|bold,blue,underline Commands|@:%n")
public class HelloWorld implements Runnable, QuarkusApplication {

    @Inject
    CommandLine.IFactory factory;

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
        System.out.println(CommandLine.Help.Ansi.AUTO
                .string("@|blue ------------------------|@"));
        System.out.println(CommandLine.Help.Ansi.AUTO
                .string("@|bold,magenta Hello World!|@"));
        System.out.println(CommandLine.Help.Ansi.AUTO
                .string("@|blue ------------------------|@"));
    }

    @Override
    public int run(String... args) {
        AnsiConsole.systemInstall();
        int code = new CommandLine(this, factory).execute(args);
        AnsiConsole.systemUninstall();
        return code;
    }

}
