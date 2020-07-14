package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakePistons extends SubsystemBase {
    private DoubleSolenoid piston1 = new DoubleSolenoid(0, 1);

    public void extend() {
        piston1.set(Value.kForward);
    }
    public void retracketed(){
        piston1.set(Value.kForward);
    }
}