package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.shplib.commands.Subsystem;

public class Drive extends Subsystem {
    private final DcMotor leftFront;
    private final DcMotor leftBack;
    private final DcMotor rightFront;
    private final DcMotor rightBack;

    public Drive(HardwareMap hardwareMap) {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        rightFront.setDirection(DcMotorEx.Direction.REVERSE);
        rightBack.setDirection(DcMotorEx.Direction.REVERSE);

        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void tankanum(double leftPower, double rightPower, double lateralPower) {
        double leftFrontPower = Range.clip(leftPower - lateralPower, -1.0, 1.0);
        double leftBackPower = Range.clip(leftPower + lateralPower, -1.0, 1.0);
        double rightFrontPower = Range.clip(rightPower - lateralPower, -1.0, 1.0);
        double rightBackPower = Range.clip(rightPower + lateralPower, -1.0, 1.0);

        leftFront.setPower(leftFrontPower);
        leftBack.setPower(leftBackPower);
        rightFront.setPower(rightFrontPower);
        rightBack.setPower(rightBackPower);
    }

    @Override
    public void periodic(Telemetry telemetry) {
        telemetry.addData("Left Front Encoder: ", leftFront.getCurrentPosition());
        telemetry.addData("Left Back Encoder: ", leftBack.getCurrentPosition());
        telemetry.addData("Right Front Encoder: ", rightFront.getCurrentPosition());
        telemetry.addData("Right Back Encoder: ", rightBack.getCurrentPosition());
    }
}
