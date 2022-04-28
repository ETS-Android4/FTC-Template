package org.firstinspires.ftc.teamcode.shplib.hardware.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.shplib.hardware.SHPMotor;

public class FourWheelDrive {
    public final SHPMotor[] motors;

    public FourWheelDrive(HardwareMap hardwareMap, String[] deviceNames) {
        motors = new SHPMotor[4];
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new SHPMotor(hardwareMap, deviceNames[i]);
        }
//        leftFront = new SHPMotor(hardwareMap, "leftFront");
//        leftBack = new SHPMotor(hardwareMap, "leftRear");
//        rightFront = new SHPMotor(hardwareMap, "rightFront");
//        rightBack = new SHPMotor(hardwareMap, "rightRear");
    }

    public void enablePositionPID(double kP) {
        for (SHPMotor motor : motors) {
            motor.enablePositionPID(kP);
        }
    }

    public void enablePositionPID(double kP, double kI, double kD) {
        for (SHPMotor motor : motors) {
            motor.enablePositionPID(kP, kI, kD);
        }
    }

    public void enableVelocityPID(double kP, double maxVelocity, AngleUnit unit) {
        for (SHPMotor motor : motors) {
            motor.enableVelocityPID(kP, maxVelocity, unit);
        }
    }

    public void enableVelocityPID(double kP, double kI, double kD, double maxVelocity, AngleUnit unit) {
        for (SHPMotor motor : motors) {
            motor.enableVelocityPID(kP, kI, kD, maxVelocity, unit);
        }
    }
}
