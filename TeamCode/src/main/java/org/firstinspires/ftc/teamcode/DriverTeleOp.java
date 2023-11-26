package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.TeleOp.Drive;
import org.firstinspires.ftc.teamcode.TeleOp.Drone;
import org.firstinspires.ftc.teamcode.TeleOp.Flag;
import org.firstinspires.ftc.teamcode.TeleOp.Intake;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class DriverTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Init
        Drive.init(hardwareMap);
        Drone.init(hardwareMap);
        Flag.init(hardwareMap);
        Intake.init(hardwareMap);

        telemetry.addData("DEBUG", "Initialization Finished");
        telemetry.update();

        // wait for the game to start (driver presses PLAY)
        waitForStart();

        // runs until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Each class handles it's own input from the gamepad passed in.
            Drive.HandleInput(gamepad1);
            Drone.HandleInput(gamepad2);
            Flag.HandleInput(gamepad2);
            Intake.HandleInput(gamepad2);
        }
    }
}