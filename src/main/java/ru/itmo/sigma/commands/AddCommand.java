package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.Worker;
import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

public class AddCommand extends Command{
    protected AddCommand() {
        super("add");
    }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stdin, InputStream stdout, WorkerTreeSet workerTreeSet) {
        Worker worker = new Worker().
        workerTreeSet.add();
    }

    @Override
    public String getHelp() {
        return "";
    }
}
