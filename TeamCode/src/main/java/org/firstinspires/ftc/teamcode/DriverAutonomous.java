package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.Autonomous.Drive;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class DriverAutonomous extends LinearOpMode {
    private static int inches2Ticks(int inches) {
        // Formula: (inches * Gear Ratio * Motor Ticks per Revolution) / (Pi * Wheel Circumference)
        // return (int) Math.round((inches * 2.01570871261 * 384.5) / (Math.PI * 3.77953));
        return (int) Math.round((inches * 775.039999998545) / 11.87374368202223);
    }

    @Override
    public void runOpMode() {
        // Init Drive
        Drive.init(hardwareMap);

        telemetry.addData("DEBUG", "Initialization Finished");
        telemetry.update();

        // wait for the game to start (driver presses PLAY)
        waitForStart();

        // Wait (based on other team)
        // sleep()

        while (opModeIsActive()) {
            while (!(Drive.IsBusy())) {
                // Set target position
                Drive.SetTargetPosition(inches2Ticks(15));

                // Set speed of motors to reach target distance
                Drive.SetSpeed(0.8);

                // Start moving
                Drive.SetMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            }

            Drive.SetSpeed(0);

            telemetry.addData("DEBUG", "Finished moving 15 inches and speed set to 0");
            telemetry.update();
        }
    }
}
