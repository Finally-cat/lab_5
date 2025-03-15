package ru.itmo.sigma.commands;

import ru.itmo.sigma.data.WorkerTreeSet;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Objects;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help");
    }

    @Override
    public void execute(String[] args, Environment env, PrintStream stderr, PrintStream out, InputStream in, WorkerTreeSet workerTreeSet) {
        out.println("Available commands:");
        for (Map.Entry<String, Command> entry : env.getStringCommandHashMap().entrySet()) {
            out.println(entry.getKey() + " - " + entry.getValue().getHelp());
        }
        if (args.length != 0) {
            if (Objects.equals(args[0], "pashalko")) {
                out.println("Тебе никто не поможет..." + ".\n" +
                        "⣿⣿⣿⢿⡿⣁⠐⣿⣿⣿⣿⣿⣿⣷⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⢿⣷⢹⣿⣿⣿⣿⣿⣿⣾⢄⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⣙⣛⣾⢿⠙⠁⣠⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣳⢻⣿⣿⣿⣿⣿⣿⣿⣅⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⠈⠁⠀⠀⢠⢞⣉⣽⣿⣿⣿⣿⣿⣿⣿⣧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⡧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡿⣽⣿⣿⣿⡿⡿⣷⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠈⢻⣿⣏⣿⣿⣹⣿\n" +
                        "⠀⠀⠀⠀⣪⣼⣿⣿⣻⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡏⣨⣿⡿⡿⣿⣿⠾⠿⠶⠤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠿⣿⡿⠍⠁⢻⣿⣿⣿⣿⣿⣿⣿⣽⣽⣽⣆⠀⠊⢿⣥⣬⣿⣿⣿\n" +
                        "⠀⠀⢀⠀⠀⠉⡚⣿⣾⣿⣿⠿⣿⣏⣿⣿⣿⣿⣿⡟⠡⢖⣿⣷⣸⣿⠃⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣈⣁⠀⠀⢀⣘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠻⣿⣿⣿⣿⣿\n" +
                        "⠀⢀⠀⠀⠀⠀⣒⣿⣿⣛⢢⡀⣸⣿⣿⣿⣿⣿⣿⣗⣤⣾⣿⣿⣿⢿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣯⡀⠀⠀⢉⣿⣿⣿⣿⣿⣿⣿⣿⣷⡋⠳⡑⢾⣿⣿⣿⡏\n" +
                        "⢀⡀⠀⠀⠀⢺⣿⣿⣿⣷⣮⣙⣿⣿⣿⣿⣿⣿⠋⣼⣿⣿⣿⡿⠿⢾⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⣿⣿⣿⣿⣿⣄⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⠟⡃⠀⢿⣦⣿⣿⣿⣿\n" +
                        "⠈⠻⠀⠀⠀⣾⣿⡷⢿⣿⣿⣿⣿⣿⣿⣿⣿⡏⢰⣿⣿⣏⣫⡀⠀⠀⠉⢿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⠟⠁⠀⠀⠀⠀⠙⠷⠄⠀⢸⣿⣿⣿⣿⣿⢿⣟⣶⡀⢦⣈⣿⣿⡄⣿⣿\n" +
                        "⠀⠀⠂⠀⠀⠈⢹⣷⣴⣿⣿⣿⣿⣿⣿⣿⣿⠁⣼⣿⣿⣿⣏⣉⣣⣤⣰⣦⣽⣿⣿⣦⡄⠀⠂⠀⠀⠀⠀⠀⠀⠀⢀⢀⠀⠀⠀⠀⣀⣴⣿⠟⣁⣤⣄⣀⡀⠀⠀⠀⠀⠀⡀⢸⣿⣿⣿⣿⣿⣷⣝⡜⠉⠸⣟⣙⣿⣶⣿⡿\n" +
                        "⠀⠀⠀⠀⠀⠀⢈⣿⣾⣿⡯⠿⣿⣿⣿⣿⡏⠀⠋⣼⣿⣿⣿⣿⣟⣫⣿⣿⣿⣿⣿⣿⣿⣓⡖⡒⠀⡠⠀⠀⠀⠀⢠⠁⠀⣀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⢿⣛⣤⣴⣶⢀⠇⢸⣿⣿⣿⣟⣿⣿⣿⡀⠐⣦⢻⠿⡛⠿⠋⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠿⣿⣙⣷⣿⣿⣿⣿⡇⠀⣜⣿⣿⣿⣿⠿⠉⢠⡶⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣥⣀⡀⠀⠀⣰⣻⣼⣿⣿⣿⣿⡿⣿⠿⠟⠏⠙⢿⣷⣿⣿⣿⣿⠜⠀⢸⣿⣿⣿⣿⣿⣿⣿⣧⠈⠃⠀⠀⠐⡀⠀⠰\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⣾⣿⣿⣿⣿⠀⠀⠀⠙⢿⣿⣿⣦⣄⣸⣁⢿⠇⣾⣿⣿⣿⣿⣿⢿⣿⣉⣀⠀⠀⠠⠀⢹⣿⣿⣿⣿⠋⠸⡏⠸⠗⠀⡄⣠⣼⣿⣿⣿⣿⠧⠀⢸⣿⣿⡿⠻⣿⣿⣷⠹⣦⡄⠀⠠⠀⠶⣴⣿\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⠀⠀⠂⠀⠉⢉⣿⣿⢶⣮⣭⣍⣍⣭⣵⣼⣫⣽⣿⠀⠈⠀⠀⠀⠀⠀⢠⢎⣿⣿⣿⣟⣓⣂⣩⣀⣉⡉⣉⣨⡭⠿⡯⠍⢍⡁⠀⠈⣿⢚⣥⣶⣿⡿⣿⠂⠸⠃⠀⠀⠀⣴⣼⣿\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣽⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠉⢉⡙⢋⣹⣉⣛⣿⣿⠟⠛⠋⠀⠁⠀⠀⠀⠀⠀⠈⢸⠚⠹⣟⡫⣍⣛⢻⠿⢿⡏⠉⣉⡂⠄⠀⣁⠀⠈⠀⠀⣀⣯⣿⡟⠉⠀⠀⠀⠒⠀⠀⠀⠀⢾⢿⣿\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠹⣽⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠀⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠉⠁⠀⠀⠉⠉⠁⠂⠈⠀⠀⠀⠀⠀⠀⡐⠀⣝⣟⣯⠾⣽⠷⠎⠁⢀⠀⠀⡠⡀⣾⣿⡿\n" +
                        "⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠄⢻⣿⡇⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣄⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⣌⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡄⡀⢰⠄⢢⢸⡿⣷⠱⠀⠀⠀⠀⠀⠑⠈⠉⢻⡞⢿⣿\n" +
                        "⠀⠀⠀⠀⠀⢀⠰⠀⠀⠀⠀⠁⠀⢸⣿⠃⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠤⣾⠟⠉⠑⠀⠀⠀⠀⠀⠀⠀⠀⠞⠉⠙⣷⣤⡀⠀⠀⠀⠀⠀⠀⠀⢠⣤⡾⠋⠐⣸⣮⣬⣿⣾⡦⢦⣼⣿⣄⣀⠀⠰⡂⠸⠀⠸⠟\n" +
                        "⠀⠀⠀⠀⠀⣸⠀⠀⠀⠀⠀⠀⠀⠈⣿⠖⢿⠒⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⠋⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣟⣿⣗⣄⡀⠀⠀⠀⠀⢀⡘⠑⢰⣿⡵⣿⣹⠻⠀⣾⣦⡭⠤⠿⠀⠂⠀⠁⠀⠀⣀⣅\n" +
                        "⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⡀⠀⠈⠀⠙⠃⢢⠀⠀⠀⠀⠀⠀⢠⣴⠞⠁⠀⠀⠘⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣬⡶⠃⠀⠉⠻⣕⣀⠀⠀⠀⠸⠃⣰⣿⣿⣿⣿⡉⠀⠀⣿⠟⠀⠠⠀⠀⠀⠀⠀⠀⠘⠋⠻\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⣶⣿⡅⢀⠀⣀⣤⣾⣟⡁⠀⠀⠀⠀⠀⠀⠉⠿⣿⣆⠀⠀⠀⠀⠀⠀⢀⣼⣿⠟⠁⠀⠀⠀⠀⠈⢻⣿⣶⣖⣳⣿⣿⣿⣿⡿⠻⠇⢠⡾⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣷⣾\n" +
                        "⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⠉⠙⠇⢰⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢦⢀⠀⠀⣀⣤⣾⠟⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⠅⣛⠀⡼⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⢿⣿\n" +
                        "⣀⠀⠚⠛⠲⣿⣶⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⠀⠀⠋⢿⣿⣿⣿⣿⣿⣇⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠙⠉⠁⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⡿⢡⡇⠸⠿⠑⠀⠀⠀⠀⠀⠀⠀⠀⠂⠀⢀⡻⣻⣾⣿\n" +
                        "⠫⠀⠀⠀⠀⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢻⡿⣿⣿⣿⣿⣶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣶⣾⣿⣿⣿⣿⣿⣿⣿⠯⡤⡼⠃⠲⡀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠐⠈⠀⠑⠙⢿\n" +
                        "⠀⠀⠀⢰⣿⠸⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠅⢹⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⣄⣤⣤⣴⣶⣾⣿⡿⣿⣿⣿⣿⣿⣿⣿⡿⠉⠀⠉⠈⢸⡇⠀⡂⠀⡔⠄⠀⠀⠀⠀⠀⠀⢀⣤⡆⠀⠀⢀⣽⣿\n" +
                        "⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⢼⡿⠂⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣧⡋⠻⠁⠀⠀⠀⠀⠉⠫⠉⠋⠉⢍⠌⠁⠀⠉⢸⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⡞⢸⠀⠀⠀⣆⠁⠀⠀⠀⠠⠀⠀⠈⠉⠀⠀⠀⣦⡿⣿\n" +
                        "⠀⠀⠀⠀⠻⠗⠀⠁⠀⢀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣽⣿⢷⣄⠀⠀⠀⠀⠀⠀⠀⠂⠀⠀⠀⠀⠀⠀⣄⣾⢿⣿⣿⢏⢄⣆⠀⠀⠀⢰⢳⡇⢀⡆⣐⠻⠂⠀⠀⠀⠀⠀⠀⠀⠐⣤⣄⣿⣿⣿⣿\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠘⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣔⡀⠀⠀⢻⣿⣿⣿⡉⠒⠒⠀⠄⠀⠀⠀⠀⠀⡀⠄⠀⠂⠈⠁⣿⣾⣿⡏⣾⣾⣿⠀⠀⠀⡏⣸⠀⣸⣿⠟⠀⠀⠀⠀⠀⣄⣀⡀⠀⣼⣿⣯⣘⣿⣿⣿\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠀⣀⠀⠙⣣⠀⠀⠈⢿⣿⣿⣿⣦⣀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⢀⣄⣴⣿⣿⣿⣻⣿⣿⠇⠀⠀⣼⡆⡏⠀⢿⡏⣠⣶⣀⠠⣍⠷⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠾⠅⡄⠀⠁⠀⠠⠀⠀⢉⣷⠀⠀⠘⢿⣿⣿⣿⠿⠶⠶⢶⣧⠤⡤⣤⣤⣰⡤⢾⣿⣿⣿⡿⣿⠋⣿⡏⠀⠀⢰⠉⠁⢠⡀⠈⠐⡙⠍⣿⣳⠾⠟⣹⣻⣯⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⠰⠄⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠈⠁⠀⢠⣲⣶⣶⣿⠦⣧⣶⣧⠀⠀⠸⣇⠀⠀⠀⠙⠛⣿⢁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣿⡛⠋⠠⠁⢰⡿⠀⠀⢀⡟⠀⣰⣿⣿⡄⠀⠱⡀⢠⠏⠀⣸⣿⣼⣟⢿⣿⣿⣿⣿⣿⠟⠻\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⢠⡄⠀⠀⠀⠀⠒⠀⣠⣿⣿⡿⣳⠀⡋⣧⢿⡆⠀⠀⠙⠄⠀⠀⠀⠀⠈⠙⠓⠀⠀⠀⠀⠀⠀⠀⠀⠨⠏⠋⠁⠀⠀⣸⣿⠇⠀⢀⠾⠀⣰⣿⣿⣿⣿⣦⡈⣶⣜⠞⡈⢿⣿⣿⣿⣿⣿⣿⣷⡞⠁⠀⠰\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣰⣾⣿⡿⣿⣿⠀⣿⣿⣿⣿⡆⠀⠀⠰⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣯⣦⠂⡘⠀⣼⣿⣿⣿⣿⣿⣟⣩⣿⡻⣌⠓⡾⠻⣿⡿⣿⣟⣻⡿⠍⠀⢀⣶\n" +
                        "⠀⠀⠀⠀⠀⠒⠀⠀⠀⠀⠀⠀⣤⣿⣿⣿⣿⣼⣿⣿⠀⠹⣿⣿⣿⣿⡄⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⣀⣀⠤⠤⠖⠀⠀⠀⢸⣿⣿⡇⢰⠃⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣎⠦⠣⣄⠂⠻⣿⣿⣿⣷⣄⠀⡈⢹\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⣿⣿⣿⣿⡟⣿⣿⣯⣺⣼⣿⣿⣿⣿⢿⡀⠀⠀⠀⠀⠀⠀⠀⠐⠒⠛⠛⠛⠛⠂⠐⠀⠀⠀⠀⠀⠀⣾⣿⣏⢴⢃⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⢤⢸⣄⠑⠊⠈⠿⠻⠁⠘⣿⣾\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢼⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡑⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠴⠤⠤⠄⠀⠀⠀⠀⠀⢰⣿⣯⣾⣣⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠙⢷⡒⢆⡐⢄⠀⠀⠀⠙\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⣧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣱⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⡂⢤⡀⢅⠀⠍⣀⣀⢀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠎⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣧⣤⡝⢢⣀⠉⠙\n" +
                        "⠀⠀⠀⠀⠀⠀⣠⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢠⣿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤\n" +
                        "⠀⠀⠀⠀⠀⢀⣹⠠⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⣠⡀⠁⠀⠀⠾⡏⣶⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣴⡖⠀⠀⠀⠀⢀⣠⠀⠀⠀⠀⠀⢤⣎⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n");

            }
        }
    }

    @Override
    public String getHelp() {
        return "Displays the list of available commands";
    }
}
