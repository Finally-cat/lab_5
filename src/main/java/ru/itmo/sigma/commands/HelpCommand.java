package ru.itmo.sigma.commands;

import java.util.HashMap;

public class HelpCommand extends Command{
    protected HelpCommand(String name) {
        super("help");
    }



    @Override
    public void execute(Environment env) {
        HashMap<String, Command> stringCommandHashMap = env.getStringCommandHashMap():
        stringCommandHashMap.forEach((String key, ));
    }

    @Override
    public String getHelp() {
        return "";
    }
}
