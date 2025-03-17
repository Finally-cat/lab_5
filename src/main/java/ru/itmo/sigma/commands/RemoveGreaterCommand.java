package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.Worker;
import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * The type Remove greater command.
 */
public class RemoveGreaterCommand extends Command {
    /**
     * Instantiates a new Remove greater command.
     */
    public RemoveGreaterCommand() {
        super("remove_greater");
    }

    /**
     * The Add com.
     */
    AddCommand addCom = new AddCommand();
    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        Worker referenceWorker = addCom.create(stderr, stdout, stdin);

//        int removedCount = workerTreeSet.worker -> worker.compareTo(referenceWorker) > 0
//        stdout.println("Удалено элементов: " + removedCount);
    }

    @Override
    public String getHelp() {
        return " удаляет все элементы, превышающие заданный.";
    }
}
