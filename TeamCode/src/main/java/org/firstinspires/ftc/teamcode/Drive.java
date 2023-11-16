package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private static DcMotorEx driveFL, driveFR, driveBL, driveBR;;

    public static final void init(HardwareMap hardwareMap) {
        driveFL = hardwareMap.get(DcMotorEx.class, "motorFL");
        driveFR = hardwareMap.get(DcMotorEx.class, "motorFR");
        driveBL = hardwareMap.get(DcMotorEx.class, "motorBL");
        driveBR = hardwareMap.get(DcMotorEx.class, "motorBR");

        driveFL.setPower(0);
        driveFR.setPower(0);
        driveBL.setPower(0);
        driveBR.setPower(0);

        driveFL.setDirection(DcMotorEx.Direction.REVERSE);
        driveBL.setDirection(DcMotorEx.Direction.REVERSE);
    }

    public static final void setPower(double ForwardBackward, double LeftRight, double Rotate) {
        driveFL.setPower(ForwardBackward + LeftRight + Rotate);
        driveFR.setPower(ForwardBackward - LeftRight - Rotate);
        driveBL.setPower(ForwardBackward - LeftRight + Rotate);
        driveBR.setPower(ForwardBackward + LeftRight - Rotate);
    }
}
