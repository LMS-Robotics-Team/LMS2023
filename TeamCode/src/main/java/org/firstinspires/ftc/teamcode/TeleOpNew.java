package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleOpNew extends LinearOpMode {
    // creates variables for drive inputs from controllers
    private double forwardBackward, leftRight, rotate;

    @Override
    public void runOpMode() {

        // Init
        telemetry.addData("Status", "Initializing...");
        telemetry.update();

        Drive.init(hardwareMap);

        Drone.init(hardwareMap);

        ReleaseFlag.init(hardwareMap);

        Intake.init(hardwareMap);

        telemetry.addData("Status", "Initialization Complete");
        telemetry.update();



        // Wait for the game to start (driver presses PLAY)
        waitForStart();



        // runs until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // sets values of variables for gamepad1 (start+a) inputs for driving
            forwardBackward = -gamepad1.left_stick_y;
            leftRight = gamepad1.left_stick_x;
            rotate = gamepad1.right_trigger - gamepad1.left_trigger;

            Drive.setPower(forwardBackward, leftRight, rotate);

            if (gamepad2.a) {
                Drone.launch();
            }

            if (gamepad2.b) {
                while (!gamepad2.b) {
                    ReleaseFlag.toggle();
                }
            }

            if (gamepad2.x) {
                while (!gamepad2.x) {
                    Intake.toggle();
                }
            }
        }
    }
}