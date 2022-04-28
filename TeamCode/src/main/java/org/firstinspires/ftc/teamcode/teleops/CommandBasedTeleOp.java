package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BaseRobot;
import org.firstinspires.ftc.teamcode.commands.MoveArmCommand;
import org.firstinspires.ftc.teamcode.shplib.commands.RunCommand;

@TeleOp

public class CommandBasedTeleOp extends BaseRobot {

    @Override
    public void init() {
        super.init();
        drive.setDefaultCommand(
                new RunCommand(
                        () -> drive.mecanum(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x)
                )
        );
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        // BaseRobot loop method MUST be called for CommandScheduler to work
        super.loop();

        if (gamepad1.dpad_up) {
            new MoveArmCommand(arm, 1);
        } else if (gamepad1.dpad_down) {
            new MoveArmCommand(arm, -1);
        } else {
            new MoveArmCommand(arm, 0);
        }
//        new Trigger(gamepad1.dpad_up, new MoveArm(arm, Constants.Arm.kUpperBound));
//        new Trigger(gamepad1.dpad_down, new MoveArm(arm, Constants.Arm.kLowerBound));
    }
}