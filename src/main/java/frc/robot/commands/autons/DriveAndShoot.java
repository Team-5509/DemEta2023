package frc.robot.commands.autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveXFeet;
import frc.robot.commands.RunBallFeed;
import frc.robot.commands.ShootAtPercentSpeed;
import frc.robot.subsystems.*;

public class DriveAndShoot extends SequentialCommandGroup {
    public DriveAndShoot(Drivetrain drivetrain, Shooter shooter, BallFeed ballFeed){
        addCommands(
            new DriveXFeet(-6, drivetrain),
            race(
                (new ShootAtPercentSpeed(1, shooter)).withTimeout(5),
                (new WaitCommand(2)).andThen(
                    (new RunBallFeed(1, ballFeed)).withTimeout(2))
            )
        );
    }
    
}
