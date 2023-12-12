package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.teamcode.Auto.SR;
import static org.firstinspires.ftc.teamcode.DC_Auto_Run.reset;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorREV2mDistance;

@Autonomous
public class Auto0203 extends DC_Auto_Run {

    @Override
    public void runOpMode(){

        SR = hardwareMap.dcMotor.get("SR");
        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        SR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        SR.setDirection(DcMotorSimple.Direction.REVERSE);





        waitForStart();

        telemetry.addData("Current Position:",SR.getCurrentPosition());
        telemetry.update();

        /*
        SR.setTargetPosition(5000);
        SR.setPower(1);
        SR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sleep(2000);
        telemetry.addData("Current Position New:",SR.getCurrentPosition());
        telemetry.update();
        sleep(5000);
        */
    }
}
