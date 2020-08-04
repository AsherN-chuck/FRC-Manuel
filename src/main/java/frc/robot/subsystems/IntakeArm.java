package frc.robot.subsystems;

import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeArm extends SubsystemBase {
    private SpeedController motor1 = new VictorSP(4);
    private double speed = 0;
    private CANCoder encoder = new CANCoder(1); 
    
    public void setSpeed(double speed){
        this.speed = speed;
    }

    public double getPosition() {
        return encoder.getAbsolutePosition();
    }

    public double getVelocity(){
        return encoder.getVelocity();
    }

    @Override 
    public void periodic(){
        motor1.set(speed);
        speed = 0;
    }
}