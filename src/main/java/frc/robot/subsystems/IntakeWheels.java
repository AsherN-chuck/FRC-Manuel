package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeWheels extends SubsystemBase{
    private final SpeedController intakeMotor = new VictorSP(3);
    public void Grab() {
        intakeMotor.set(0.5);
    }
    public void Release(){
        intakeMotor.set(-0.5);
    }
    public void stop() {
        intakeMotor.set(0);
    }
}
