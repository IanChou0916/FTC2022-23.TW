package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


public abstract class DC_Auto_Run extends LinearOpMode {
    public static DcMotor LF,LB,RF,RB,SR,HR;
    public static Servo Catch;

    public double forward(double f, int ms) {
        LF.setPower(f);
        LB.setPower(f);
        RF.setPower(f);
        RB.setPower(f);
        sleep(ms);
        reset();

        return 0;
    }

    public double back(double f, int ms) {
        LF.setPower(-f);
        LB.setPower(-f);
        RF.setPower(-f);
        RB.setPower(-f);
        sleep(ms);
        reset();

        return 0;
    }

    public double left(double power, int ms) {
        LF.setPower(-power);
        LB.setPower(power);
        RF.setPower(power);
        RB.setPower(-power);
        sleep(ms);
        reset();

        return 0;
    }

    public double right(double power, int ms) {
        LF.setPower(power);
        LB.setPower(-power);
        RF.setPower(-power);
        RB.setPower(power);
        sleep(ms);
        reset();

        return 0;
    }

    public double turn(double power,int ms) {
        LF.setPower(power);
        LB.setPower(power);
        RF.setPower(-power);
        RB.setPower(-power);
        sleep(ms);
        reset();
        return 0;
    }

    public static void reset() {
        LF.setPower(0);
        LB.setPower(0);
        RF.setPower(0);
        RB.setPower(0);
    }

    /*public static int height(double power)  {
        SR.setPower(0.5);

        return 0;
    }*/
    public static void initialization() {


        LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        HR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /*
        LF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         */


        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        SR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ChassisEncoder();
        LF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LF.setDirection(DcMotorSimple.Direction.REVERSE);
        LB.setDirection(DcMotorSimple.Direction.REVERSE);

        RF.setDirection(DcMotorSimple.Direction.FORWARD);
        RB.setDirection(DcMotorSimple.Direction.FORWARD);
        ChassisEncoder();

    }

    public void Rail() {

        SR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        HR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Stop all motion;

    }

    public void newleft() {
        left(0.8, 700);
        right(0.8, 700);
        forward(0.8, 550);

    }

    public void newright() {
        right(0.8, 700);
        left(0.8, 700);
        forward(0.8, 550);
    }

    public double RailPower(double power, int ms) {
        SR.setPower(power);
        sleep(ms);
        SR.setPower(0);
        return 0;
    }

    public int Autoleft(int n) {
        if (n == 1) {
            newleft();
            left(0.7, 900);
        } else if (n == 2) {
            newleft();
        } else if (n == 3) {
            newleft();
            right(0.7, 650);
        }
        return 0;
    }
    public int colorsensor(int R,int G,int B){

        int n;
        if ( B > R && B > G ) {
            n = 3;
        }
        else if (G > R && G > B ) {
            n = 2;
        }
        else {
            n = 1;
        }
        return n;
    }
    public void Encoderforward(double power, int distance){

        ChassisEncoder();
        RF.setTargetPosition(distance);
        RB.setTargetPosition(distance);
        LF.setTargetPosition(distance);
        LB.setTargetPosition(distance);


        LF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(LF.isBusy() &&LB.isBusy() &&RF.isBusy() &&RB.isBusy()) {
            LF.setPower(power);
            LB.setPower(power);
            RF.setPower(power);
            RB.setPower(power);
        }

        // Stop all motion;
        reset();
        // Turn off RUN_TO_POSITION
        ChassisEncoder();

    }
    public void Encoderright(double power, int distance){

        ChassisEncoder();
        RF.setTargetPosition(distance);
        RB.setTargetPosition(-distance);
        LF.setTargetPosition(-distance);
        LB.setTargetPosition(distance);


        LF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(LF.isBusy() &&LB.isBusy() &&RF.isBusy() &&RB.isBusy()) {
            LF.setPower(power);
            LB.setPower(-power);
            RF.setPower(-power);
            RB.setPower(power);
        }

        // Stop all motion;
        reset();
        // Turn off RUN_TO_POSITION
        ChassisEncoder();

    }

    public static void ChassisEncoder() {
        RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void teleChassis() {
        telemetry.addData("LF" , LF.getCurrentPosition());
        telemetry.addData("LB" , LB.getCurrentPosition());
        telemetry.addData("RF" , RF.getCurrentPosition());
        telemetry.addData("RB" , RB.getCurrentPosition());
        telemetry.update();
    }
    public static double maxforce (double power,double max) {
            if (power > max) {
                power = max;
            } else if (power < -max) {
                power = -max;
            } else {
                power = power * max;
            }
            return (power);
        }
    public void encoderRail(double speed, int distance) {
        /*double WHEEL_DIAMETER = 0.78;
        final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
        final double COUNTS_PER_REVOLUTION = 537.6;
        final double COUNTS_PER_INCH = COUNTS_PER_REVOLUTION / WHEEL_CIRCUMFERENCE;

        int targetPosition = (int) (distance * COUNTS_PER_INCH);
         */
        int targetPosition = distance;
        Rail();
        SR.setTargetPosition(targetPosition);
        SR.setPower(Math.abs(speed));

        HR.setTargetPosition(-targetPosition);
        HR.setPower(Math.abs(speed));

        SR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        HR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        Rail();

    }
    }
