package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ReleaseFlag {
    private static Servo Flag;

    private static boolean IsOpen = false;

    public static final void init(HardwareMap hardwareMap) {
        Flag = hardwareMap.get(Servo.class, "Flag");
        Flag.setPosition(0);
    }

    public static final void toggle() {
        if (IsOpen) {
            IsOpen = false;
            Flag.setPosition(0.52);
        } else {
            IsOpen = true;
            Flag.setPosition(1);
        }
    }
}
