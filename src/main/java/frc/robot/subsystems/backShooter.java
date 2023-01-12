// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class backShooter extends SubsystemBase {
  TalonFX BackShooter;
  public backShooter() {

    BackShooter = new TalonFX(7);
    BackShooter.setInverted(true);
    BackShooter.setNeutralMode(NeutralMode.Coast);

  }

  @Override
  public void periodic() {
    //This method will be called once per scheduler run
  }

  public void moveBackShooter(double speed){
    BackShooter.set(TalonFXControlMode.PercentOutput, speed);
  }  


  public void stopBackShooter(){
    BackShooter.set(TalonFXControlMode.PercentOutput, 0.0);

  }

}
