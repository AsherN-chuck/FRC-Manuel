package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private SpeedController leftMoter = new Spark(0);
    private SpeedController rightMoter = new Spark(1);

    private DifferentialDrive DrivetrainSubsystem = new DifferentialDrive(leftMoter, rightMoter);

    public void arcade(double forwardSpeed, double rotationSpeed){
        DrivetrainSubsystem.arcadeDrive(forwardSpeed, rotationSpeed);
    }
}
