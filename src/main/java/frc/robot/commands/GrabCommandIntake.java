package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.IntakeWheels;

public class GrabCommandIntake extends CommandBase{
    public GrabCommandIntake(IntakeWheels intakeMotor) {
        addRequirements(intakeMotor);
        addCommands(
            new RunCommand(
                () -> {
                intakeMotor.Grab();
                }
            ).withTimeout(0.2)
        );      
    }

    private void addCommands(ParallelRaceGroup withTimeout) {
    }    
}