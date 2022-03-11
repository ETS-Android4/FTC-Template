package org.firstinspires.ftc.teamcode.shplib.commands;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Subsystem {
    private Command defaultCommand;

    public Subsystem() {
        CommandScheduler.getInstance().registerSubsystem(this);
    }

    public Command getDefaultCommand() {
        return defaultCommand;
    }

    public void setDefaultCommand(Command defaultCommand) {
        this.defaultCommand = defaultCommand;
    }

    public void periodic(Telemetry telemetry) throws InterruptedException { }
}
