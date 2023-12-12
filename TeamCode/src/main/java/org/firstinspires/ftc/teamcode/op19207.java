package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.teamcode.Auto.LB;
import static org.firstinspires.ftc.teamcode.Auto.LF;

import static org.firstinspires.ftc.teamcode.Auto.RB;
import static org.firstinspires.ftc.teamcode.Auto.RF;
import static org.firstinspires.ftc.teamcode.Auto.Catch;
import static org.firstinspires.ftc.teamcode.Auto.SR;

import static org.firstinspires.ftc.teamcode.Chassis.Reverse;
import static org.firstinspires.ftc.teamcode.Rail.height;
import static org.firstinspires.ftc.teamcode.Rail.maxforce;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class op19207 extends OpMode {

    DcMotor garbage1;
    DcMotor garbage2;
    DcMotor garbage3;

    @Override
    public void init() {

        LF = hardwareMap.dcMotor.get("LF");
        LB = hardwareMap.dcMotor.get("LB");
        RF = hardwareMap.dcMotor.get("RF");
        RB = hardwareMap.dcMotor.get("RB");
        SR = hardwareMap.dcMotor.get("SR");
        //Launch = hardwareMap.dcMotor.get("Launch");

        garbage1 = hardwareMap.dcMotor.get("garbage1");
        garbage2 = hardwareMap.dcMotor.get("garbage2");
        garbage3 = hardwareMap.dcMotor.get("garbage3");


        Catch = hardwareMap.servo.get("Catch");


        LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        SR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        garbage1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        garbage2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        garbage3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        garbage1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        garbage2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        garbage3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        Catch.setDirection(Servo.Direction.REVERSE);
        Catch.setPosition(0);

        RF.setDirection(DcMotorSimple.Direction.REVERSE);
        RB.setDirection(DcMotorSimple.Direction.REVERSE);



        telemetry.addLine("Prepare to Start");
        telemetry.addLine("Servo in initializing");
        telemetry.addData("garbage1:", garbage1.getCurrentPosition());
        telemetry.update();



    }

    @Override
    public void loop() {

        // Chassis (Mecanum Wheel)
        double rx = gamepad1.right_trigger - gamepad1.left_trigger;
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.left_stick_y;




        double servo; //servos
        if (gamepad2.a) {
            servo = 0.2;
        }
        else {
            servo = 0.65;
        }
/*
        if (gamepad2.b) {
            SR.setTargetPosition(100);
        }
        else if  (gamepad2.x) {
            SR.setTargetPosition(200);
        }
        else if (gamepad2.y) {
            SR.setTargetPosition(300);
        }

        SR.getTargetPosition();
        double NH = SR.getCurrentPosition();
        double Target = SR.getTargetPosition();

 */
        /*if (NH == Target) {
            SR.setPower(0);
        }
        else if (NH > Target) {
            SR.setPower(-0.3);
        }
        else
            SR.setPower(0.3);


         */
        //Mecanum(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);

        Catch.setPosition(servo);

        LF.setPower(maxforce(y+x+rx,0.7));
        LB.setPower(maxforce(y-x+rx,0.7));
        RF.setPower(maxforce(y-x-rx,0.7));
        RB.setPower(maxforce(y+x-rx,0.7));
        SR.setPower(maxforce(-gamepad2.left_stick_y,1));



        telemetry.addData("Current Position:",SR.getCurrentPosition());
        telemetry.addData("Servo:","%.3f",servo);
        telemetry.addData("Height:","%.3f",-maxforce(gamepad2.left_stick_y,0.8));
        telemetry.addData("y", y);
        telemetry.addData("x",x);
        telemetry.addData("odo1:",garbage1.getCurrentPosition());
        telemetry.addData("odo2:",garbage2.getCurrentPosition());
        telemetry.addData("odo3:",garbage3.getCurrentPosition());

        telemetry.update();
    }
}