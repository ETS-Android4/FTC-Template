package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.shplib.commands.Subsystem;
import org.firstinspires.ftc.teamcode.shplib.controllers.PID;
import org.openftc.revextensions2.ExpansionHubEx;

public class Arm extends Subsystem {
    private final DcMotorEx motor;
    private final PID controller;
    private final ElapsedTime timer;

    private final ExpansionHubEx hub;

//    private final double MAX_TICKS_PER_SECOND = 10;

    public Arm(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorEx.class, "arm");
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        controller = new PID(Constants.Arm.kP, Constants.Arm.kI, Constants.Arm.kD);
        controller.setErrorTolerance(Constants.Arm.kTolerance); // encoder ticks
        timer = new ElapsedTime();
        hub = hardwareMap.get(ExpansionHubEx.class, "Expansion Hub 2");
//        hardwareMap.voltageSensor.iterator().next();
    }

    public void setPosition(double desiredPosition) {
//        double voltageCompensation = Constants.kNominalVoltage / hub.read12vMonitor(ExpansionHubEx.VoltageUnits.VOLTS);

//        arm.setVelocity(
//                Range.clip(controller.calculate(arm.getCurrentPosition(), desiredPosition), -1, 1)
//                        * MAX_TICKS_PER_SECOND
//        );

        motor.setPower(Range.clip(controller.calculate(motor.getCurrentPosition(), desiredPosition), -1, 1));
    }

    public boolean atPosition() {
        return controller.atSetpoint();
    }

    @Override
    public void periodic(Telemetry telemetry) {
        telemetry.addData("voltage: ", hub.read12vMonitor(ExpansionHubEx.VoltageUnits.VOLTS));
        telemetry.addData("loop time (ms): ", timer.milliseconds());
        controller.setPeriod(timer.seconds());
        timer.reset();
    }
}
