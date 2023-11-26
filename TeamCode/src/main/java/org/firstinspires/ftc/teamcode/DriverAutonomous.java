package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.Autonomous.Drive;
import org.firstinspires.ftc.teamcode.Autonomous.Flag;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class DriverAutonomous extends LinearOpMode {
    private static int inches2Ticks(int inches) {
        // Formula:
        // (inches * Gear Ratio * Motor Ticks per Revolution) / (Pi * Wheel Circumference)

        // Values:
        // return (int) Math.round((inches * 2.01570871261 * 384.5) / (Math.PI * 3.77953));

        // Simplified Version:
        return (int) Math.round(inches * 65.27343193133062);
    }

    @Override
    public void runOpMode() {
        // Init Drive
        Drive.init(hardwareMap);
        Flag.init(hardwareMap);

        telemetry.addData("DEBUG", "Initialization Finished");
        telemetry.update();

        // wait for the game to start (driver presses PLAY)
        waitForStart();

        // Wait (based on other team)
        // sleep()

        while (opModeIsActive()) {
            // Set target position
            Drive.SetTargetPosition(inches2Ticks(50));

            // Set speed of motors to reach target distance
            Drive.SetSpeed(-0.8, -0.8);

            // Start moving
            Drive.SetMode(DcMotorEx.RunMode.RUN_TO_POSITION);

            // Wait until finished moving.
            while (Drive.IsBusy()) sleep(1);

            // Stop moving
            Drive.SetMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

            // Drop pixels
            Flag.SetPosition(Flag.FLAG_OPEN);
        }
    }
}
