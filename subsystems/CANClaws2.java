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


public class CANClaws2 extends SubsystemBase {
  SparkMax m_Claws2;
  //RelativeEncoder m_rollerEncoder;


  /** Creates a new Launcher. */
  public CANClaws2() {
    m_Claws2 = new SparkMax(kIntake2ID, MotorType.kBrushed);


    SparkMaxConfig configIntake = new SparkMaxConfig();    
    configIntake
      .idleMode(IdleMode.kBrake)
      .smartCurrentLimit(60);
    m_Claws2.configure(configIntake, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);


    //m_rollerEncoder = m_LaunchWheel.getEncoder();
  }


  /*
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands.
   */
  public Command getClaws2Command() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setClaws2Wheel(kIntakeSpeedClawRight);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }


   public Command getReverseClaws2Command() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setClaws2Wheel(kIntakeReverseSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }






  // An accessor method to set the speed (technically the output percentage) of the launch wheel
  public void setClaws2Wheel(double speed) {
    m_Claws2.set(speed);
  }






  // A helper method to stop both wheels. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
  public void stop() {
    m_Claws2.set(0);
  }


  @Override
  public void periodic(){
    //SmartDashboard.putNumber("Left Launcher Speed", m_rollerEncoder.getVelocity());
  }
}


