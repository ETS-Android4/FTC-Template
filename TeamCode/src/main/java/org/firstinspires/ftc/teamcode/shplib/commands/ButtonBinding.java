package org.firstinspires.ftc.teamcode.shplib.commands;

public class ButtonBinding {
    public ButtonBinding(boolean trigger, Command command) {
        if (trigger) CommandScheduler.getInstance().addCommand(command);
    }
}
