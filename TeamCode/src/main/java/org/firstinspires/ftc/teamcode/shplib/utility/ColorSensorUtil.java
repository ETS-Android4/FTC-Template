package org.firstinspires.ftc.teamcode.shplib.utility;

public final class ColorSensorUtil {
    public static boolean checkBlackColor(int red, int blue) {
        return blue > (3.0 / 4) * red;
    }

    public static boolean checkGreenColor(int green, int blue, int red) {
        return green > blue + red;
    }

    public static boolean checkBlueColor(int green, int blue, int red) {
        return blue > green + red;
    }

    public static boolean checkRedColor(int green, int blue, int red) {
        return red > blue + green;
    }
}
