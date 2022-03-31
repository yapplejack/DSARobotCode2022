// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterFireForDurationCommand extends CommandBase {
  private ShooterSubsystem _shooter;
  private Timer _shooterFireTime = new Timer();
  private double _duration;

  /** Creates a new IntakeEjectForDurationCommand. */
  public ShooterFireForDurationCommand(ShooterSubsystem shooter, double duration) {
    _shooter = shooter;
    _duration = duration;

    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _shooterFireTime.reset();
    _shooterFireTime.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _shooter.spinshooter();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    boolean timeHasElapsed = false;

    if (_shooterFireTime.get() >= _duration) {
      timeHasElapsed = true;
    }

    return timeHasElapsed;
  }
}
