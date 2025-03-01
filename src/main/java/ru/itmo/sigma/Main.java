package ru.itmo.sigma;
import ru.itmo.sigma.commands.Command;
import ru.itmo.sigma.commands.Envirnment;
import ru.itmo.sigma.commands.Environment;
import ru.itmo.sigma.commands.TestCommand;
import ru.itmo.sigma.data.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        HashMap<String, Command> hashMap = new HashMap<>();
        TestCommand testCommand = new TestCommand();
        hashMap.put(TestCommand.getName(), testCommand);

        Environment environment = new Environment(hashMap);

        PrintStream printStream = System.out;
        InputStream inputStream = System.in;


        while (in.hasNextLine()){
            String line = in.nextLine();
            String[] s = line.split(" ");
            String[] cArgs = new String[s.length - 1];
            System.arraycopy();
            if (hashMap.containsKey(line)) {
                Command command = hashMap.get(line);
                command.execute();
            } else {
                System.err.println("Unknown command: " + line);
            }
        }



    }
}
