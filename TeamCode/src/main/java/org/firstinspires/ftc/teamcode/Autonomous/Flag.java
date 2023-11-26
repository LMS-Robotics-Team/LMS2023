package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Flag {
    private static Servo Flag;

    // Set constants for servos
    public final static double FLAG_OPEN = 1, FLAG_CLOSED = 0.52;

    public static void init(HardwareMap hardwareMap) {
        // Init flag and set it to closed
        Flag = hardwareMap.get(Servo.class, "Flag");
        Flag.setPosition(FLAG_CLOSED);
    }

    public static void SetPosition(double position) {
        Flag.setPosition(position);
    }
}
