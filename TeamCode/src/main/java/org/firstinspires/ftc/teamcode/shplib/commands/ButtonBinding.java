package org.firstinspires.ftc.teamcode.shplib.commands;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ButtonBinding {
    public ButtonBinding(boolean trigger, Command command) {
        if (trigger) CommandScheduler.getInstance().addCommand(command);
    }
}
