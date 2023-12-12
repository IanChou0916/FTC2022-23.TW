package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

@Autonomous
public class Auto0210C extends DC_Auto_Run {

    private ElapsedTime runtime = new ElapsedTime();
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
        reset();
        ChassisEncoder();
        forward(0.7,750);

        //RGBServo.setPosition(0.35);
        Catch.setPosition(0.2);
        sleep(300);
        back(0.7,750);
        sleep(250);
        while (sensorDistance.getDistance(DistanceUnit.CM) > 2.4 && LF.getCurrentPosition()<1050 ) {
            LF.setPower(0.3);
            LB.setPower(-0.3);
            RF.setPower(-0.3);
            RB.setPower(0.3);
            telemetry.addData("Distance (cm)",
                    String.format(Locale.US, "%.02f", sensorDistance.getDistance(DistanceUnit.CM)));
            telemetry.update();

        }
        reset();

        int n  = (colorsensor(colorSensor.red()+15, colorSensor.green(),colorSensor.blue()));
        telemetry.addData("Red  ", colorSensor.red());
        telemetry.addData("Green", colorSensor.green());
        telemetry.addData("Blue ", colorSensor.blue());
        telemetry.update();
        sleep(200);
        //RGBServo.setPosition(0.85);
        telemetry.addData("Target" , n);
        telemetry.addData("Distance (cm)",
                String.format(Locale.US, "%.02f", sensorDistance.getDistance(DistanceUnit.CM)));

        telemetry.update();
        sleep(250);
        teleChassis();
        sleep(2000);
        right(0.3,850);
        teleChassis();
        sleep(2000);


        if (n == 1) {
            forward(0.5,1100);
        }
        else if (n == 3) {
            back(0.5,1000);
        }
        reset();

        //colorsensor的部分寫成副程式(colorsensor())
        //SampleMecanumDrive drive =new SampleMecanumDrive(hardwareMap);







    }
}
