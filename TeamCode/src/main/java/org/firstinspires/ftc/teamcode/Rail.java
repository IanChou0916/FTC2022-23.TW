package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.teamcode.Auto.SR;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public abstract class Rail extends OpMode {
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
    public static int height (double n) {
        int h = 0;
        if (n==1) {
            h=50;
        }
        else if (n == 2) {
            h=100;
        }
        else if (n==3){
            h=200;
        }
        return (h);
    }




}
