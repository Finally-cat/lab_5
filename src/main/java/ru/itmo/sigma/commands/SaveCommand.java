package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * The type Save command.
 */
public class SaveCommand extends Command {
    /**
     * Instantiates a new Save command.
     */
    public SaveCommand() {
        super("save");
    }

    @Override
    public void execute(String[] args, Environment env, PrintStream stderr, PrintStream out, InputStream in, WorkerTreeSet tree) {
        tree.save();
        out.println("Коллекция успешно сохранена в файл.");
    }

    @Override
    public String getHelp() {
        return " сохранить коллекцию в XML-файл";
    }
}
