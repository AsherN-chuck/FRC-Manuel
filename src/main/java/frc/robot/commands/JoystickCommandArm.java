package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class JoystickCommandArm extends CommandBase{
    private IntakeArm arm;
    private DoubleSupplier speed;

    public JoystickCommandArm(IntakeArm arm, DoubleSupplier speed){
        this.speed = speed;
        this. arm = arm;

        addRequirements(arm);
    }

    @Override
    public void execute(){
        arm.setsSpeed(speed.getAsDouble());
    }
}