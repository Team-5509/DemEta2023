// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
//This comment is to test is Sourcetree is working
// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drivetrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    private final static double TICKSPERFOOT= 532;
    private final static double FEETPERTICK= 1/TICKSPERFOOT;
    private CANSparkMax frontLeftMotor;
    private CANSparkMax frontRightMotor;
    private CANSparkMax backLeftMotor;
    private CANSparkMax backRightMotor;
    private MecanumDrive mecanumDrive;
    private AHRS navX;

    //private AnalogInput ultrasonic;
    public Drivetrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        frontLeftMotor= new CANSparkMax(6,MotorType.kBrushless);
        frontRightMotor= new CANSparkMax(1,MotorType.kBrushless);
        backLeftMotor= new CANSparkMax(8,MotorType.kBrushless);
        backRightMotor= new CANSparkMax(13,MotorType.kBrushless);
        ResetEncoders();

        frontRightMotor.setInverted(true);
        backRightMotor.setInverted(true);
        mecanumDrive= new MecanumDrive(frontLeftMotor,backLeftMotor,frontRightMotor,backRightMotor);
        navX= new AHRS();
    }
    public void ResetEncoders() {
        frontLeftMotor.getEncoder().setPosition(0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        double ticks = frontLeftMotor.getEncoder().getPosition();
        SmartDashboard.putNumber("Drivetrain::ticks", ticks);
        double roll = navX.getRoll();
        double pitch = navX.getPitch();
        double yaw = navX.getYaw();
        SmartDashboard.putNumber("Drivetrain::roll", roll);
        SmartDashboard.putNumber("Drivetrain::pitch", pitch);
        SmartDashboard.putNumber("Drivetrain::yaw", yaw);

    

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public double distanceTraveledInFeet () {
        return frontLeftMotor.getEncoder().getPosition()*FEETPERTICK*-1;
    }

    public double getDistanceTraveledInFeet(){
        return frontLeftMotor.getEncoder().getPosition() / 3.0;
    }
    // Y is forwards, x is strafe
    public void drive(double x,double y,double rotation){
        mecanumDrive.driveCartesian(y, x, rotation);
    }
    public void stop(){
        drive(0,0,0);
    }

}

