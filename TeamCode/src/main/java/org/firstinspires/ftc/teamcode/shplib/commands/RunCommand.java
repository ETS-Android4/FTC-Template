package org.firstinspires.ftc.teamcode.shplib.commands;

public class RunCommand extends Command {
    Runnable toRun;

    public RunCommand(Runnable toRun) {
        this.toRun = toRun;
    }

    @Override
    public void execute() {
        toRun.run();
    }
}
