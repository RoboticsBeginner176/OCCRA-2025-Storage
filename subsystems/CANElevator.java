// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;


import static frc.robot.Constants.ElevatorConstants.*;


import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.*;
import com.revrobotics.spark.SparkLowLevel.*;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.config.*;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;




public class CANElevator extends SubsystemBase {
  SparkMax Elevatorleft, ElevatorRight;
  CANElevator m_Elevator;

  /** Creates a new Launcher. */
  public CANElevator() {
    Elevatorleft = new SparkMax(kElevatorID, MotorType.kBrushed);
    ElevatorRight = new SparkMax(kElevator2ID, MotorType.kBrushed);


    SparkMaxConfig configElevatorleft = new SparkMaxConfig();    
    configElevatorleft
      .inverted(true)
      .idleMode(IdleMode.kBrake)
      .openLoopRampRate(0);
    Elevatorleft.configure(configElevatorleft, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    SparkMaxConfig configElevatorRight = new SparkMaxConfig();    
    configElevatorRight
      .inverted(true)
      .follow(kElevatorID)
      .idleMode(IdleMode.kBrake)
      .openLoopRampRate(0);
    ElevatorRight.configure(configElevatorRight, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }


  /*
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands.
   */
  public Command getElevatorCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setElevatorWheel(kElevatorSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }


  public Command getReverseElevatorCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setElevatorWheel(kElevatorReverseSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }









  // An accessor method to set the speed (technically the output percentage) of the launch wheel
  public void setElevatorWheel(double speed) {
    Elevatorleft.set(speed);
  }






  // A helper method to stop both wheels. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
  public void stop() {
    Elevatorleft.set(0);
  }


  @Override
  public void periodic(){

  }
}


