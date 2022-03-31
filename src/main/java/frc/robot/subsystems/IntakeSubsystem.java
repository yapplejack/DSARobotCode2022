// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Calibrations;
import frc.robot.RobotMap;

public class IntakeSubsystem extends SubsystemBase {
  private final Spark intakeLowerMotor = new Spark(RobotMap.INTAKE_LOWER_MOTOR);
  private final Spark intakeUpperMotor = new Spark(RobotMap.INTAKE_UPPER_MOTOR);
  
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void collect() {
    intakeLowerMotor.set(Calibrations.INTAKE_COLLECT_POWER);
    intakeUpperMotor.set(Calibrations.INTAKE_COLLECT_POWER);
  }

  public void eject() {
    intakeLowerMotor.set(Calibrations.INTAKE_EJECT_POWER);
    intakeUpperMotor.set(Calibrations.INTAKE_EJECT_POWER);

  }

  public void stop() {
    intakeLowerMotor.set(0);
    intakeUpperMotor.set(0);
  }
}
