public class DrivetrainSubsystem extends SubsystemBase{
    private SpeedController leftMoter = new Spark (0);
    private SpeedController rightMoter = new Spark (1);
}