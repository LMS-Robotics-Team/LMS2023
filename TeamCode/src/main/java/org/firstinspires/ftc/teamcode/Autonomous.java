package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class Autonomous extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Init Drive
        Drive.init(hardwareMap);

        // Wait (based on other team)
        // sleep()

        while (opModeIsActive()) {}
    }
}
