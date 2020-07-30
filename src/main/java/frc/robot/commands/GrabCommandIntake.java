package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.IntakeWheels;

public class GrabCommandIntake extends SequentialCommandGroup{
    public GrabCommandIntake(IntakeWheels intakeMotor) {
        addRequirements(intakeMotor);
        addCommands(
            new RunCommand(
                () -> {
                intakeMotor.grab();
                }
            ).withTimeout(0.2)
        );      
    }   
}