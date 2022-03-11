package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BaseRobot;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.commands.MoveArm;
import org.firstinspires.ftc.teamcode.shplib.commands.ButtonBinding;

@TeleOp

public class CommandBasedTeleOp extends BaseRobot {

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        super.loop();
        new ButtonBinding(gamepad1.dpad_up, new MoveArm(arm, Constants.Arm.kUpperBound));
        new ButtonBinding(gamepad1.dpad_down, new MoveArm(arm, Constants.Arm.kLowerBound));
    }
}