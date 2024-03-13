package frc.robot.commands.autons;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveXFeet;
import frc.robot.commands.RunBallFeed;
import frc.robot.commands.ShootAtPercentSpeed;
import frc.robot.subsystems.*;

public class DriveAndShootLow extends SequentialCommandGroup {
    public DriveAndShootLow(Drivetrain drivetrain, Shooter shooter, BallFeed ballFeed){
        addCommands(
            
            Commands.race(
                (new ShootAtPercentSpeed(0.456, shooter)).withTimeout(5),
                (new WaitCommand(2)).andThen(
                    (new RunBallFeed(0.5, ballFeed)).withTimeout(2))
            ),
            new DriveXFeet(-6, drivetrain)
        );
    }
    
}
