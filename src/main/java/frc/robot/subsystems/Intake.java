// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  TalonFX Intake;
  /** Creates a new Intake. */
  public Intake() {

    Intake = new TalonFX(55);
    Intake.setInverted(false);
    Intake.setNeutralMode(NeutralMode.Brake);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void moveIntake(double speed){
    Intake.set(TalonFXControlMode.PercentOutput, speed);
  }

  public void stopIntake(){
    Intake.set(TalonFXControlMode.PercentOutput, 0);
  }

}
