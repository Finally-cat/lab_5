package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

public class TestCommand extends Command{

    public TestCommand() {
        super("test");
    }



    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {

    }

    @Override
    public String getHelp() {
        return "Test";
    }

}
