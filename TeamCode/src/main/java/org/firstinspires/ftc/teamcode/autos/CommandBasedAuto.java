package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BaseRobot;
import org.firstinspires.ftc.teamcode.commands.MoveArm;
import org.firstinspires.ftc.teamcode.shplib.commands.CommandScheduler;

@Autonomous
public class CommandBasedAuto extends BaseRobot {
    @Override
    public void init() {
        CommandScheduler.getInstance().addCommand(
                new MoveArm(arm, 1000).then(
                        new MoveArm(arm, 500)
                )
        );
    }
}
