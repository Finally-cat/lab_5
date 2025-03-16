package ru.itmo.sigma.commands;
import ru.itmo.sigma.data.WorkerTreeSet;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Deque;

public class HistoryCommand extends Command {
    private final Deque<String> history;

    public HistoryCommand(Deque<String> history) {
        super("history");
        this.history = history;
    }

    @Override
    public void execute(String[] strings, ru.itmo.sigma.commands.Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        stdout.println("Последние 5 команд:");
        for (String cmd : history) {
            stdout.println(cmd);
        }
    }

    @Override
    public String getHelp() {
        return "history : вывести последние 5 введенных команд (без аргументов)";
    }
}
