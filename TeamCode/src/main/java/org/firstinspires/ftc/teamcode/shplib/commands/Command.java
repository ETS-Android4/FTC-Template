package org.firstinspires.ftc.teamcode.shplib.commands;

public class Command {
    private Command nextCommand;
    private Command withCommand;

    public void initialize() {
        if (withCommand != null) CommandScheduler.getInstance().addCommand(withCommand);
    }

    public void execute() {

    }

    public void end() {
        if (nextCommand != null) CommandScheduler.getInstance().addCommand(nextCommand);
    }

    public boolean isFinished() {
        return false;
    }

    public final Command getNextCommand() {
        return nextCommand;
    }

    public final Command then(Command command) {
        this.nextCommand = command;
        return this;
    }

    public final Command with(Command command) {
        this.withCommand = command;
        return this;
    }
}
