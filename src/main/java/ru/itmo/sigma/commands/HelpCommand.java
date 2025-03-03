package ru.itmo.sigma.commands;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;

public class HelpCommand extends Command{
    public HelpCommand() {
        super("help");
    }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stdin, InputStream stdout) {
        System.out.println("help");
    }

//    @Override
//    public void execute(Environment env, PrintStream stdin, InputStream stdout) {
//        HashMap<String, Command> stringCommandHashMap = env.getStringCommandHashMap():
//        stringCommandHashMap.forEach((String.key, ));
//    }



    @Override
    public String getHelp() {
        return "";
    }
}
