package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * The type Command.
 */
public abstract class Command {
    /**
     * The Name.
     */
    protected  final String name;

    /**
     * Instantiates a new Command.
     *
     * @param name the name
     */
    protected Command(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Execute.
     *
     * @param strings       the strings
     * @param env           the env
     * @param stderr        the stderr
     * @param stdout        the stdout
     * @param stdin         the stdin
     * @param workerTreeSet the worker tree set
     */
    public abstract void execute(String[] strings, Environment env, PrintStream stderr, PrintStream stdout, InputStream stdin, WorkerTreeSet workerTreeSet);

    /**
     * Gets help.
     *
     * @return the help
     */
    public abstract String getHelp();
}
