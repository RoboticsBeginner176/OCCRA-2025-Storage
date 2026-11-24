// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.ElevatorConstants.kElevatorSpeed;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ClawsCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.subsystems.CANElevator;
import frc.robot.subsystems.CANDrivetrain;
import frc.robot.subsystems.CANClaws;
import frc.robot.subsystems.CANClaws2;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems are defined here.
   private final CANDrivetrain m_drivetrain = new CANDrivetrain();
   private final CANClaws m_Claws = new CANClaws();
   private final CANElevator m_Elevator = new CANElevator();
   private final CANClaws2 m_Claws2 = new CANClaws2();


  /*The gamepad provided in the KOP shows up like an XBox contrller if the mode switch is set to X mode using the
   * switch on the top.*/
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_operatorController =
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);
  //SlewRateLimiter turnRateLimiter = new SlewRateLimiter(4);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }
// Eesh Garg was here
// Rodent Turtle Tina waz hear
  /**
   * Use this method to define your trigger->command mappings. Triggers can be accessed via the
   * named factory methods in the Command* classes in edu.wpi.first.wpilibj2.command.button (shown
   * below) or via the Trigger constructor for arbitary conditions
   */
  private void configureBindings() {
    // Set the default command for the drivetrain to drive using the joysticks
    /*m_drivetrain.setDefaultCommand(
        new RunCommand(
            () ->
                m_drivetrain.arcadeDrive(
                    -m_driverController.getLeftY(), -m_driverController.getRightX()),
            m_drivetrain));*/

    m_drivetrain.setDefaultCommand(
        new RunCommand(
            () ->
                m_drivetrain.arcadeDrive(
                  -(m_driverController.getLeftTriggerAxis() - m_driverController.getRightTriggerAxis()), m_driverController.getLeftX()),
            m_drivetrain));


    // Set up a binding to run the launcher command while the operator is pressing and holding the
    // left trigger
    // m_driverController.y().whileTrue(m_launcher.getAmpShooterCommand());

     m_operatorController.leftBumper().whileTrue(m_Claws.getClawsCommand());
     m_operatorController.a().whileTrue(m_Elevator.getElevatorCommand());
     m_operatorController.b().whileTrue(m_Elevator.getReverseElevatorCommand());
     m_operatorController.leftTrigger().whileTrue(m_Claws.getReverseClawsCommand());
     m_operatorController.rightTrigger().whileTrue(m_Claws2.getClaws2Command());
     m_operatorController.rightBumper().whileTrue(m_Claws2.getReverseClaws2Command());
 
  }
  public Command getAutonomousCommand() {
    return Commands.sequence(
      new RunCommand(() -> m_drivetrain.arcadeDrive(0.5, 0), m_drivetrain).withTimeout(2.5),
      new RunCommand(() -> m_drivetrain.arcadeDrive(0, 0.5), m_drivetrain).withTimeout(0.7), 
      new RunCommand(() -> m_drivetrain.arcadeDrive(0.5, 0), m_drivetrain).withTimeout(1)
      //new InstantCommand(() -> m_drivetrain.arcadeDrive(0, 0), m_drivetrain),
      //new ElevatorCommand(m_Elevator, 0.3, 1).withTimeout(3),
      //new ClawsCommand(m_Claws, -0.3, 1).withTimeout(2)
      );
  
  }
}