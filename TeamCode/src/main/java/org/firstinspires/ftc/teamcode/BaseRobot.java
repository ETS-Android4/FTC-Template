package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.commands.MoveArm;
import org.firstinspires.ftc.teamcode.hardware.*;
import org.firstinspires.ftc.teamcode.shplib.commands.Command;
import org.firstinspires.ftc.teamcode.shplib.commands.CommandScheduler;
import org.firstinspires.ftc.teamcode.shplib.commands.RunCommand;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Drive;

/**
 * Template created by Ayaan Govil on 8/21/2021. Last updated on 10/7/21.
 *
 * FTC Java Documentation: http://ftctechnh.github.io/ftc_app/doc/javadoc/index.html
 */

// basebot serves as the first execution point before flowing into the teleop

public class BaseRobot extends OpMode {
    public Drive drive = new Drive(hardwareMap);
    public Arm arm = new Arm(hardwareMap);

    public BaseRobot() {
        CommandScheduler.getInstance().setTelemetry(telemetry);
        // initialize subsystems
    }

    @Override
    public void init() {
        drive.setDefaultCommand(
                new RunCommand(
                        () -> drive.tankanum(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x)
                )
        );
    }

    // this function runs when you hit the start button after the init button
    @Override
    public void start() {
//        CommandScheduler.getInstance().addCommand(new MoveArm(arm).then(new Command().with(new Command())));
    }

    // this function runs when you hit the stop button
    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        CommandScheduler.getInstance().run();
        // telemetry (inherited from OpMode class) serves as logging on the phone - we're constantly tracking the drive motor encoders by doing this

    }
}
