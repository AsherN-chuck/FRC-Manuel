package frc.robot.subsystems;

import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private SpeedController leftMoter = new Spark(0);
    private SpeedController rightMoter = new Spark(1);
    private double speed;
    private DifferentialDrive DrivetrainSubsystem = new DifferentialDrive(leftMoter, rightMoter);
    private CANCoder encoder = new CANCoder(2); 

    public void arcade(double forwardSpeed, double rotationSpeed){
        DrivetrainSubsystem.arcadeDrive(forwardSpeed, rotationSpeed);
    }

	public void setSpeed(double speed){
        this.speed = speed;
        
    }

	public double getVelocity(){
        return encoder.getVelocity();
    }

    @Override
    public void periodic(){
        leftMoter.set(speed);
        rightMoter.set(speed);
        speed = 0;
    }
}
