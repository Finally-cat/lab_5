package ru.itmo.sigma.commands;

public class TestCommand extends Command{

    public TestCommand() {
        super("test");
    }

    @Override
    public  String getName() {
        return super.name;}

    @Override
    public void execute() {

    }

    @Override
    public String getHelp() {
        return "Test";
    }
}
