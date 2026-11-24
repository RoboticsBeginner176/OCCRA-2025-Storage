// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.CANDrivetrain;
import frc.robot.subsystems.CANClaws;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;

public final class Autos {
  /** Example static factory for an autonomous command. */
   public static Command exampleAuto(CANDrivetrain driveSubsystem, CANClaws claws) {
    CANDrivetrain m_drivetrain;
    CANClaws m_Claws;
    m_drivetrain = driveSubsystem;
    m_Claws = claws;
    return new RunCommand(() -> new SequentialCommandGroup(
      new DriveCommand(m_drivetrain, 0.4, 0).withTimeout(5),
      new WaitCommand(4),
      new ClawsCommand(m_Claws, 3, 0).withTimeout(1.0)
      ));
    
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
