package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Init
        Drive.init(hardwareMap);
        Drone.init(hardwareMap);
        Flag.init(hardwareMap);
        Intake.init(hardwareMap);

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