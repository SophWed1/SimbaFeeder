// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class Feed extends CommandBase {
  /** Creates a new Feed. */

  private final Feeder feeder;
  Timer m_timer = new Timer();
  

  public Feed(Feeder feeder) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.feeder = feeder;
    addRequirements(feeder);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    feeder.moveFeeder(0.65);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   
    feeder.stopFeeder();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

/*
 * public boolean isFinished() {
    if (m_feeder.sense_ball() == true){

     return false;
    } else {
      return true;
    }
  
 */