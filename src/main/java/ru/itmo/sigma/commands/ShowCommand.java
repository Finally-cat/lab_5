package ru.itmo.sigma.commands;

import java.io.InputStream;
import java.io.PrintStream;

public class ShowCommand extends Command{
    protected ShowCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String[] strings, Environment env, PrintStream stdin, InputStream stdout) {

    }

    @Override
    public String getHelp() {
        return "";
    }
}
