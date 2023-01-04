package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexerSubsystem;

public class RaiseIndexerCommand extends CommandBase {
    public final IndexerSubsystem indexerSubsystem;

    public RaiseIndexerCommand(IndexerSubsystem indexerSubsystem) {
        this.indexerSubsystem = indexerSubsystem;

        addRequirements(indexerSubsystem);
    }

    @Override
    public void initialize() {
        indexerSubsystem.extend();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
