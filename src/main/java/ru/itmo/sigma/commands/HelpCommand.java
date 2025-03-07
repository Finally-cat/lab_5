package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help");
    }

    @Override
    public void execute(String[] args, Environment env, PrintStream out, InputStream in, WorkerTreeSet workerTreeSet) {
        out.println("Available commands:");
        for (Map.Entry<String, Command> entry : env.getStringCommandHashMap().entrySet()) {
            out.println(entry.getKey() + " - " + entry.getValue().getHelp());
        }
    }

    @Override
    public String getHelp() {
        return "Displays the list of available commands";
    }
}
