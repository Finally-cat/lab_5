package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.Worker;
import ru.itmo.sigma.filemanaging.XmlWorkerManager;

import java.util.HashMap;
import java.util.TreeSet;

public class Environment {
    public HashMap<String, Command> getStringCommandHashMap() {
        return stringCommandHashMap;
    }

    public XmlWorkerManager getXmlManager() {
        return xmlManager;
    }

    public Environment(HashMap<String, Command> stringCommandHashMap, String filePath) {
        this.stringCommandHashMap = stringCommandHashMap;
        this.xmlManager = new XmlWorkerManager(filePath);
        this.workers = xmlManager.load();
    }

    private final HashMap<String, Command> stringCommandHashMap;
    private final XmlWorkerManager xmlManager;
    private final TreeSet<Worker> workers;

}
