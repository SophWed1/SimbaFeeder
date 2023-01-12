// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.backShooter;

public class Shoot extends CommandBase {
  private final backShooter BackShooter;

  /** Creates a new Shoot. */
  public Shoot(backShooter shooter) {
    // Use addRequirements() here to declare subsystem dependencies.

    BackShooter = shooter;
    addRequirements(BackShooter); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    BackShooter.moveBackShooter(0.65);

  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    //BackShooter.stopBackShooter();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
