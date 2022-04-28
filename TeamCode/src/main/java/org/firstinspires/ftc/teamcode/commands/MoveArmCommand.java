package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.shplib.commands.Command;
import org.firstinspires.ftc.teamcode.shplib.commands.CommandScheduler;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class MoveArmCommand extends Command {
    private final ArmSubsystem arm;
    private final double position;

    public MoveArmCommand(ArmSubsystem arm, double position) {
        this.arm = arm;
        this.position = position;
        CommandScheduler.getInstance().addCommand(this);
    }

    @Override
    public void execute() {
        arm.setPosition(position);
    }

    @Override
    public boolean isFinished() {
//        return arm.atPosition();
        return true;
    }
}
