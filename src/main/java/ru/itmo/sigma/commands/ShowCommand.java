package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

public class ShowCommand extends Command{
    public ShowCommand() { super("show"); }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stdin, InputStream stdout, WorkerTreeSet workerTreeSet) {
    workerTreeSet.treeToString();
    }

    @Override
    public String getHelp() {
        return "output all elements of a collection in string representation";
    }
}
