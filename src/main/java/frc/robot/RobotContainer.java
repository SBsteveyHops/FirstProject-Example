// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ExpelBall;
import frc.robot.commands.LowerClimberCommand;
import frc.robot.commands.RaiseClimberCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final ClimberSubsystem climber = new ClimberSubsystem();
  public final IndexerSubsystem indexer = new IndexerSubsystem();
  public final ShooterSubsystem shooter = new ShooterSubsystem();
  public final DriveSubsystem drive = new DriveSubsystem();
  public static GenericHID controller = new GenericHID(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

drive.setDefaultCommand(new RunCommand(() -> drive.updateSpeed(joystickResponse(controller.getRawAxis(0)), joystickResponse(controller.getRawAxis(1)), joystickResponse(controller.getRawAxis(3)), true), drive));

    new JoystickButton(controller, 12)
            .whenHeld(new RaiseClimberCommand(climber), true);
    // Create a new trigger at button 4 for the Lower Command
    new JoystickButton(controller, 4)
            .whenHeld(new LowerClimberCommand(climber), true);
     
            // Raise the climber
    new JoystickButton(controller, 5)
    .whenHeld(new StartEndCommand(climber::raise, climber::stop, climber));

    // Create a new inline command for lowering the climber

    new JoystickButton(controller, 6)
    .whenHeld(new StartEndCommand(climber::lower, climber::stop, climber));

    new JoystickButton(controller, 10)
    .whenPressed(new ExpelBall(shooter, indexer));
    new JoystickButton(controller, 9)
    .whenHeld(new StartEndCommand(indexer::extend, indexer::retract, indexer));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  private double joystickResponse(double raw) {
        double deadband = Constants.DEADBAND;
        double deadbanded = 0.0;
        if (raw > deadband) {
                deadbanded = (raw - deadband) / (1 - deadband);
        } else if (raw < -deadband) {
                deadbanded = (raw + deadband) / (1 - deadbanded);
        }
        return Math.pow(Math.abs(deadbanded), Constants.EXPONENT) * Math.signum(deadbanded);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
