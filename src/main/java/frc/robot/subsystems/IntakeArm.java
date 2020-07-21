package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeArm extends SubsystemBase {
    private SpeedController motor1 = new VictorSP(4);
    private double speed = 0;
    
    public void setsSpeed(double speed) {
        this.speed = speed;
    }

    @Override 
    public void periodic(){
        motor1.set(speed);
    }
}