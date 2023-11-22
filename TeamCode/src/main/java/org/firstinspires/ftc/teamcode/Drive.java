package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
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

        // Set to default drive mode
        SetMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        // Turn the motors off (set power to 0)
        driveFL.setPower(0);
        driveFR.setPower(0);
        driveBL.setPower(0);
        driveBR.setPower(0);

        // Set left motors to go reverse (relative to motor, not chassis).
        driveFL.setDirection(DcMotorEx.Direction.REVERSE);
        driveBL.setDirection(DcMotorEx.Direction.REVERSE);
    }

    // For TeleOp
    public static void HandleInput(Gamepad gamepad1) {
        // Sets values of variables for gamepad1 (start+a) inputs for driving
        // Creates variables for drive inputs from controllers
        double ForwardBackward = -gamepad1.left_stick_y;
        double LeftRight = gamepad1.left_stick_x;
        double Rotate = gamepad1.right_trigger - gamepad1.left_trigger;

        // Set drive powers and if pressing a, half speed.
        if (gamepad1.a) {
            driveFL.setPower((ForwardBackward + LeftRight + Rotate) / 2);
            driveFR.setPower((ForwardBackward - LeftRight - Rotate) / 2);
            driveBL.setPower((ForwardBackward - LeftRight + Rotate) / 2);
            driveBR.setPower((ForwardBackward + LeftRight - Rotate) / 2);
        } else {
            driveFL.setPower(ForwardBackward + LeftRight + Rotate);
            driveFR.setPower(ForwardBackward - LeftRight - Rotate);
            driveBL.setPower(ForwardBackward - LeftRight + Rotate);
            driveBR.setPower(ForwardBackward + LeftRight - Rotate);
        }
    }

    private static void SetMode(DcMotorEx.RunMode mode) {
        driveFL.setMode(mode);
        driveFR.setMode(mode);
        driveBL.setMode(mode);
        driveBR.setMode(mode);
    }

    // For Autonomous
    public static void MoveTo(int ticks) {
        driveFL.setTargetPosition(ticks);
        driveFR.setTargetPosition(ticks);
        driveBL.setTargetPosition(ticks);
        driveBR.setTargetPosition(ticks);

        SetMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
}
