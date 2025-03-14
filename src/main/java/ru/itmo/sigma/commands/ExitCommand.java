package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit");
    }

    @Override
    public void execute(String[] args, Environment env, PrintStream stderr, PrintStream out, InputStream in, WorkerTreeSet workerTreeSet) {
        out.println("Exiting program...");
        System.exit(0);
    }

    @Override
    public String getHelp() {
        return "Exits the program without saving";
    }
}
