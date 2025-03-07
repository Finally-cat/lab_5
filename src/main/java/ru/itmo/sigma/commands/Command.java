package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class Command {
    protected  final String name;

    protected Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute(String[] strings, Environment env, PrintStream stdin, InputStream stdout, WorkerTreeSet workerTreeSet);

    public abstract String getHelp();
}
