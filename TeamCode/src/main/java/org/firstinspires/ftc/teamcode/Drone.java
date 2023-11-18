package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Drone {
    private static Servo Drone;
    private final static double DRONE_OPEN = 0.2, DRONE_CLOSED = 0;

    public static void init(HardwareMap hardwareMap) {
        Drone = hardwareMap.get(Servo.class, "Drone");
        Drone.setPosition(DRONE_CLOSED);
    }

    public static void HandleInput(boolean gamepad2_a) {
        if (gamepad2_a) Drone.setPosition(DRONE_OPEN);
        else Drone.setPosition(DRONE_CLOSED);
    }
}
