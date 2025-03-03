package ru.itmo.sigma.commands;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;

public class TestCommand extends Command{

    public TestCommand() {
        super("test");
    }



    @Override
    public void execute(String[] strings, Environment env, PrintStream stdin, InputStream stdout) {

    }

    @Override
    public String getHelp() {
        return "Test";
    }

    public static void register (HashMap<String, Command> stringCommandHashMap){
        TestCommand testCommand = new TestCommand();
        stringCommandHashMap.put(testCommand.getName(), new TestCommand());
    }
}
