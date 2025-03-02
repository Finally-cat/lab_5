package ru.itmo.sigma;
import ru.itmo.sigma.commands.Command;
import ru.itmo.sigma.commands.Envirnment;
import ru.itmo.sigma.commands.Environment;
import ru.itmo.sigma.commands.TestCommand;
import ru.itmo.sigma.data.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        HashMap<String, Command> hashMap = new HashMap<>();

        Environment environment = new Environment(hashMap);

        PrintStream printStream = System.out;
        InputStream inputStream = System.in;


//        while (in.hasNextLine()){
//            String line = in.nextLine();
//            String[] s = line.split(" ");
//            String[] cArgs = new String[s.length - 1];
//            System.arraycopy();
//            if (hashMap.containsKey(line)) {
//                Command command = hashMap.get(line);
//                command.execute();
//            } else {
//                System.err.println("Unknown command: " + line);
//            }
//        }
//        while (in.hasNextLine()) {
//            String line = in.nextLine().trim();
//            if (line.isEmpty()) continue; // Игнорируем пустые строки
//
//            String[] s = line.split("\\s+");
//            String commandName = s[0];
//            String[] cArgs = (s.length > 1) ? Arrays.copyOfRange(s, 1, s.length) : new String[0];
//
//            if ("exit".equalsIgnoreCase(commandName)) {
//                System.out.println("Выход...");
//                break;
//            }
//
//            Command command = hashMap.get(commandName);
//            if (command != null) {
//                try {
//                    command.execute(cArgs); // Исполняем команду с аргументами
//                } catch (Exception e) {
//                    System.err.println("Ошибка выполнения команды: " + e.getMessage());
//                }
//            } else {
//                System.err.println("Неизвестная команда: " + commandName);
//            }
//        }
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            String[] s = line.split("\\s+"); // Разделение по пробелам (учёт нескольких пробелов)

            if (s.length == 0) continue; // Пропускаем пустую строку

            String commandName = s[0]; // Команда (первое слово)
            String[] cArgs = new String[s.length - 1]; // Аргументы (остальные слова)

            System.arraycopy(s, 1, cArgs, 0, cArgs.length); // Копируем аргументы

            if (hashMap.containsKey(commandName)) {
                Command command = hashMap.get(commandName);
                command.execute(cArgs, environment,printStream, inputStream); // Передаём аргументы
            } else {
                System.err.println("Unknown command: " + commandName);
            }
        }



    }
}
