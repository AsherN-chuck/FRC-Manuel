package frc.robot.commands;


import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;


public class DriveCommandJoystick extends CommandBase {
    private DrivetrainSubsystem drivetrain;
    private DoubleSupplier rotationSpeed; 
    private DoubleSupplier forwardSpeed;

    public DriveCommandJoystick(DrivetrainSubsystem drivetrain, DoubleSupplier rotationSpeed, DoubleSupplier forwardSpeed) {
        this.rotationSpeed = rotationSpeed;
        this.forwardSpeed = forwardSpeed;
        this.drivetrain = drivetrain;

        addRequirements(drivetrain);
    }

    @Override
    public void execute(){
        drivetrain.arcade(forwardSpeed.getAsDouble(), rotationSpeed.getAsDouble());
    }
}