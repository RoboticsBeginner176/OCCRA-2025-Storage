// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;


import static frc.robot.Constants.IntakeConstants.*;


import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.*;
import com.revrobotics.spark.SparkLowLevel.*;
import com.revrobotics.spark.config.*;
import com.revrobotics.spark.config.SparkBaseConfig.*;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class CANClaws extends SubsystemBase {
  SparkMax m_Claws;
  //RelativeEncoder m_rollerEncoder;


  /** Creates a new Launcher. */
  public CANClaws() {
    m_Claws = new SparkMax(kIntakeID, MotorType.kBrushed);


    SparkMaxConfig configIntake = new SparkMaxConfig();    
    configIntake
      .idleMode(IdleMode.kBrake)
      .smartCurrentLimit(60);
    m_Claws.configure(configIntake, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);


    //m_rollerEncoder = m_LaunchWheel.getEncoder();
  }


  /*
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands.
   */
  public Command getClawsCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setClawsWheel(kIntakeSpeedClawLeft);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }


   public Command getReverseClawsCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setClawsWheel(kIntakeReverseSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }






  // An accessor method to set the speed (technically the output percentage) of the launch wheel
  public void setClawsWheel(double speed) {
    m_Claws.set(speed);
  }






  // A helper method to stop both wheels. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
  public void stop() {
    m_Claws.set(0);
  }


  @Override
  public void periodic(){
    //SmartDashboard.putNumber("Left Launcher Speed", m_rollerEncoder.getVelocity());
  }
}


