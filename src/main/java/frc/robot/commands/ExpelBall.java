package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ExpelBall extends SequentialCommandGroup {
    private final ShooterSubsystem shooter;
    private final IndexerSubsystem indexer;

    public ExpelBall(ShooterSubsystem shooter, IndexerSubsystem indexer) {
        this.shooter = shooter;
        this.indexer = indexer;
        addCommands(
            new InstantCommand(() -> shooter.shoot(0.5), shooter),
            new WaitCommand(0.1),
            // add indexer commands
            new RaiseIndexerCommand(indexer),
            new WaitCommand(0.3),
            new LowerIndexerCommand(indexer),
            new InstantCommand(() -> shooter.shoot(0.0), shooter)
        );
    }
}
