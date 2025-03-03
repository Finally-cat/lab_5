package ru.itmo.sigma.commands;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit");
    }

    @Override
    public void execute(String[] args, Environment env, PrintStream out, InputStream in) {
        out.println("Exiting program...");
        System.exit(0);
    }

    @Override
    public String getHelp() {
        return "Exits the program without saving";
    }
}
