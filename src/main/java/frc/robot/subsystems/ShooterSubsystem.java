package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Calibrations;
import frc.robot.RobotMap;

public class ShooterSubsystem extends SubsystemBase {
    private final TalonFX shooter_Front = new TalonFX(RobotMap.SHOOTER_FRONT_MOTOR);
    private final TalonFX shooter_Rear = new TalonFX(RobotMap.SHOOTER_REAR_MOTOR);

    public void spinshooter() {
        shooter_Front.set(TalonFXControlMode.PercentOutput, Calibrations.SHOOTER_FRONT_POWER);
        shooter_Rear.set(TalonFXControlMode.PercentOutput, Calibrations.SHOOTER_REAR_POWER);
    }
    public void stopshooter() {
        shooter_Front.set(TalonFXControlMode.PercentOutput, 0);
        shooter_Rear.set(TalonFXControlMode.PercentOutput, 0);
    }
}
