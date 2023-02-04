// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

public class pigeonimu extends SubsystemBase {

  WPI_PigeonIMU pigeonGyro = new WPI_PigeonIMU(0);//TODO the actual pigeon will have to be coded inside the drivetrain subsystem as a gyro 
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}



;