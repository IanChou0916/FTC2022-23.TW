package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.teamcode.Auto.RB;
import static org.firstinspires.ftc.teamcode.Rail.maxforce;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class op extends OpMode                                                                                                                                                                                                                                                                                                       {
    DcMotor Test,Launch;
    @Override
    public void init() {
        Test = hardwareMap.dcMotor.get("Test");
        Test.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Test.setDirection(DcMotorSimple.Direction.REVERSE);
        Launch = hardwareMap.dcMotor.get("Launch");
        Launch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }

    @Override
    public void loop() {

        Test.setPower(maxforce(-gamepad1.left_stick_y,0.8) );
        Launch.setPower(maxforce(gamepad1.right_stick_x,0.3));

        telemetry.addData("Power: ","%.3f",maxforce(-gamepad1.left_stick_y,0.8));
        telemetry.addData("Launch: ","%.3f",maxforce(gamepad1.right_stick_x,0.3));
        telemetry.update();

    }
}
