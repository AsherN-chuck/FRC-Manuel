package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommandMove;
import frc.robot.commands.DriveCommandTurn;
import frc.robot.commands.EjectCommandIntake;
import frc.robot.commands.JoystickCommandArm;
import frc.robot.commands.JoystickCommandElevator;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.IntakeWheels;

public class PlaceBoxOnMiddlePlatform extends SequentialCommandGroup {
    PlaceBoxOnMiddlePlatform(DrivetrainSubsystem drivetrain, IntakeWheels intakeMotor, ElevatorSubsystem elevator,
            IntakeArm arm) {
        addRequirements(drivetrain, intakeMotor, elevator, arm);

        addCommands(new ParallelCommandGroup(new SequentialCommandGroup(
                new DriveCommandMove(drivetrain, 0.5).withTimeout(1),
                    new DriveCommandTurn(drivetrain, 0.7).withTimeout(1.5),
                    new DriveCommandMove(drivetrain, 0.5).withTimeout(
                        0.4)
                ),
                new JoystickCommandElevator(elevator, () -> 0.25).withTimeout(0.75),
                new JoystickCommandArm(arm, () -> 0.35).withTimeout(0.15)
            ),
            new EjectCommandIntake(intakeMotor).withTimeout(1));
        }  
    }