package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Auto.SR;
import static org.firstinspires.ftc.teamcode.Rail.maxforce;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class testrail extends OpMode                                                                                                                                                                                                                                                                                                       {
    DcMotor Test,Launch;
    @Override
    public void init() {
        Test = hardwareMap.dcMotor.get("Test");
        Test.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Test.setDirection(DcMotorSimple.Direction.REVERSE);
        Launch = hardwareMap.dcMotor.get("Launch");
        Launch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Test.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


    }

    @Override
    public void loop() {
        /*double power = -gamepad1.left_stick_y*0.8;
        double max = 0.8;
        if  (power > max) {
            power = max;
        } else if (power < -max) {
            power = -max;
        } else {
            power = power * max;
        }

         */
        double launch = -gamepad1.right_stick_x*0.8;
        double max1 = 0.8;
        if  (launch > max1) {
            launch = max1;
        } else if (launch < -max1) {
            launch = -max1;
        } else {
            launch = launch * max1;
        }


        Test.setTargetPosition(100);

        double Case = Test.getCurrentPosition();
        if (gamepad1.a) {
            Test.setPower(0.5);
            Test.getTargetPosition();
        }




        Launch.setPower(launch);


        telemetry.addData("Launch: ","%.3f",launch);
        telemetry.addData("Case:",Case);

        telemetry.update();

    }
}
