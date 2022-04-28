package org.firstinspires.ftc.teamcode.shplib.controllers;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDController {
    public double kP, kI, kD;

    private double period = 0; // seconds
    private double integralSum = 0;
    private double previousError = 0;

    private double error = 0;
    private double errorTolerance = 0.1;

    private ElapsedTime timer;

    public PIDController(double kP) {
        this.kP = kP;
        this.kI = 0;
        this.kD = 0;
    }

    public PIDController(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        timer = new ElapsedTime();
    }

    private void setPeriod(double period) {
        this.period = period;
    }

    public double getPeriod() {
        return period;
    }

    public void setErrorTolerance(double errorTolerance) {
        this.errorTolerance = errorTolerance;
    }

    public double calculate(double measurement, double setpoint) {
        if (timer != null) {
            setPeriod(timer.seconds());
            timer.reset();
        }

        error = setpoint - measurement;

        // Integral Calculation
        integralSum = integralSum + (error * period);

        // Proportional + Integral
        double output = (kP * error) + (kI * integralSum);

        // + Derivative
        if (period > 0) {
            double derivative = (error - previousError) / period;
            output += (kD * derivative);
        }

        previousError = error;

        return output;
    }

    public boolean atSetpoint() {
        return Math.abs(error) < errorTolerance;
    }
}
