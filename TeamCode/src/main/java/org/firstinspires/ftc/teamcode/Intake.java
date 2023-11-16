package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private static DcMotorEx Intake, Belt;

    private static boolean IsRunning = false;

    public static final void init(HardwareMap hardwareMap) {
        Intake = hardwareMap.get(DcMotorEx.class, "Intake");
        Belt = hardwareMap.get(DcMotorEx.class, "Belt");

        Intake.setPower(0);
        Belt.setPower(0);
    }

    public static final void toggle() {
        if (IsRunning) {
            Intake.setPower(0);
            Belt.setPower(0);
            IsRunning = false;
        } else {
            Intake.setPower(0.5);
            Belt.setPower(0.5);
            IsRunning = true;
        }
    }
}
