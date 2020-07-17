package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

public class IntakeWheels {
    private final SpeedController moter = new Spark(3);
}
public void Grab() {
   moter.set(0.5);
}
public void Release(){
    moter.set(-0.5);
}
public boolean Holdstop(){
}