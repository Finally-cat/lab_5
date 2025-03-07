package ru.itmo.sigma.commands;
import ru.itmo.sigma.data.WorkerTreeSet;
import java.io.InputStream;
import java.io.PrintStream;

public class LoadCommand extends Command {
    public LoadCommand() {
        super("load");
    }

    @Override
    public void execute(String[] args, Environment env, PrintStream out, InputStream in, WorkerTreeSet tree) {
        tree.load(); // Загружаем коллекцию заново
        out.println("Коллекция загружена из файла.");
    }

    @Override
    public String getHelp() {
        return "load : загрузить коллекцию из XML-файла";
    }
}