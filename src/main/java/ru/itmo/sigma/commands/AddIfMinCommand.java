package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.Worker;
import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * The type Add if min command.
 */
public class AddIfMinCommand extends Command {

    /**
     * Instantiates a new Add if min command.
     */
    public AddIfMinCommand() {
        super("add_if_min");
    }

    /**
     * The Add com.
     */
    AddCommand addCom = new AddCommand();

    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        Worker newWorker = addCom.create(stderr, stdout, stdin);

        if (workerTreeSet.isEmpty() || newWorker.compareTo(workerTreeSet.getMinWorker()) < 0) {
            workerTreeSet.add(newWorker);
            stdout.println("Элемент добавлен в коллекцию.");
        } else {
            stdout.println("Элемент не является минимальным, добавление отменено.");
        }
    }
    
    @Override
    public String getHelp() {
        return "add_if_min {element}: добавляет новый элемент, если он меньше наименьшего.";
    }
}
