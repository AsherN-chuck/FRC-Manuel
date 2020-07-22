package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommandMove extends CommandBase {
    private DrivetrainSubsystem drivetrain;
    private double speed;

    public DriveCommandMove(DrivetrainSubsystem drivetrain, double speed) {
        this.drivetrain = drivetrain;
        this.speed = speed;
        addRequirements(drivetrain);
    }
    
    @Override
    public void execute(){
        drivetrain.arcade(speed, 0);
    }
}