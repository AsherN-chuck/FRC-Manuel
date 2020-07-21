package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorCommandJoystick extends CommandBase{
    private ElevatorSubsystem elevator;
        private Joystick joystick;
    private DoubleSupplier speedSupplier;

    public ElevatorCommandJoystick(ElevatorSubsystem elevator, DoubleSupplier speedSupplier){
        this.speedSupplier = speedSupplier;
        addRequirements(elevator);
        this.elevator = elevator;
    }

    @Override
    public void execute() {
        elevator.setSpeed(speedSupplier.getAsDouble());
    }
}