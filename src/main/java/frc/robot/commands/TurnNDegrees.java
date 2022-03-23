package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Drivetrain;

public class TurnNDegrees extends PIDCommand{
  private final Drivetrain drivetrain;
    public TurnNDegrees (double angleToFace, Drivetrain Drivetrain) {
        super(new PIDController(.2, 0, 0),
         Drivetrain::getHeading,
         angleToFace, 
         output->Drivetrain.drive(0,0, MathUtil.clamp(output, -.3, .3)),
         Drivetrain);
         this.drivetrain=Drivetrain;
         getController().enableContinuousInput(-180, 180);
         
        
    }
    @Override
    public void initialize (){
      drivetrain.ResetEncoders();
    }
    @Override
    public boolean isFinished() {
      // End when the controller is at the reference.
      return getController().atSetpoint();
    }
    @Override 
    public void execute(){
      super.execute();
      SmartDashboard.putNumber("TurnNDegreesSetpoint", getController().getSetpoint());
      SmartDashboard.putNumber("TurnNDegreesPositionError", getController().getPositionError());
      SmartDashboard.putNumber("TurnNDegreesCurrentHeading", m_measurement.getAsDouble());
      SmartDashboard.putNumber("TurnNDegreesDesiredHeading", m_setpoint.getAsDouble());


    }
}
