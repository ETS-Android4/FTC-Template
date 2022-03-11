package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.shplib.commands.Command;
import org.firstinspires.ftc.teamcode.subsystems.Arm;

public class MoveArm extends Command {
    private final Arm arm;
    private final double position;

    public MoveArm(Arm arm, double position) {
        this.arm = arm;
        this.position = position;
    }

    @Override
    public void execute() {
        arm.setPosition(position);

    }

    @Override
    public boolean isFinished() {
        return arm.atPosition();
    }
}
