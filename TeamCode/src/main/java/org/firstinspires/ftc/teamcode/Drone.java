package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Drone {
    private static Servo DroneHeight, DroneLaunch;
    private final static double DRONE_OPEN = 0.2, DRONE_CLOSED = 0, DRONE_DOWN = 0.25, DRONE_UP = 0.75;

    public static void init(HardwareMap hardwareMap) {
        DroneHeight = hardwareMap.get(Servo.class, "DroneHeight");
        DroneHeight.setPosition(DRONE_DOWN);

        DroneLaunch = hardwareMap.get(Servo.class, "DroneLaunch");
        DroneLaunch.setPosition(DRONE_CLOSED);
    }

    public static void HandleInput(Gamepad gamepad2) {
        if (gamepad2.a && gamepad2.x) DroneLaunch.setPosition(DRONE_OPEN);
        else DroneLaunch.setPosition(DRONE_CLOSED);

        if (gamepad2.dpad_up && DroneHeight.getPosition() < DRONE_UP) DroneHeight.setPosition(DroneHeight.getPosition() + 0.05);
        if (gamepad2.dpad_down && DroneHeight.getPosition() > DRONE_DOWN) DroneHeight.setPosition(DroneHeight.getPosition() - 0.05);
    }
}
