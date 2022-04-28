package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.shplib.commands.Subsystem;
import org.firstinspires.ftc.teamcode.shplib.controllers.PositionPID;
import org.firstinspires.ftc.teamcode.shplib.hardware.SHPMotor;

public class ArmSubsystem extends Subsystem {
    private final SHPMotor motor;
    private final PositionPID controller;
    //    private final ElapsedTime timer;
    private double motorPower = 0;

    private final VoltageSensor voltageSensor;

//    private final double MAX_TICKS_PER_SECOND = 10;

    public ArmSubsystem(HardwareMap hardwareMap) {
        motor = new SHPMotor(hardwareMap, "arm");
//        motor.enableVoltageCompensation(hardwareMap);
        controller = new PositionPID(Constants.Arm.kP, Constants.Arm.kI, Constants.Arm.kD, motor.getCurrentPosition());
        controller.setErrorTolerance(Constants.Arm.kTolerance); // encoder ticks
//        timer = new ElapsedTime();
        voltageSensor = hardwareMap.voltageSensor.iterator().next();
    }

    public void setPosition(double desiredPosition) {
//        double voltageCompensation = Constants.kNominalVoltage / hub.read12vMonitor(ExpansionHubEx.VoltageUnits.VOLTS);

//        arm.setVelocity(
//                Range.clip(controller.calculate(arm.getCurrentPosition(), desiredPosition), -1, 1)
//                        * MAX_TICKS_PER_SECOND
//        );
//        motorPower = Range.clip(controller.calculate(motor.getCurrentPosition(), desiredPosition), -1.0, 1.0);
        motorPower = desiredPosition;
        motor.setPower(motorPower);
    }

    public boolean atPosition() {
        return controller.atSetpoint();
    }

    @Override
    public void periodic(Telemetry telemetry) {
        telemetry.addData("voltage: ", voltageSensor.getVoltage());
        telemetry.addData("loop time (s): ", controller.getPeriod());
        telemetry.addData("power: ", motorPower);
//        telemetry.addData("PID calc: ", controller.calculate(1000));
        controller.setCurrentPosition(motor.getCurrentPosition());
//        controller.setPeriod(timer.seconds());
//        timer.reset();
    }
}
