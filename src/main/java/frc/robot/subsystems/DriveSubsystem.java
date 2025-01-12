package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
    private boolean inverted;
    private CANSparkMax frontLeftMotor;
    private CANSparkMax backLeftMotor;
    private CANSparkMax frontRightMotor;
    private CANSparkMax backRightMotor;

    private final MecanumDriveKinematics kinematics;

    public DriveSubsystem() {
        frontLeftMotor = new CANSparkMax(Constants.WHEEL_PORT_FRONT_LEFT, MotorType.kBrushless);
        backLeftMotor = new CANSparkMax(Constants.WHEEL_PORT_REAR_LEFT, MotorType.kBrushless);
        backRightMotor = new CANSparkMax(Constants.WHEEL_PORT_REAR_RIGHT, MotorType.kBrushless);
        backLeftMotor = new CANSparkMax(Constants.WHEEL_PORT_REAR_LEFT, MotorType.kBrushless);

        frontLeftMotor.setInverted(true);
        frontRightMotor.setInverted(false);
        backLeftMotor.setInverted(true);
        backRightMotor.setInverted(false);
        inverted = false;

        frontLeftMotor.setIdleMode(IdleMode.kBrake);
        frontRightMotor.setIdleMode(IdleMode.kBrake);
        backLeftMotor.setIdleMode(IdleMode.kBrake);
        backRightMotor.setIdleMode(IdleMode.kBrake);

        kinematics = new MecanumDriveKinematics(
            new Translation2d(0.28575, 0.2267), 
            new Translation2d(0.28575, -0.2267), 
            new Translation2d(-0.28575, 0.2267), 
            new Translation2d(-0.28575, -0.2267));
    }

    public void invertDrive() {
        inverted = !inverted;
    }

    @Override
    public void periodic() {
        super.periodic();

        SmartDashboard.putBoolean("isInverted", inverted);
    }

    public void updateSpeed(double strafe, double drive, double turn, boolean useInverted) {
        double xSpeed = drive * Constants.MOVEMENT_SPEED;
        double ySpeed = strafe * Constants.MOVEMENT_SPEED;

        if (useInverted && inverted) {
            xSpeed = -xSpeed;
            ySpeed = -ySpeed;
        }

        ChassisSpeeds chassisSpeeds = new ChassisSpeeds(xSpeed, ySpeed, turn * -Constants.TURN_SPEED);
        MecanumDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(chassisSpeeds);

        frontLeftMotor.set(wheelSpeeds.frontLeftMetersPerSecond * Constants.DRIVE_SPEED_MULTI / Constants.MOVEMENT_SPEED);
        frontRightMotor.set(wheelSpeeds.frontRightMetersPerSecond * Constants.DRIVE_SPEED_MULTI / Constants.MOVEMENT_SPEED);
        backLeftMotor.set(wheelSpeeds.rearLeftMetersPerSecond * Constants.DRIVE_SPEED_MULTI / Constants.MOVEMENT_SPEED);
        backRightMotor.set(wheelSpeeds.rearLeftMetersPerSecond * Constants.DRIVE_SPEED_MULTI / Constants.MOVEMENT_SPEED);

    }

    public void stop() {
        updateSpeed(0, 0, 0, false);
    }
}
