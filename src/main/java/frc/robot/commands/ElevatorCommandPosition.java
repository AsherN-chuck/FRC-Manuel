package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorCommandPosition extends CommandBase {
    private ElevatorSubsystem elevator;
    private double targetPosition;
    private PIDController pidController = new PIDController(0.0001, 0, 0);
    private TrapezoidProfile profile;
    private double startTime;
    private double power; 

    public ElevatorCommandPosition(ElevatorSubsystem elevator, double targetPosition) {
        addRequirements(elevator);
        this.elevator = elevator;
        this.targetPosition = targetPosition;
    }

    @Override
    public void initialize() {
        profile = new TrapezoidProfile(
            new TrapezoidProfile.Constraints(5, 10),
            new TrapezoidProfile.State(targetPosition, 0),
            new TrapezoidProfile.State(elevator.getPosition(), elevator.getVelocity())
        );
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public boolean isFinished() {
        double currentTime = Timer.getFPGATimestamp() - startTime;
        return Math.abs(elevator.getPosition() - targetPosition) < 0.5 && currentTime > profile.totalTime();
    }

    @Override
    public void execute() {
        power = pidController.calculate(elevator.getPosition(), targetPosition);
        TrapezoidProfile.State scheduledState = profile.calculate(Timer.getFPGATimestamp() - startTime);

        power =
            0.5 * scheduledState.velocity +
            pidController.calculate(elevator.getPosition(), scheduledState.position);

        elevator.setSpeed(power);
    }
}