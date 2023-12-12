package org.firstinspires.ftc.teamcode;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous
public class Preload extends DC_Auto_Run {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        SR = hardwareMap.dcMotor.get("SR");
        HR = hardwareMap.dcMotor.get("HR");
        Catch = hardwareMap.servo.get("Catch");
        Rail();
        SR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        HR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Pose2d startPose = new Pose2d(-34.4, -62.5, Math.toRadians(90));
        drive.setPoseEstimate(startPose);
        TrajectorySequence preload = drive.trajectorySequenceBuilder(startPose)

                .lineToConstantHeading(
                        new Vector2d(-34.4, -44),
                        SampleMecanumDrive.getVelocityConstraint(15, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL)
                )
                .lineToSplineHeading(
                        new Pose2d(-30, -32,Math.toRadians(45)),
                        SampleMecanumDrive.getVelocityConstraint(15, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))
                .build();

        waitForStart();
        if(isStopRequested()) return;
        Catch.setPosition(0.73);
        sleep(550);
        encoderRail(0.5,4600);
        drive.followTrajectorySequence(preload);
        sleep(500);
        SR.setPower(0);
        HR.setPower(0);
        sleep(500);
        Catch.setPosition(0.2);
        sleep(1000);
    }
}

