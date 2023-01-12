// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//NOTE: THE MOTOR FOR THE FRONT SHOOTER IS BROKEN 
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FrontShooter extends SubsystemBase {
  TalonFX FrontShooter;
  /** Creates a new FrontShooter. */
  public FrontShooter() {

    FrontShooter = new TalonFX(8);
    FrontShooter.setInverted(false);
    FrontShooter.setNeutralMode(NeutralMode.Coast);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void moveFrontShooter(double speed){
    FrontShooter.set(TalonFXControlMode.PercentOutput, speed);
  }

  public void stopFrontShooter(){
    FrontShooter.set(TalonFXControlMode.PercentOutput, 0);
  }

}
