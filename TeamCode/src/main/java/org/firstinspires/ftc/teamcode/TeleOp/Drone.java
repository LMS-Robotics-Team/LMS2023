package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Drone {
    private static Servo DroneHeight, DroneLaunch;

    // Set constants for servos
    private final static double DRONE_OPEN = 0.2, DRONE_CLOSED = 0, DRONE_MAX = 0.95, DRONE_MIN = 0.8;

    public static void init(HardwareMap hardwareMap) {
        // Init servos and set them to their default values
        DroneHeight = hardwareMap.get(Servo.class, "DroneHeight");
        DroneHeight.setPosition(DRONE_MIN);

        DroneLaunch = hardwareMap.get(Servo.class, "DroneLaunch");
        DroneLaunch.setPosition(DRONE_CLOSED);
    }

    // For TeleOp
    public static void HandleInput(Gamepad gamepad2) {
        if (gamepad2.a && gamepad2.x) DroneLaunch.setPosition(DRONE_OPEN);
        else DroneLaunch.setPosition(DRONE_CLOSED);

        if (gamepad2.dpad_up && DroneHeight.getPosition() > DRONE_MIN) DroneHeight.setPosition(DroneHeight.getPosition() - 0.001);
        if (gamepad2.dpad_down && DroneHeight.getPosition() < DRONE_MAX) DroneHeight.setPosition(DroneHeight.getPosition() + 0.001);
    }
}
