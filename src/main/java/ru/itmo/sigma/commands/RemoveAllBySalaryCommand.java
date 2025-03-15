package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

public class RemoveAllBySalaryCommand extends Command {

    public RemoveAllBySalaryCommand() {
        super("remove_all_by_salary");
    }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        try {
            long salary = Long.parseLong(strings[1]);
            workerTreeSet.removeAllBySalary(salary);
        } catch (NumberFormatException e) {
                stderr.println("Ошибка преобразования данных: " + e.getMessage());
        }
    }

    @Override
    public String getHelp() {
        return "remove_all_by_salary: удалить из коллекции все элементы, значение поля salary которого эквивалентно заданному";
    }
}
