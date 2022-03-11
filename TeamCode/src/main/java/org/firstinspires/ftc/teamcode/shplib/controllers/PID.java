package org.firstinspires.ftc.teamcode.shplib.controllers;

public class PID {
    public double kP, kI, kD;

    private double period = 0; // seconds
    private double integralSum = 0;
    private double previousError = 0;

    private double error = 0;
    private double errorTolerance = 0.05;

    public PID(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public PID(double kP, double kI, double kD, double period) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.period = period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public void setErrorTolerance(double errorTolerance) {
        this.errorTolerance = errorTolerance;
    }

    public double calculate(double measurement, double setpoint) {
        error = setpoint - measurement;

        integralSum = integralSum + (error * period);
        double derivative = (error - previousError) / period;

        double output = (kP * error) + (kI * integralSum) + (kD * derivative);

        previousError = error;

        return output;
    }

    public boolean atSetpoint() {
        return Math.abs(error) < errorTolerance;
    }
}
