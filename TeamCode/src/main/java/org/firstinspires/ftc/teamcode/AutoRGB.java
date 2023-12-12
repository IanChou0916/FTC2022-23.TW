package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Auto.Catch;
import static org.firstinspires.ftc.teamcode.Auto.LB;
import static org.firstinspires.ftc.teamcode.Auto.LF;
import static org.firstinspires.ftc.teamcode.Auto.Launch;
import static org.firstinspires.ftc.teamcode.Auto.RB;
import static org.firstinspires.ftc.teamcode.Auto.RF;
import static org.firstinspires.ftc.teamcode.Auto.RGBServo;
import static org.firstinspires.ftc.teamcode.Auto.SR;

//import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.SampleRevBlinkinLedDriver;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
//import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
//import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

import java.util.Locale;

@Autonomous
public class AutoRGB extends DC_Auto_Run {

    @Override
    public void runOpMode() {
        LF = hardwareMap.dcMotor.get("LF");
        RF = hardwareMap.dcMotor.get("RF");
        LB = hardwareMap.dcMotor.get("LB");
        RB = hardwareMap.dcMotor.get("RB");
        SR = hardwareMap.dcMotor.get("SR");
        Catch = hardwareMap.servo.get("Catch");
        RGBServo = hardwareMap.servo.get("RGBServo");
        ColorSensor colorSensor;
        DistanceSensor sensorDistance;
        colorSensor = hardwareMap.get(ColorSensor.class, "color");
        sensorDistance = hardwareMap.get(DistanceSensor.class, "color");
        boolean bLedOn = true;
        colorSensor.enableLed(bLedOn);

        initialization();
        waitForStart();
        RGBServo.setPosition(0.85);
        sleep(1000);
        RGBServo.setPosition(0.35);
        sleep(1000);

        while (sensorDistance.getDistance(DistanceUnit.CM) > 2.45) {
            LF.setPower(0.3);
            LB.setPower(0.3);
            RF.setPower(0.3);
            RB.setPower(0.3);
            telemetry.addData("Distance (cm)",
                    String.format(Locale.US, "%.02f", sensorDistance.getDistance(DistanceUnit.CM)));
            telemetry.update();
        }
        reset();

        int n  = (colorsensor(colorSensor.red(), colorSensor.green(),colorSensor.blue()));

        sleep(500);
        RGBServo.setPosition(0.85);
        telemetry.addData("Target:" , n);
        telemetry.addData("Distance (cm)",
                String.format(Locale.US, "%.02f", sensorDistance.getDistance(DistanceUnit.CM)));
        telemetry.addData("Red  ", colorSensor.red());
        telemetry.addData("Green", colorSensor.green());
        telemetry.addData("Blue ", colorSensor.blue());
        telemetry.update();
        sleep(1500);
        stop();




        //colorsensor的部分寫成副程式(colorsensor())
        //SampleMecanumDrive drive =new SampleMecanumDrive(hardwareMap);







    }
}
