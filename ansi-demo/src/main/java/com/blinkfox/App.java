package com.blinkfox;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.AnsiConsole;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        System.out.println("------------");
        System.out.println(ansi().render("@|red Hello|@ @|cyan World|@"));
        System.out.println("------------");
        AnsiConsole.systemUninstall();
    }

}
