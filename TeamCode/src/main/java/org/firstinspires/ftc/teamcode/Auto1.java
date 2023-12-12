package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Auto.Catch;
import static org.firstinspires.ftc.teamcode.Auto.LB;
import static org.firstinspires.ftc.teamcode.Auto.LF;
import static org.firstinspires.ftc.teamcode.Auto.Launch;
import static org.firstinspires.ftc.teamcode.Auto.RB;
import static org.firstinspires.ftc.teamcode.Auto.RF;
import static org.firstinspires.ftc.teamcode.Auto.SR;
import static org.firstinspires.ftc.teamcode.DC_Auto_Run.reset;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class Auto1 extends DC_Auto_Run {
    @Override
    public void runOpMode() {
        LF = hardwareMap.dcMotor.get("LF");
        LB = hardwareMap.dcMotor.get("LB");
        RF = hardwareMap.dcMotor.get("RF");
        RB = hardwareMap.dcMotor.get("RB");
        SR = hardwareMap.dcMotor.get("SR");
        Launch = hardwareMap.dcMotor.get("Launch");

        Catch = hardwareMap.servo.get("Catch");

        LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RF.setDirection(DcMotorSimple.Direction.REVERSE);
        RB.setDirection(DcMotorSimple.Direction.REVERSE);
        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        SR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        Launch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        Catch.setDirection(Servo.Direction.REVERSE);


        waitForStart();

        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        SR.setPower(0.5);
        sleep(1000);


        while (opModeIsActive() && SR.isBusy()) {

            // Display it for the driver.
            telemetry.addData("Running to",  " %7d" , 5000);
            telemetry.addData("Currently at",  " %7d",
                    SR.getCurrentPosition() );
            telemetry.update();
        }







        }
        public void Auleft() {
            left(0.8,700);

            right(0.8,700);

            forward(0.8,550);

        }


    }

