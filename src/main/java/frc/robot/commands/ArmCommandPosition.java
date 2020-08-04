package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class ArmCommandPosition extends CommandBase {
    private IntakeArm arm;
    private double targetPosition;
    private PIDController pidController = new PIDController(0.0001, 0, 0);
    private TrapezoidProfile profile;
    private double startTime;
    private double power;

    public ArmCommandPosition(IntakeArm arm, double targetPosition) {
        addRequirements(arm);
        this.arm = arm;
        this.targetPosition = targetPosition;
    }

    @Override
    public void initialize() {
        profile = new TrapezoidProfile(
            new TrapezoidProfile.Constraints(5, 10),
            new TrapezoidProfile.State(targetPosition, 0),
            new TrapezoidProfile.State(arm.getPosition(), arm.getVelocity())
        );
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public boolean isFinished() {
        double currentTime = Timer.getFPGATimestamp() - startTime;
        return Math.abs(arm.getPosition() - targetPosition) < 0.5 && currentTime > profile.totalTime();
    }

    @Override
    public void execute() {
        power = pidController.calculate(arm.getPosition(), targetPosition);
        TrapezoidProfile.State scheduledState = profile.calculate(Timer.getFPGATimestamp() - startTime);

        power =
            0.5 * scheduledState.velocity +
            pidController.calculate(arm.getPosition(), scheduledState.position);

        arm.setSpeed(power);
    }
}