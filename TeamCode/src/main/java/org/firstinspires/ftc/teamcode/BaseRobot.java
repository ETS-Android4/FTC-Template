package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.shplib.commands.CommandScheduler;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

/**
 * Template created by Ayaan Govil on 8/21/2021. Last updated on 10/7/21.
 * <p>
 * FTC Java Documentation: http://ftctechnh.github.io/ftc_app/doc/javadoc/index.html
 */

// basebot serves as the first execution point before flowing into the teleop

public class BaseRobot extends OpMode {
    public DriveSubsystem drive;
    public ArmSubsystem arm;

    @Override
    public void init() {
        CommandScheduler.getInstance().setTelemetry(telemetry);
        drive = new DriveSubsystem(hardwareMap);
        arm = new ArmSubsystem(hardwareMap);
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
        try {
            CommandScheduler.getInstance().run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
