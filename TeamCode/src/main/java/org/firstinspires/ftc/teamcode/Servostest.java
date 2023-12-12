package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Auto.LF;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class Servostest extends OpMode {
    Servo Catches;

    @Override
    public void init() {
        Catches = hardwareMap.servo.get("Catches");
        Catches.setDirection(Servo.Direction.REVERSE);
        Catches.setPosition(0);
    }

    @Override
    public void loop() {
        if (gamepad1.b) Catches.setPosition(0.26);
        else  Catches.setPosition(0.6);


    }
}
