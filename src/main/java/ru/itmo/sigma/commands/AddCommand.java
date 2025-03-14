package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import static ru.itmo.sigma.IdGenerator.generateId;

public class AddCommand extends Command {
    public AddCommand() {
        super("add");
    }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        if (strings.length < 15) { // Проверка данных
            System.out.println("Недостаточно данных для создания Worker");
            return;
        }

        try {
            long id = generateId();

            String name = strings[1];

            float xCoordinates = Float.parseFloat(strings[2]);
            Double  yCoordinates = Double.parseDouble(strings[3]);
            Coordinates coordinates = new Coordinates(xCoordinates,yCoordinates);

            long salary = Long.parseLong(strings[4]);

            LocalDate startDate = LocalDate.parse(strings[5]);

            LocalDate endDate = LocalDate.parse(strings[6]);

            java.util.Date birthday = java.sql.Date.valueOf(strings[7]);
            Color eyeColor = Color.valueOf(strings[8]);
            Color hairColor = Color.valueOf(strings[9]);
            Country nationality = Country.valueOf(strings[10]);

            Position position = Position.valueOf(strings[11]);
            ZonedDateTime date = ZonedDateTime.now();
            int x = Integer.parseInt(strings[12]);
            Integer y = Integer.parseInt(strings[13]);
            Double z = Double.parseDouble(strings[14]);
            String nameLocation = strings[15];
            Location location = new Location(x, y, z, nameLocation);

            Person person = new Person(birthday, eyeColor, hairColor,nationality, location);

            Worker worker = new Worker(id,name, coordinates, date, salary, startDate, endDate, position, person);

            workerTreeSet.add(worker); // Добавляем объект в коллекцию
            System.out.println("Worker добавлен: " + worker);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования данных: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    public String getHelp() {
        return "adds a new worker to workerTreeSet.\n " +
                "Filling order: name, xCoordinates, yCoordinates, salary, startDate, endDate, birthday, eyeColor(RED, BLACK, YELLOW, ORANGE, BROWN), hairColor(RED, BLACK, YELLOW, ORANGE, BROWN), nationality (USA, SPAIN, INDIA, JAPAN), position, xlocation , ylocation, zlocation, nameLocation)";
    }
//        strings = new String[0];
//        Worker worker = new Worker();
//        workerTreeSet.add();
}
