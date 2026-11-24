// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.commands;


import static frc.robot.Constants.ElevatorConstants.*;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer.*;
import frc.robot.subsystems.CANElevator;


/*This is an example of creating a command as a class. The base Command class provides a set of methods that your command
 * will override.
 */
public class ElevatorCommand extends Command {
 // PWMLauncher m_launcher;


  CANElevator m_Elevator;


  /** Creates a new LaunchNote. */
  public ElevatorCommand(CANElevator elevator, double speed, double seconds) {
    // save the launcher system interna
    m_Elevator = elevator;
   


    // indicate that this command requires the launcher system
    addRequirements(m_Elevator);
  }


  // The initialize method is called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Set the wheels to launching speed
    m_Elevator.setElevatorWheel(kElevatorSpeed);
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*double elevatordamp = 0.3;
    double kElevatorSpeed;

    kElevatorSpeed = RobotContainer.configureBindings.kOperatorControllerPort.a();
    if (Math.abs(kElevatorSpeed) < 0.05) {kElevatorSpeed = 0.3;
    } else if (kElevatorSpeed > 0) {kElevatorSpeed = -0.5;
    }
    m_Elevator.setElevatorWheel(kElevatorSpeed * elevatordamp);*/
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use the
    // scheduler to end the command when the button is released.
    return false;
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the wheels when the command ends.
    m_Elevator.stop();
  }
}


