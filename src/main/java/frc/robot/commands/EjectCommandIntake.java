package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.IntakeWheels;

public class EjectCommandIntake extends SequentialCommandGroup {
    public EjectCommandIntake(IntakeWheels intakeMotor) {
        addRequirements(intakeMotor);
        addCommands(
            new RunCommand(
                () -> {
                intakeMotor.release();
                }
            ).withTimeout(0.2)
        );      
    }
}