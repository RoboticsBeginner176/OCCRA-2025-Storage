// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.*;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.*;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.*;
import com.revrobotics.spark.SparkLowLevel.*;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/* This class declares the subsystem for the robot drivetrain if controllers are connected via CAN. Make sure to go to
 * RobotContainer and uncomment the line declaring this subsystem and comment the line for PWMDrivetrain.
 *
 * The subsystem contains the objects for the hardware contained in the mechanism and handles low level logic
 * for control. Subsystems are a mechanism that, when used in conjuction with command "Requirements", ensure
 * that hardware is only being used by 1 command at a time.
 */
public class CANDrivetrain extends SubsystemBase {
  /*Class member variables. These variables represent things the class needs to keep track of and use between
  different method calls. */
  DifferentialDrive m_drivetrain;
  
  //RelativeEncoder m_leftFrontSpeedEncoder;
  //RelativeEncoder m_rightFrontSpeedEncoder;
  SparkMax leftFront, rightFront, leftRear, rightRear;
  
  /*Constructor. This method is called when an instance of the class is created. This should generally be used to set up
   * member variables and perform any configuration or set up necessary on hardware.
   */
  public CANDrivetrain() {
    leftFront = new SparkMax(kLeftFrontID, MotorType.kBrushless);
    rightFront = new SparkMax(kRightFrontID, MotorType.kBrushless);
    leftRear = new SparkMax(kLeftRearID, MotorType.kBrushless);
    rightRear = new SparkMax(kRightRearID, MotorType.kBrushless);
     

    SparkMaxConfig configRightFront = new SparkMaxConfig();    
    configRightFront
      .inverted(true)
      .idleMode(IdleMode.kBrake)
      .openLoopRampRate(0);
    rightFront.configure(configRightFront, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    SparkMaxConfig configRightRear = new SparkMaxConfig();    
    configRightRear
      .inverted(true)
      .follow(kRightFrontID)
      .idleMode(IdleMode.kBrake)
      .openLoopRampRate(0);
    rightRear.configure(configRightRear, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
 
 
    SparkMaxConfig configLeftFront = new SparkMaxConfig();    
    configLeftFront
      .inverted(false)
      .idleMode(IdleMode.kBrake)
      .openLoopRampRate(0);
    leftFront.configure(configLeftFront, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    SparkMaxConfig configLeftRear = new SparkMaxConfig();    
    configLeftRear
      .inverted(false)
      .follow(kLeftFrontID)
      .idleMode(IdleMode.kBrake)
      .openLoopRampRate(0);
    leftRear.configure(configLeftRear, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

      // Put the front motors into the differential drive object. This will control all 4 motors with
      // the rears set to follow the fronts
      m_drivetrain = new DifferentialDrive(leftFront, rightFront);
    

  
  }
  /*Method to control the drivetrain using arcade drive. Arcade drive takes a speed in the X (forward/back) direction
   * and a rotation about the Z (turning the robot about it's center) and uses these to control the drivetrain motors */
  public void arcadeDrive(double speed, double rotation) {
    m_drivetrain.arcadeDrive(speed, -rotation);
    
  }
  

  @Override
  public void periodic() {
   
    

    /*This method will be called once per scheduler run. It can be used for running tasks we know we want to update each
     * loop such as processing sensor data. Our drivetrain is simple so we don't have anything to put here */
    //SmartDashboard.putNumber("Left Drive Position", m_leftFrontSpeedEncoder.getPosition());
    //SmartDashboard.putNumber("Right Drive Position", m_rightFrontSpeedEncoder.getPosition());
    //SmartDashboard.putNumber("Left Drive Speed", m_leftFrontSpeedEncoder.getVelocity());
    //SmartDashboard.putNumber("Right Drive Speed", m_rightFrontSpeedEncoder.getVelocity());
  }
}
