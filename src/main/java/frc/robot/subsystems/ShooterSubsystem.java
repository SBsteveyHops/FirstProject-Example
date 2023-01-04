package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
    // Two motors, set them to the same speed,
    // they're on ports 6 and 7
    private CANSparkMax bottomMotor, topMotor;

    public ShooterSubsystem() {
        bottomMotor = new CANSparkMax(Constants.BOTTOM_SHOOTER_PORT, MotorType.kBrushless);
        topMotor = new CANSparkMax(Constants.TOP_SHOOTER_PORT, MotorType.kBrushless);
        bottomMotor.setIdleMode(IdleMode.kCoast);
        topMotor.setIdleMode(IdleMode.kCoast);
        topMotor.setInverted(true);
        bottomMotor.setInverted(true);
    }

    public void shoot(double power) {
        topMotor.set(power);
        bottomMotor.set(power);
    }

    public void stop() {
        topMotor.set(0);
        bottomMotor.set(0);
    }
}
