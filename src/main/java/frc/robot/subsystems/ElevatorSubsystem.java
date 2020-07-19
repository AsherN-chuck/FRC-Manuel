package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

public class ElevatorSubsystem {
    private SpeedController ElevatorMoter = new Spark(4);
    double speed = 0;
    
    public void Up(){
        ElevatorMoter.set(0.5);
    }
    public void Down(){
        ElevatorMoter.set(-0.5);
    }
     
}