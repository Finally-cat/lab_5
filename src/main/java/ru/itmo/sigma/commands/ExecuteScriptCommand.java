package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Execute script command.
 */
public class ExecuteScriptCommand extends Command {
    private static final Set<String> executedFiles = new HashSet<>();

    /**
     * Instantiates a new Execute script command.
     */
    public ExecuteScriptCommand() {
        super("execute_script");
    }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet) {
        if (strings.length < 1) {
            stderr.println("Ошибка: укажите имя файла.");
            return;
        }

        String fileName = strings[0];

        if (executedFiles.contains(fileName)) {
            stderr.println("Ошибка: обнаружен цикл в файле " + fileName);
            return;
        }

        executedFiles.add(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] s = line.split("\\s+");
                String commandName = s[0];
                String[] cArgs = (s.length > 1) ? Arrays.copyOfRange(s, 1, s.length) : new String[0];

                // Поиск команды в текущем окружении
                Command command = env.getCommand(commandName);
                if (command != null) {
                    try {
                        command.execute(cArgs, env, stderr, stdout, stdin, workerTreeSet);
                    } catch (Exception e) {
                        stderr.println("Ошибка выполнения команды: " + e.getMessage());
                    }
                } else {
                    stderr.println("Неизвестная команда: " + commandName);
                }
            }
        } catch (IOException e) {
            stderr.println("Ошибка чтения файла: " + e.getMessage());
        } finally {
            executedFiles.remove(fileName);
        }
    }

    @Override
    public String getHelp() {
        return "execute_script file_name: исполняет команды из файла, предотвращая циклы.";
    }
}
