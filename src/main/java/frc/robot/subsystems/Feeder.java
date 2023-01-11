// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;

public class Feeder extends SubsystemBase {

  VictorSPX feederBack;
  VictorSPX feederFront;

  /** Creates a new Feeder. */
  public Feeder() {
    feederBack = new VictorSPX(6);
    feederFront = new VictorSPX(5);

    feederBack.setInverted(true);
    feederFront.setInverted(false);
    feederFront.setNeutralMode(NeutralMode.Brake);
    feederBack.setNeutralMode(NeutralMode.Brake);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void moveFeeder(double speed){
    feederBack.set(VictorSPXControlMode.PercentOutput, speed);
    feederFront.set(VictorSPXControlMode.PercentOutput, speed);

  }

  public void stopFeeder(){
    feederBack.set(VictorSPXControlMode.PercentOutput, 0);
    feederFront.set(VictorSPXControlMode.PercentOutput, 0);

  }

}
