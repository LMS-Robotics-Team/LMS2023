package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Drone {
    private static Servo Drone;

    public static final void init(HardwareMap hardwareMap) {
        Drone = hardwareMap.get(Servo.class, "Drone");
        Drone.setPosition(0);
    }

    public static final void launch() {
        Drone.setPosition(0.2);
    }
}
