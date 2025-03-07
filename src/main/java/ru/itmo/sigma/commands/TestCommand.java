package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;

public class TestCommand extends Command{

    public TestCommand() {
        super("test");
    }



    @Override
    public void execute(String[] strings, Environment env, PrintStream stdin, InputStream stdout, WorkerTreeSet workerTreeSet) {

    }

    @Override
    public String getHelp() {
        return "Test";
    }

}
