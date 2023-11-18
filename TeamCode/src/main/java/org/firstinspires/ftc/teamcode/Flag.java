package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Flag {
    private static Servo Flag;
    private static double FLAG_OPEN = 1, FLAG_CLOSED = 0.52;

    public static final void init(HardwareMap hardwareMap) {
        Flag = hardwareMap.get(Servo.class, "Flag");
        Flag.setPosition(FLAG_CLOSED);
    }

    public static final void HandleInput(boolean gamepad2_b) {
        if (gamepad2_b) {
            Flag.setPosition(FLAG_OPEN);
        } else {
            Flag.setPosition(FLAG_CLOSED);
        }
    }
}
