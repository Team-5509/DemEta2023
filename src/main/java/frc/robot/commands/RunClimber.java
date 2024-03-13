// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.Climber;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class RunClimber extends Command {

    private final double UPSPEED = 0.8;
    private final double DOWNSPEED = -0.7;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final Climber m_climber;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public RunClimber(Climber subsystem) {


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_climber = subsystem;
        addRequirements(m_climber);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        /*
        Joystick j = RobotContainer.getInstance().getClimberJoystick();
        double leftSpeed = 0;
        double rightSpeed = 0;

        //j.getRawAxis(5);
        //value of an axis from -1 to 1
        //j.getRawButton(10);
        //returns wether abutton is pressed or not

        if(j.getRawAxis(1) < -0.5){
            leftSpeed = UPSPEED;
        }
        else if(j.getRawAxis(1) > 0.5){
            leftSpeed = DOWNSPEED;
        }
        /*
        if(j.getRawAxis(9) < -0.5){
            leftSpeed = UPSPEED;
        }
        else if(j.getRawAxis(9) > 0.5){
            leftSpeed = DOWNSPEED;
        }
        */
        //when you're more than past half way pushing either way 

// stick up all the way is -1
// stick down all the way is 1

        /*if(j.getRawAxis(5)< -0.5){
            rightSpeed = UPSPEED;
        }
        else if(j.getRawAxis(5) > 0.5){
            rightSpeed = DOWNSPEED;
        }*/
        /*
         if(j.getRawAxis(10)< -0.5){
            rightSpeed = UPSPEED;
        }
        else if(j.getRawAxis(10) > 0.5){
            rightSpeed = DOWNSPEED;
        }*/
        /*
        //when you're more than past half way up or down on the right stick

        m_climber.run(leftSpeed, rightSpeed);*/
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_climber.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
