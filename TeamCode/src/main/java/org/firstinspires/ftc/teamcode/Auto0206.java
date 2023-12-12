package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class Auto0206 extends DC_Auto_Run {

    @Override
    public void runOpMode(){

        LF = hardwareMap.dcMotor.get("LF");
        LB = hardwareMap.dcMotor.get("LB");
        RF = hardwareMap.dcMotor.get("RF");
        RB = hardwareMap.dcMotor.get("RB");
        SR = hardwareMap.dcMotor.get("SR");
        Catch = hardwareMap.servo.get("Catch");
        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        initialization();
        waitForStart();
        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        RailEncoder(0.8,5000);
        while(opModeIsActive() && SR.isBusy()) {
            telemetry.addData("Running to",  " %7d ",3400);
            telemetry.addData("Currently at",  " at %7d ", SR.getCurrentPosition() );

            telemetry.update();
        }
        SR.setPower(0);
        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(250);



        // Turn off RUN_TO_POSITION


        //Encoderforward(1, 75000);




/*

        sleep(5000);

        Catch.setPosition(0.2);
        forward(0.7,2500);
        turn(0.7,500);
        RailPower(0.5,1500);*/

    }
}
