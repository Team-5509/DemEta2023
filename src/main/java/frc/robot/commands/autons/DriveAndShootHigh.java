package frc.robot.commands.autons;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveXFeet;
import frc.robot.commands.RunBallFeed;
import frc.robot.commands.ShootAtPercentSpeed;
import frc.robot.subsystems.*;

public class DriveAndShootHigh extends SequentialCommandGroup {
    public DriveAndShootHigh(Drivetrain drivetrain, Shooter shooter, BallFeed ballFeed){
        addCommands(
            new DriveXFeet(-5.5, drivetrain),
            Commands.race(
                (new ShootAtPercentSpeed(0.863, shooter)).withTimeout(5),
                (new WaitCommand(2)).andThen(
                    (new RunBallFeed(0.5, ballFeed)).withTimeout(2))
                    
            )
        );
    }
    
}
