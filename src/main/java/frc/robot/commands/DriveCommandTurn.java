package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommandTurn extends CommandBase{
    private DrivetrainSubsystem drivetrain;

    public DriveCommandTurn(DrivetrainSubsystem drivetrain, double speed){
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }
    
    @Override
    public void execute(){
        drivetrain.arcade(0, 0.5);
    }
}