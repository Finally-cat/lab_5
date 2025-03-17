package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.Worker;
import ru.itmo.sigma.filemanaging.XmlWorkerManager;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * The type Environment.
 */
public class Environment {
    /**
     * Gets string command hash map.
     *
     * @return the string command hash map
     */
    public HashMap<String, Command> getStringCommandHashMap() {
        return stringCommandHashMap;
    }

    /**
     * Gets xml manager.
     *
     * @return the xml manager
     */
    public XmlWorkerManager getXmlManager() {
        return xmlManager;
    }

    /**
     * Instantiates a new Environment.
     *
     * @param stringCommandHashMap the string command hash map
     * @param filePath             the file path
     */
    public Environment(HashMap<String, Command> stringCommandHashMap, String filePath) {
        this.stringCommandHashMap = stringCommandHashMap;
        this.xmlManager = new XmlWorkerManager(filePath);
        this.workers = xmlManager.load();
    }

    private final HashMap<String, Command> stringCommandHashMap;
    private final XmlWorkerManager xmlManager;
    private final TreeSet<Worker> workers;

    /**
     * Gets command.
     *
     * @param commandName the command name
     * @return the command
     */
    public Command getCommand(String commandName) {
        return stringCommandHashMap.get(commandName);
    }
}
