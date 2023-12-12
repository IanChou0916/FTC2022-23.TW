package org.firstinspires.ftc.teamcode;

public class Angle {
    private float degree;

    float getDegree(){
        return degree;
    }
    void  setDegree(float newDegree){
        if(newDegree > 180){
            if(((int)(newDegree / 180))%2 == 0);
            degree = 90;
        }
        else {
            degree = 90;
        }
    }
}


