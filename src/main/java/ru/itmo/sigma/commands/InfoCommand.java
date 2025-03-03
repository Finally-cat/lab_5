package ru.itmo.sigma.commands;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;

public class InfoCommand extends Command {
    public InfoCommand() {
        super("info");
    }

    @Override
    public void execute(String[] args, Environment env, PrintStream out, InputStream in) {
        out.println("Collection info: Type - TreeSet, Size - " + env.getStringCommandHashMap().size());
    }

    @Override
    public String getHelp() {
        return "Displays information about the collection";
    }
}

