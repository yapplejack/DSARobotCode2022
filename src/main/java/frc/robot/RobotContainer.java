// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ShooterFireCommand;
//import frc.robot.commands.ShooterFireForDurationCommand;
import frc.robot.commands.ShooterStopCommand;
import frc.robot.commands.DrivetrainHumanControlCommand;
import frc.robot.commands.IntakeCollectCommand;
import frc.robot.commands.IntakeEjectCommand;
import frc.robot.commands.IntakeStopCommand;
import frc.robot.commands.autonomous.AutonomousTaxi;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem _drivetrain = new DrivetrainSubsystem();
  private final ShooterSubsystem _shooter = new ShooterSubsystem();
  private final IntakeSubsystem _intake = new IntakeSubsystem();
  private final Joystick _joystick = new Joystick(RobotMap.JOYSTICK_CHANNEL);

  private final DrivetrainHumanControlCommand _drivetrainHumanControlCommand = new DrivetrainHumanControlCommand(_drivetrain, _joystick);
  
  private final ShooterFireCommand _shooterFireCommand = new ShooterFireCommand(_shooter);
  //private final ShooterFireForDurationCommand _shooterFireForDuration = new ShooterFireForDurationCommand(_shooter, duration);
  private final ShooterStopCommand _shooterStopCommand = new ShooterStopCommand(_shooter);

  private final IntakeCollectCommand _intakeCollectCommand = new IntakeCollectCommand(_intake);
  private final IntakeEjectCommand _intakeEjectCommand = new IntakeEjectCommand(_intake);
  private final IntakeStopCommand _intakeStopCommand  = new IntakeStopCommand(_intake);

  private final AutonomousTaxi _autonomousTaxi = new AutonomousTaxi(_drivetrain);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    _drivetrain.setDefaultCommand(_drivetrainHumanControlCommand);
    _shooter.setDefaultCommand(_shooterStopCommand);
    _intake.setDefaultCommand(_intakeStopCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(_joystick, RobotMap.SHOOT_BALL_BUTTON).whileHeld(_shooterFireCommand);
    new JoystickButton(_joystick, RobotMap.INTAKE_BALL_BUTTON).whileHeld(_intakeCollectCommand);
    new JoystickButton(_joystick, RobotMap.EXJEST_BALL_BUTTON).whileHeld(_intakeEjectCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    Command autonomousCommand =  _autonomousTaxi;
    
    return autonomousCommand;
  }
}
