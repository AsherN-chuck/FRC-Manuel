package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveTrainCommandRotate extends CommandBase {
    private DrivetrainSubsystem drivetrain;
    private double targetPosition;
    private PIDController pidController = new PIDController(0.0001, 0, 0);
    private TrapezoidProfile profile;
    private double startTime; 

    public DriveTrainCommandRotate(DrivetrainSubsystem drivetrain, double targetPosition) {
        addRequirements(drivetrain);
        this.drivetrain = drivetrain;
        this.targetPosition = targetPosition;
    }

    @Override
    public void initialize() {
        profile = new TrapezoidProfile(
            new TrapezoidProfile.Constraints(5, 10),
            new TrapezoidProfile.State(targetPosition, 0),
            new TrapezoidProfile.State(drivetrain.getAngle(), drivetrain.getVelocity())
        );
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public boolean isFinished() {
        double currentTime = Timer.getFPGATimestamp() - startTime;
        return Math.abs(drivetrain.getAngle() - targetPosition) < 0.5 && currentTime > profile.totalTime();
    }

    @Override
    public void execute() {
        TrapezoidProfile.State scheduledState = profile.calculate(Timer.getFPGATimestamp() - startTime);

        double power =
            0.5 * scheduledState.velocity +
            pidController.calculate(drivetrain.getAngle(), scheduledState.position);

        drivetrain.setSpeed(power);
    }
}