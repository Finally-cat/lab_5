package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.Worker;
import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

public class RemoveGreaterCommand extends Command {
    public RemoveGreaterCommand() {
        super("remove_greater");
    }
    AddCommand addCom = new AddCommand();
    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        Worker referenceWorker = addCom.create(stderr, stdout, stdin);

//        int removedCount = workerTreeSet.worker -> worker.compareTo(referenceWorker) > 0
//        stdout.println("Удалено элементов: " + removedCount);
    }

    @Override
    public String getHelp() {
        return "remove_greater {element}: удаляет все элементы, превышающие заданный.";
    }
}
