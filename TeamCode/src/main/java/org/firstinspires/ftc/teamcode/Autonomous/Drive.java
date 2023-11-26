package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private static DcMotorEx driveFL, driveFR, driveBL, driveBR;

    public static void init(HardwareMap hardwareMap) {
        // Get motors from hardwareMap
        driveFL = hardwareMap.get(DcMotorEx.class, "motorFL");
        driveFR = hardwareMap.get(DcMotorEx.class, "motorFR");
        driveBL = hardwareMap.get(DcMotorEx.class, "motorBL");
        driveBR = hardwareMap.get(DcMotorEx.class, "motorBR");

        // Reset encoders
        SetMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        // Set to drive mode
        SetMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        // Set left motors to go reverse (relative to motor, not chassis).
        driveFL.setDirection(DcMotorEx.Direction.REVERSE);
        driveBL.setDirection(DcMotorEx.Direction.REVERSE);
    }

    // Sets target position of motors
    public static void SetTargetPosition(int position) {
        driveFL.setTargetPosition(position);
        driveFR.setTargetPosition(position);
        driveBL.setTargetPosition(position);
        driveBR.setTargetPosition(position);
    }

    // Sets speed for motors to reach target distance
    public static void SetSpeed(double power) {
        driveFL.setPower(power);
        driveFR.setPower(power);
        driveBL.setPower(power);
        driveBR.setPower(power);
    }

    // Set the motor's mode
    public static void SetMode(DcMotorEx.RunMode mode) {
        driveFL.setMode(mode);
        driveFR.setMode(mode);
        driveBL.setMode(mode);
        driveBR.setMode(mode);
    }

    public static boolean IsBusy() {
        return driveFL.isBusy() || driveFR.isBusy() || driveBL.isBusy() || driveBR.isBusy();
    }
}
