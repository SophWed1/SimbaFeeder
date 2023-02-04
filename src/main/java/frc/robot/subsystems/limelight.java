// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class limelight extends SubsystemBase{

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    double[] dable = NetworkTableInstance.getDefault().getTable("limelight").getEntry("botpose").getDoubleArray(new double[6]);


    public static double x = 0;
    public static double y = 0;
    public static double area = 0;

    public static double[] botpose = {0,0,0};

    public static double botpose_wpiblue = 0;
    public static double botpose_wpired = 0;
    public static double camerapose_targetspace	= 0;
    public static double targetpose_cameraspace = 0;
    public static double targetpose_robotspace = 0;
    public static double botpose_targetspace = 0;
    public static double id = 0;

    // public DoubleArraySubscriber camtransub;
    // public DoubleArraySubscriber posesub;
    
    // public Translation3d tran3d;
    // public Rotation3d r3d;
    // public Pose3d p3d;
    

    double targetPipeline;
    private static double[] targetPose = {3.95, -1.39, 0};


    public limelight(){

        // m_tableName = "limelight";
        // m_table = NetworkTableInstance.getDefault().getTable(m_tableName);
        // posesub = m_table.getDoubleArrayTopic("botpose").subscribe(new double[] {});
    }


    @Override
    public void periodic(){
        x = table.getEntry("tx").getDouble(0.0);
        y = table.getEntry("ty").getDouble(0.0);
        area = table.getEntry("ta").getDouble(0.0);
        botpose = table.getEntry("botpose").getDoubleArray(botpose);
        botpose_wpiblue = table.getEntry("botpose_wpiblue").getDouble(0.0);
        botpose_wpired = table.getEntry("botpose_wpired").getDouble(0.0);
        camerapose_targetspace = table.getEntry("camerapose_targetspace").getDouble(0.0);
        targetpose_cameraspace = table.getEntry("targetpose_cameraspace").getDouble(0.0);
        targetpose_robotspace = table.getEntry("targetpose_robotspace").getDouble(0.0);
        botpose_targetspace = table.getEntry("botpose_targetspace").getDouble(0.0);
        id = table.getEntry("tid").getDouble(0.0);

        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
        SmartDashboard.putNumber("Target Pipeline", targetPipeline);
        //SmartDashboard.putNumberArray("botpose", botpose);
        SmartDashboard.putNumber("botposeX", botpose[0]);
        SmartDashboard.putNumber("botposeY", botpose[1]);
        SmartDashboard.putNumber("botposeZ", botpose[2]);
        SmartDashboard.putNumber("botpose_wpiblue", botpose_wpiblue);
        SmartDashboard.putNumber("botpose_wpired", botpose_wpired);
        SmartDashboard.putNumber("camerapose_targetspace", camerapose_targetspace);
        SmartDashboard.putNumber("targetpose_cameraspace", targetpose_cameraspace);
        SmartDashboard.putNumber("targetpose_robotspace", targetpose_robotspace);
        SmartDashboard.putNumber("tid", id);


    }

    public void setPipeline(int targetPipeline){
        if (!(targetPipeline<10 && targetPipeline>-1)){
            return;
        }
        table.getEntry("pipeline").setNumber(targetPipeline);
        this.targetPipeline = targetPipeline;

    }

    public void increasePipeline(){
        if (!(targetPipeline<10 && targetPipeline>-1)){
            return;
        }
        table.getEntry("pipeline").setNumber(targetPipeline++);

    }
    
    public void decreasePipeline(){
        if (!(targetPipeline<10 && targetPipeline>-1)){
            return;
        }
        table.getEntry("pipeline").setNumber(targetPipeline--);

    }

    public void driverCamera(){
        table.getEntry("camMode").setNumber(1);

    }

    public void visionProcesser(){
        table.getEntry("camMode").setNumber(0);
    }
    
    /* 

    public void adjustInterrupted(){
        if (!(targetPipeline<10 && targetPipeline>-1)){
            return;
        }
        table.getEntry("pipeline").setNumber(targetPipeline);
    }
    */

}