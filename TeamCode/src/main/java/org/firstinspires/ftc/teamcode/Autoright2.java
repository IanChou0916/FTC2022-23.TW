package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Auto.Catch;
import static org.firstinspires.ftc.teamcode.Auto.LB;
import static org.firstinspires.ftc.teamcode.Auto.LF;
import static org.firstinspires.ftc.teamcode.Auto.Launch;
import static org.firstinspires.ftc.teamcode.Auto.RB;
import static org.firstinspires.ftc.teamcode.Auto.RF;
import static org.firstinspires.ftc.teamcode.Auto.SR;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class Autoright2 extends DC_Auto_Run {
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

        Launch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        Catch.setDirection(Servo.Direction.REVERSE);

        initialization();
        waitForStart();
        newright();
        right(0.7,650);





    }
}
