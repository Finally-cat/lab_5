package ru.itmo.sigma;

import ru.itmo.sigma.commands.*;
import ru.itmo.sigma.data.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Получаем путь к файлу из переменной окружения
        String filePath = System.getenv("WORKER_FILE");
        if (filePath == null) {
            System.err.println("Переменная окружения WORKER_FILE не задана!");
            System.exit(1);
        }

        // Создаем коллекцию и окружение
        WorkerTreeSet tree = new WorkerTreeSet(filePath);
        HashMap<String, Command> hashMap = new HashMap<>();
        Environment environment = new Environment(hashMap, filePath);

        // Регистрация команд
        hashMap.put("test", new TestCommand());
        hashMap.put("help", new HelpCommand());
        hashMap.put("info", new InfoCommand());
        hashMap.put("exit", new ExitCommand());
        hashMap.put("show", new ShowCommand());
        hashMap.put("save", new SaveCommand());
        hashMap.put("load", new LoadCommand());

        // Потоки ввода/вывода
        PrintStream printStream = System.out;
        InputStream inputStream = System.in;
        Scanner in = new Scanner(inputStream);

        // Основной цикл команд
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] s = line.split("\\s+");
            String commandName = s[0];
            String[] cArgs = (s.length > 1) ? Arrays.copyOfRange(s, 1, s.length) : new String[0];

            // Поиск и выполнение команды
            Command command = hashMap.get(commandName);
            if (command != null) {
                try {
                    command.execute(cArgs, environment, printStream, inputStream, tree);

                } catch (Exception e) {
                    System.err.println("Ошибка выполнения команды: " + e.getMessage());
                }
            } else {
                System.err.println("Неизвестная команда: " + commandName);
            }
        }
    }
}
