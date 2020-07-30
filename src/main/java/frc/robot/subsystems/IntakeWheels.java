package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeWheels extends SubsystemBase{
    private final SpeedController wheels = new VictorSP(3);
    public void grab() {
        wheels.set(0.5);
    }
    public void release(){
        wheels.set(-0.5);
    }
    public void stop() {
        wheels.set(0);
    }
}
