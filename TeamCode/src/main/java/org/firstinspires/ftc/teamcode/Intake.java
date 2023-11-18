package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private static DcMotorEx Intake, Belt;

    public static void init(HardwareMap hardwareMap) {
        Intake = hardwareMap.get(DcMotorEx.class, "Intake");
        Belt = hardwareMap.get(DcMotorEx.class, "Belt");

        Intake.setPower(0);
        Belt.setPower(0);
    }

    public static void HandleInput(float gamepad2_leftTrigger) {
        if (gamepad2_leftTrigger > 0) {
            Intake.setPower(0);
            Belt.setPower(0);
        } else {
            Intake.setPower(0.5);
            Belt.setPower(0.5);
        }
    }
}
