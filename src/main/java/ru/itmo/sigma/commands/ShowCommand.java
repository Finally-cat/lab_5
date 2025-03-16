package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * The type Show command.
 */
public class ShowCommand extends Command{
    /**
     * Instantiates a new Show command.
     */
    public ShowCommand() { super("show"); }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        stdout.println("Текущая коллекция: ");
        workerTreeSet.printAllWorkers();
    }

    @Override
    public String getHelp() {
        return " показать текущую коллекцию";
    }
}
