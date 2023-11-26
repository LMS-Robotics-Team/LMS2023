package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private static DcMotorEx Intake, Belt;
    private final static double MAX_SPEED = 0.6;

    public static void init(HardwareMap hardwareMap) {
        // Init motors
        Intake = hardwareMap.get(DcMotorEx.class, "Intake");
        Belt = hardwareMap.get(DcMotorEx.class, "Belt");

        // Set motors to reverse
        Intake.setDirection(DcMotorEx.Direction.REVERSE);
        Belt.setDirection(DcMotorEx.Direction.REVERSE);

        // Turn them off
        Intake.setPower(0);
        Belt.setPower(0);
    }

    public static void HandleInput(Gamepad gamepad2) {
        // Depending on triggers, set motor powers
        if (gamepad2.left_trigger > 0 || gamepad2.right_trigger > 0) {
            if (gamepad2.left_trigger > 0) {
                // Forward
                Intake.setPower(MAX_SPEED);
                Belt.setPower(MAX_SPEED);
            }
            if (gamepad2.right_trigger > 0) {
                // Reverse
                Intake.setPower(-MAX_SPEED);
                Belt.setPower(-MAX_SPEED);
            }
        } else {
            Intake.setPower(0);
            Belt.setPower(0);
        }
    }
}
