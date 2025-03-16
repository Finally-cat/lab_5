package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;

public class RemoveAnyByStartDateCommand extends Command{
    public RemoveAnyByStartDateCommand() {
        super("remove_any_by_start_date");
    }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        try {
            LocalDate startDate = LocalDate.parse(strings[0]);
            stdout.println(workerTreeSet.removeByStartDate(startDate));
        } catch (NumberFormatException e) {
            stderr.println("Ошибка преобразования данных: " + e.getMessage());
        }
    }

    @Override
    public String getHelp() {
        return "remove_any_by_start_date: удалить из коллекции один элемент, значение поля startDate которого эквивалентно заданному";
    }
}
