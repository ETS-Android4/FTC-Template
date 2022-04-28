package org.firstinspires.ftc.teamcode.shplib.hardware.drive;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.shplib.hardware.SHPMotor;

public class SHPMecanumDrive extends FourWheelDrive {

    public SHPMecanumDrive(HardwareMap hardwareMap, String[] deviceNames) {
        super(hardwareMap, deviceNames);
        motors[2].setDirection(DcMotorSimple.Direction.REVERSE);
        motors[3].setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void tankanum(double leftY, double rightY, double rightX) {

    }

    public void mecanum(double leftY, double leftX, double rightX, boolean fieldCentric) {
        double[] powers = {
                leftY - leftX - rightX,
                leftY + leftX - rightX,
                leftY + leftX + rightX,
                leftY - leftX + rightX,
        };

        for (int i = 0; i < motors.length; i++) {
            motors[i].set(Range.clip(powers[i], -1.0, 1.0));
        }
    }
}
