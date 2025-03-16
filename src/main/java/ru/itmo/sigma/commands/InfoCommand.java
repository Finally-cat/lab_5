package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * The type Info command.
 */
public class InfoCommand extends Command {
    /**
     * Instantiates a new Info command.
     */
    public InfoCommand() {
        super("info");
    }

    @Override
    public void execute(String[] args, Environment env, PrintStream stderr, PrintStream out, InputStream in, WorkerTreeSet workerTreeSet) {
        out.println("Collection info: Type - TreeSet, Size - " + env.getStringCommandHashMap().size());
    }

    @Override
    public String getHelp() {
        return "Displays information about the collection";
    }
}

