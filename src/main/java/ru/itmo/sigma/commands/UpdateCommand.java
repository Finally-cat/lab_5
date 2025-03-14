package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class UpdateCommand extends Command {
    protected UpdateCommand() {
        super("update");
    }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        try {
            long id = Long.parseLong(strings[1]);


            String name = strings[2];

            float xCoordinates = Float.parseFloat(strings[3]);
            Double yCoordinates = Double.parseDouble(strings[4]);
            Coordinates coordinates = new Coordinates(xCoordinates, yCoordinates);

            long salary = Long.parseLong(strings[5]);

            LocalDate startDate = LocalDate.parse(strings[6]);

            LocalDate endDate = LocalDate.parse(strings[7]);

            java.util.Date birthday = java.sql.Date.valueOf(strings[8]);
            Color eyeColor = Color.valueOf(strings[9]);
            Color hairColor = Color.valueOf(strings[10]);
            Country nationality = Country.valueOf(strings[11]);

            Position position = Position.valueOf(strings[12]);

            int x = Integer.parseInt(strings[13]);
            Integer y = Integer.parseInt(strings[14]);
            Double z = Double.parseDouble(strings[15]);
            String nameLocation = strings[16];
            Location location = new Location(x, y, z, nameLocation);
            Person person = new Person(birthday, eyeColor, hairColor, nationality, location);

            workerTreeSet.findById(id).edit(name, coordinates, salary, startDate, endDate, position, person);
            stdout.println("Worker обновлён: " + workerTreeSet.findById(id).toString());
        } catch (NumberFormatException e) {
            stderr.println("Ошибка преобразования данных: " + e.getMessage());
        } catch (IllegalArgumentException e){
            stderr.println("Неверные аргументы: " + e.getMessage());
        }
    }

    @Override
    public String getHelp() {
        return "update: Редактирует данные Worker \n"+ "Filling order: id, name, xCoordinates, yCoordinates, salary, startDate, endDate, birthday, eyeColor(RED, BLACK, YELLOW, ORANGE, BROWN), hairColor(RED, BLACK, YELLOW, ORANGE, BROWN), nationality (USA, SPAIN, INDIA, JAPAN), position, xlocation , ylocation, zlocation, nameLocation)";
    }
}
