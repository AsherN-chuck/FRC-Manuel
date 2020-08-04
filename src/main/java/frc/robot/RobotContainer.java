/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommandJoystick;
import frc.robot.commands.ElevatorCommandPosition;
import frc.robot.commands.JoystickCommandArm;
import frc.robot.commands.JoystickCommandElevator;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.IntakeWheels;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  Joystick joystick = new Joystick(0);
  // The robot's subsystems and commands are defined here...
  DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
  ElevatorSubsystem elevator = new ElevatorSubsystem();
  IntakeArm arm = new IntakeArm();
  IntakeWheels wheels = new IntakeWheels();
  
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    drivetrain.setDefaultCommand(new DriveCommandJoystick(drivetrain, () -> joystick.getX(), () -> joystick.getY()));
    elevator.setDefaultCommand(new JoystickCommandElevator(elevator, () -> joystick.getRawAxis(5)));
    wheels.setDefaultCommand(new RunCommand(wheels::stop, wheels));
    arm.setDefaultCommand(new JoystickCommandArm(arm, () -> joystick.getRawAxis(4)));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton intakeWheelButton = new JoystickButton(joystick, 0);
    JoystickButton ejectWheelButton = new JoystickButton(joystick, 1); 
    JoystickButton elevatorToTopButton = new JoystickButton(joystick, 2);
    JoystickButton elevatorToBottomButton = new JoystickButton(joystick, 3);

    elevatorToTopButton.whenPressed(new ElevatorCommandPosition(elevator, 1.1));
    elevatorToBottomButton.whenPressed(new ElevatorCommandPosition(elevator, 0));
    intakeWheelButton.whileHeld(wheels::grab, wheels);
    ejectWheelButton.whileHeld(wheels::release, wheels);
  }

public Command getAutonomousCommand() {
	return null;
}
}