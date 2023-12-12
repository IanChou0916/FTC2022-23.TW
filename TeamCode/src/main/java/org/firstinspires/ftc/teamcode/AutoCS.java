package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

@Autonomous
public class AutoCS extends DC_Auto_Run {

    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        LF = hardwareMap.dcMotor.get("LF");
        RF = hardwareMap.dcMotor.get("RF");
        LB = hardwareMap.dcMotor.get("LB");
        RB = hardwareMap.dcMotor.get("RB");
        SR = hardwareMap.dcMotor.get("SR");
        Catch = hardwareMap.servo.get("Catch");
        //RGBServo = hardwareMap.servo.get("RGBServo");
        ColorSensor colorSensor;
        DistanceSensor sensorDistance;
        colorSensor = hardwareMap.get(ColorSensor.class, "color");
        sensorDistance = hardwareMap.get(DistanceSensor.class, "color");
        boolean bLedOn = true;
        colorSensor.enableLed(bLedOn);

        initialization();

        waitForStart();
        reset();
        right(0.7,2500);
        forward(0.3,500);
        sleep(20000);
        left(0.7,1000);

        reset();

        //colorsensor的部分寫成副程式(colorsensor())
        //SampleMecanumDrive drive =new SampleMecanumDrive(hardwareMap);







    }
}
