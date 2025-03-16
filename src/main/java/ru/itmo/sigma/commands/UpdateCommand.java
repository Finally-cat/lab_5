package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class UpdateCommand extends Command {
    public UpdateCommand() {
        super("update");
    }

    @Override
    public void execute(String[] args, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        Scanner scanner = new Scanner(stdin);

        try {
            long id = readLong(scanner, stdout, "Введите ID работника для обновления: ");
            Worker worker = workerTreeSet.findById(id);

            if (worker == null) {
                stderr.println("Ошибка: Worker с ID " + id + " не найден.");
                return;
            }

            stdout.print("Введите новое имя (старое: " + worker.getName() + "): ");
            String name = scanner.nextLine().trim();

            float xCoordinates = readFloat(scanner, stdout, "Введите X координату: ");
            Double yCoordinates = readDouble(scanner, stdout, "Введите Y координату: ");
            Coordinates coordinates = new Coordinates(xCoordinates, yCoordinates);

            long salary = readLong(scanner, stdout, "Введите зарплату: ");

            LocalDate startDate = readDate(scanner, stdout, "Введите дату начала работы (yyyy-MM-dd): ");
            LocalDate endDate = readDate(scanner, stdout, "Введите дату окончания работы (yyyy-MM-dd): ");

            java.util.Date birthday = java.sql.Date.valueOf(readDate(scanner, stdout, "Введите дату рождения (yyyy-MM-dd): "));

            Color eyeColor = readEnum(scanner, stdout, "Введите цвет глаз", Color.class);
            Color hairColor = readEnum(scanner, stdout, "Введите цвет волос", Color.class);
            Country nationality = readEnum(scanner, stdout, "Введите страну", Country.class);

            Position position = readEnum(scanner, stdout, "Введите должность", Position.class);

            int xLocation = readInt(scanner, stdout, "Введите X локации: ");
            Integer yLocation = readInt(scanner, stdout, "Введите Y локации: ");
            Double zLocation = readDouble(scanner, stdout, "Введите Z локации: ");
            stdout.print("Введите имя локации: ");
            String nameLocation = scanner.nextLine().trim();

            Location location = new Location(xLocation, yLocation, zLocation, nameLocation);
            Person person = new Person(birthday, eyeColor, hairColor, nationality, location);

            worker.edit(name, coordinates, salary, startDate, endDate, position, person);
            stdout.println("Worker обновлён: " + worker);

        } catch (Exception e) {
            stderr.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    public String getHelp() {
        return "update: Обновляет данные Worker. Ввод данных осуществляется интерактивно.";
    }

    //  Методы валидации и повторного ввода

    private float readFloat(Scanner scanner, PrintStream stdout, String prompt) {
        while (true) {
            try {
                stdout.print(prompt);
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                stdout.println("Ошибка: Введите корректное число (float).");
            }
        }
    }

    private double readDouble(Scanner scanner, PrintStream stdout, String prompt) {
        while (true) {
            try {
                stdout.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                stdout.println("Ошибка: Введите корректное число (double).");
            }
        }
    }

    private long readLong(Scanner scanner, PrintStream stdout, String prompt) {
        while (true) {
            try {
                stdout.print(prompt);
                return Long.parseLong(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                stdout.println("Ошибка: Введите корректное целое число (long).");
            }
        }
    }

    private int readInt(Scanner scanner, PrintStream stdout, String prompt) {
        while (true) {
            try {
                stdout.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                stdout.println("Ошибка: Введите корректное целое число (int).");
            }
        }
    }

    private LocalDate readDate(Scanner scanner, PrintStream stdout, String prompt) {
        while (true) {
            try {
                stdout.print(prompt);
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (Exception e) {
                stdout.println("Ошибка: Введите дату в формате yyyy-MM-dd.");
            }
        }
    }

    private <T extends Enum<T>> T readEnum(Scanner scanner, PrintStream stdout, String prompt, Class<T> enumClass) {
        while (true) {
            stdout.println(prompt + " (Доступные значения: " + String.join(", ", getEnumNames(enumClass)) + "): ");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return Enum.valueOf(enumClass, input);
            } catch (IllegalArgumentException e) {
                stdout.println("Ошибка: Некорректное значение. Попробуйте снова.");
            }
        }
    }

    private <T extends Enum<T>> String[] getEnumNames(Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}

