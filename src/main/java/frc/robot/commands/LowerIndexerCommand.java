package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexerSubsystem;

public class LowerIndexerCommand extends CommandBase {
    public final IndexerSubsystem indexerSubsystem;

    public LowerIndexerCommand(IndexerSubsystem indexerSubsystem) {
        this.indexerSubsystem = indexerSubsystem;

        addRequirements(indexerSubsystem);
    }

    @Override
    public void initialize() {
        indexerSubsystem.retract();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
