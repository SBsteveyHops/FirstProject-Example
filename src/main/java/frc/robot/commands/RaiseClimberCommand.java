package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;

public class RaiseClimberCommand extends CommandBase {
    private final ClimberSubsystem climberSubsystem;

    public RaiseClimberCommand(ClimberSubsystem climberSubsystem) {
        this.climberSubsystem = climberSubsystem;

        addRequirements(climberSubsystem);
    }

    @Override
    public void initialize() {
        climberSubsystem.raise();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        climberSubsystem.stop();
    }
}
