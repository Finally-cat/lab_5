package ru.itmo.sigma.commands;

import java.util.HashMap;

public class Environment {
    public HashMap<String, Command> getStringCommandHashMap() {
        return stringCommandHashMap;
    }
    public Environment(HashMap<String, Command> stringCommandHashMap) {
        this.stringCommandHashMap = stringCommandHashMap;
    }

    private final HashMap<String, Command> stringCommandHashMap;

}
