package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.teamcode.Auto.SR;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class test0202 extends OpMode {
    @Override
    public void init() {
        SR = hardwareMap.dcMotor.get("SR");
        SR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        SR.setTargetPosition(0);

    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            SR.setTargetPosition(100);
            SR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            SR.setPower(0.2);

        }
        else if (gamepad1.b) {
            SR.setTargetPosition(50);
            SR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            SR.setPower(0.2);

        }
        int T = SR.getTargetPosition();
        
        int P = SR.getCurrentPosition();
        if (P == T) {
            SR.setPower(0);
        }
        telemetry.addData("Current Position : ",P);
        telemetry.addData("Target Position : ",T);
    }
}
