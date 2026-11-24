// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANDrivetrain;

// Command to drive the robot with joystick inputs
public class DriveCommand extends Command {
  CANDrivetrain m_Drivetrain;
    private double speed;
        private double rotation;
        // Constructor. Runs only once when the command is first created.
        public DriveCommand (CANDrivetrain drivetrain, double speed, double rotation) {
          // Save parameters to local variables for use later
          // this.xSpeed = xSpeed; 
          // this.zRotation = zRotation;
          m_Drivetrain = drivetrain;
          this.speed = speed;
          this.rotation = rotation;
    
    // Declare subsystems required by this command. This should include any
    // subsystem this command sets and output of
    addRequirements(drivetrain);
  }

  // Runs each time the command is scheduled.
  @Override
  public void initialize() {
  }

  // Runs every cycle while the command is scheduled (~50 times per second)
  @Override
  public void execute() {
    System.out.println("auto drive");
    m_Drivetrain.arcadeDrive(speed, rotation);
  }

  // Runs each time the command ends via isFinished or being interrupted.
  @Override
  public void end(boolean isInterrupted) {
  }

  // Runs every cycle while the command is scheduled to check if the command is
  // finished
  @Override
  public boolean isFinished() {
    // Return false to indicate that this command never ends. It can be interrupted
    // by another command needing the same subsystem.
    return false;
  }
}
