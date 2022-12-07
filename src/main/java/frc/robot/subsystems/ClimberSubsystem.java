package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {
    private CANSparkMax climberMotor1;
    private CANSparkMax climberMotor2;

    public ClimberSubsystem() {
        climberMotor1 = new CANSparkMax(Constants.CLIMBER1_PORT, MotorType.kBrushless);
        climberMotor2 = new CANSparkMax(Constants.CLIMBER2_PORT, MotorType.kBrushless);

        climberMotor1.setIdleMode(IdleMode.kBrake);
        climberMotor1.setSmartCurrentLimit(Constants.CLIMBER_CURRENT_LIMIT);

        climberMotor2.setIdleMode(IdleMode.kBrake);
        climberMotor2.setSmartCurrentLimit(Constants.CLIMBER_CURRENT_LIMIT);
    }

    public void raise() {
        climberMotor1.set(Constants.CLIMBER_POWER);
        climberMotor2.set(Constants.CLIMBER_POWER);
    }

    public void lower() {
        climberMotor1.set(-Constants.CLIMBER_POWER);
        climberMotor2.set(-Constants.CLIMBER_POWER);
    }

    // Create a method that stops the climbers from moving
    public void stop() {
        climberMotor1.set(0);
        climberMotor2.set(0);
    }

}
