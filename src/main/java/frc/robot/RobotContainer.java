// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.FrontShooter;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.backShooter;
import frc.robot.commands.Feed;
import frc.robot.commands.FrontShoot;
import frc.robot.commands.Shoot;
import frc.robot.commands.StartIntake;
import frc.robot.commands.StopFeeding;
import frc.robot.commands.StopFrontShoot;
import frc.robot.commands.StopIntake;
import frc.robot.commands.StopShooting;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Feeder m_feeder = new Feeder();
  private final backShooter m_backShooter = new backShooter();
  private final FrontShooter m_FrontShooter = new FrontShooter();
  private final Intake m_intake = new Intake();

  private final XboxController m_joystick = new XboxController(1);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    //make some buttons
    final JoystickButton A = new JoystickButton(m_joystick, 1);
    final JoystickButton B = new JoystickButton(m_joystick, 2);

    //connect buttons to commands
    /* 
    * without parallel commands:

    A.onTrue(new Feed(m_feeder));
    A.onFalse(new StopFeeding(m_feeder));

    B.onTrue(new Shoot(m_backShooter));
    B.onFalse(new StopShooting(m_backShooter));
    */

    //with parallel commands:

    A.onTrue(
      Commands.startEnd(() -> m_feeder.moveFeeder(.65), () -> m_feeder.moveFeeder(0), m_feeder).alongWith(
        Commands.startEnd(() -> m_FrontShooter.moveFrontShooter(.65), () -> m_FrontShooter.moveFrontShooter(0), m_FrontShooter)).alongWith(
          Commands.startEnd(() -> m_backShooter.moveBackShooter(.65), () -> m_backShooter.moveBackShooter(0), m_backShooter))
        );

    //A.onTrue(new Feed(m_feeder).alongWith(new Shoot(m_backShooter)).alongWith(new FrontShoot(m_FrontShooter)));
    //A.onFalse(new StopFeeding(m_feeder).alongWith(new StopShooting(m_backShooter)).alongWith(new StopFrontShoot(m_FrontShooter)));

    
    A.onFalse(
      Commands.startEnd(() -> m_feeder.stopFeeder(), () -> m_feeder.stopFeeder(), m_feeder).alongWith(
        Commands.startEnd(() -> m_FrontShooter.stopFrontShooter(), () -> m_FrontShooter.stopFrontShooter(), m_FrontShooter)).alongWith(
          Commands.startEnd(() -> m_backShooter.stopBackShooter(), () -> m_backShooter.stopBackShooter(), m_backShooter))
        );

    B.onTrue(Commands.startEnd(() -> m_intake.moveIntake(.5), () ->  m_intake.stopIntake(), m_intake) );
    B.onFalse(Commands.startEnd(() -> m_intake.stopIntake(), () -> m_intake.stopIntake(), m_intake));

    /* 
    B.onTrue(new StartIntake(m_intake));
    B.onFalse(new StopIntake(m_intake));
    */
    
   
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
