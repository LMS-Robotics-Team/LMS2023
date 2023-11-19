package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Flag {
    private static Servo Flag;
    private final static double FLAG_OPEN = 1, FLAG_CLOSED = 0.52;

    public static void init(HardwareMap hardwareMap) {
        Flag = hardwareMap.get(Servo.class, "Flag");
        Flag.setPosition(FLAG_CLOSED);
    }

    public static void HandleInput(Gamepad gamepad2) {
        if (gamepad2.b) {
            Flag.setPosition(FLAG_OPEN);
        } else {
            Flag.setPosition(FLAG_CLOSED);
        }
    }
}
