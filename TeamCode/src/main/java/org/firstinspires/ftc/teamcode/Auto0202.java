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
public class Auto0202 extends DC_Auto_Run {
    @Override
    public void runOpMode() {
        LF = hardwareMap.dcMotor.get("LF");
        LB = hardwareMap.dcMotor.get("LB");
        RF = hardwareMap.dcMotor.get("RF");
        RB = hardwareMap.dcMotor.get("RB");
        SR = hardwareMap.dcMotor.get("SR");



        Catch = hardwareMap.servo.get("Catch");


        LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RF.setDirection(DcMotorSimple.Direction.REVERSE);
        RB.setDirection(DcMotorSimple.Direction.REVERSE);
        SR.setDirection(DcMotorSimple.Direction.REVERSE);




        Catch.setDirection(Servo.Direction.REVERSE);

        waitForStart();

        Catch.setPosition(0.2);
        right(0.7, 250);
        forward(0.7, 500);
        SR.setPower(0.5);
        sleep(5000);
        SR.setPower(0);
        Catch.setPosition(0.6);
        back(0.7, 300);
        
        SR.setPower(-0.5);
        sleep(5000);
        SR.setPower(0);








    }
}
