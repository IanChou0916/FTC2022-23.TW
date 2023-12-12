package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.teamcode.Auto.LB;
import static org.firstinspires.ftc.teamcode.Auto.LF;
import static org.firstinspires.ftc.teamcode.Auto.RB;
import static org.firstinspires.ftc.teamcode.Auto.RF;
import static org.firstinspires.ftc.teamcode.Auto.SR;
import static org.firstinspires.ftc.teamcode.DC_Auto_Run.initialization;

public class tree extends OpMode {
    @Override
    public void init() {
        //DcMotor SR;
        SR = hardwareMap.dcMotor.get("SR");
    }

    @Override
    public void loop() {
        LF = hardwareMap.dcMotor.get("LF");
        RF = hardwareMap.dcMotor.get("RF");
        LB = hardwareMap.dcMotor.get("LB");
        RB = hardwareMap.dcMotor.get("RB");
        SR = hardwareMap.dcMotor.get("SR");

        //Catch = hardwareMap.servo.get("Catch");
        //colorsensor的部分寫成副程式(colorsensor())
        //SampleMecanumDrive drive =new SampleMecanumDrive(hardwareMap);

        initialization();


        telemetry.addData("Current Position:",SR.getCurrentPosition());
        telemetry.update();

    }
}
