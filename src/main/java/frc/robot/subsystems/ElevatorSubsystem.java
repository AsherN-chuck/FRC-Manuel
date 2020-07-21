package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase{
    private SpeedController ElevatorMoter = new VictorSP(2);
    private double speed = 0;
    
    public void setSpeed(double speed){
        this.speed = speed;
        
    }

    @Override
    public void periodic(){
        ElevatorMoter.set(speed);

        speed = 0;
    }
     
}