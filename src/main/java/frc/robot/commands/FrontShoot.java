// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//NOTE: THE MOTOR FOR THIS IS BROKEN 
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FrontShooter;

public class FrontShoot extends CommandBase {
  private final FrontShooter m_FrontShooter;
  /** Creates a new FrontShoot. */
  public FrontShoot(FrontShooter frontShooter) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_FrontShooter = frontShooter;
    addRequirements(m_FrontShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_FrontShooter.moveFrontShooter(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
