package ru.itmo.sigma;
import ru.itmo.sigma.commands.*;
import ru.itmo.sigma.data.*;
import ru.itmo.sigma.exeption.CommandException;

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

        TestCommand.register(hashMap);

// Register TestCommand and HelpCommand
        TestCommand.register(hashMap);
        hashMap.put("test", new TestCommand());
        hashMap.put("help", new HelpCommand());
        hashMap.put("info", new InfoCommand());
        hashMap.put("exit", new ExitCommand());


// Command processing loop
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.isEmpty()) continue; // Ignore empty lines

            String[] s = line.split("\\s+"); // Split input into command and arguments
            String commandName = s[0]; // The command's name
            String[] cArgs = (s.length > 1) ? Arrays.copyOfRange(s, 1, s.length) : new String[0]; // Arguments for the command


            // Command execution
            Command command = hashMap.get(commandName);
            if (command != null) {
                try {
                    command.execute(cArgs, environment, printStream, inputStream); // Execute the command
                } catch (Exception e) {
                    System.err.println("Command execution failed: " + e.getMessage());
                }
            } else {
                System.err.println("Unknown command: " + commandName);
            }
        }


    }
}
