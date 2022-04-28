package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.shplib.commands.Subsystem;
import org.firstinspires.ftc.teamcode.shplib.hardware.drive.SHPMecanumDrive;

public class DriveSubsystem extends Subsystem {
//    private final SHPMotor leftFront;
//    private final SHPMotor leftBack;
//    private final SHPMotor rightFront;
//    private final SHPMotor rightBack;

    private final SHPMecanumDrive drive;

//    private final VelocityPID controller = new VelocityPID(0.01, 0);

    public DriveSubsystem(HardwareMap hardwareMap) {
        drive = new SHPMecanumDrive(hardwareMap, new String[]{"leftFront", "leftRear", "rightFront", "rightRear"});
        drive.enableVelocityPID(0.03, 3.0, AngleUnit.RADIANS);
//        leftFront = new SHPMotor(hardwareMap, "leftFront");
//        leftBack = new SHPMotor(hardwareMap, "leftRear");
//        rightFront = new SHPMotor(hardwareMap, "rightFront");
//        rightBack = new SHPMotor(hardwareMap, "rightRear");
//
//        rightFront.setDirection(DcMotorEx.Direction.REVERSE);
//        rightBack.setDirection(DcMotorEx.Direction.REVERSE);
//
//        leftFront.enableVelocityPID(0.03, AngleUnit.RADIANS);
//        leftBack.enableVelocityPID(0.03, AngleUnit.RADIANS);
//        rightFront.enableVelocityPID(0.03, AngleUnit.RADIANS);
//        rightBack.enableVelocityPID(0.03, AngleUnit.RADIANS);

    }

//    public void tankanum(double leftPower, double rightPower, double lateralPower) {
//        double leftFrontPower = Range.clip(leftPower - lateralPower, -1.0, 1.0);
//        double leftBackPower = Range.clip(leftPower + lateralPower, -1.0, 1.0);
//        double rightFrontPower = Range.clip(rightPower + lateralPower, -1.0, 1.0);
//        double rightBackPower = Range.clip(rightPower - lateralPower, -1.0, 1.0);
//
////        leftFront.setPower(leftFrontPower);
////        leftBack.setPower(leftBackPower);
////        rightFront.setPower(rightFrontPower);
////        rightBack.setPower(rightBackPower);
//
//        leftFront.setVelocity(leftFrontPower * 3.0);
//        leftBack.setVelocity(leftBackPower * 3.0);
//        rightFront.setVelocity(rightFrontPower * 3.0);
//        rightBack.setVelocity(rightBackPower * 3.0);
//
//    }

    public void mecanum(double leftY, double leftX, double rightX) {
        drive.mecanum(leftY, leftX, rightX, false);
    }

//    public double getVelocityRadians() {
//        return (leftFront.getVelocity(AngleUnit.RADIANS) + leftBack.getVelocity(AngleUnit.RADIANS)
//                + rightFront.getVelocity(AngleUnit.RADIANS) + rightBack.getVelocity(AngleUnit.RADIANS)) / 4;
//    }

    @Override
    public void periodic(Telemetry telemetry) {
//        telemetry.addData("Velocity: ", leftFront.getVelocity(AngleUnit.RADIANS));
//        telemetry.addData("PID calc: ", controller.calculate(5));
        //        telemetry.addData("Left Front Encoder: ", leftFront.getCurrentPosition());
//        telemetry.addData("Left Back Encoder: ", leftBack.getCurrentPosition());
//        telemetry.addData("Right Front Encoder: ", rightFront.getCurrentPosition());
//        telemetry.addData("Right Back Encoder: ", rightBack.getCurrentPosition());
    }
}
