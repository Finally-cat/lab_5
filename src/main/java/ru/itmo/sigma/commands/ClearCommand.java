package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

public class ClearCommand extends Command{
    public ClearCommand() {
        super("clear");
    }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        workerTreeSet.clear();
        stdout.println("Коллекция очищена");
    }

    @Override
    public String getHelp() {
        return "clear : очистить коллекцию";
    }
}
