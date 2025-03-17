package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.Worker;
import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;

/**
 * The type Print unique salary command.
 */
public class PrintUniqueSalaryCommand extends Command {
    /**
     * Instantiates a new Print unique salary command.
     */
    public PrintUniqueSalaryCommand() {
        super("print_unique_salary");
    }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        stdout.println("Отладка: Количество элементов в WorkerTreeSet = " + workerTreeSet.getWorkers().size());
        if (workerTreeSet.isEmpty()) {
            stdout.println("Коллекция пуста. Уникальных значений зарплат нет.");
            return;
        }

        Set<Long> uniqueSalaries = new TreeSet<>();

        for (Worker worker : workerTreeSet.getWorkers()) {
            uniqueSalaries.add(worker.getSalary());
        }

        stdout.println("Уникальные зарплаты сотрудников:");
        for (Long salary : uniqueSalaries) {
            stdout.println(salary);
        }
    }

    @Override
    public String getHelp() {
        return "print_unique_salary: выводит уникальные значения зарплат всех работников.";
    }
}
