// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    // Port numbers for driver and operator gamepads. These correspond with the numbers on the USB
    // tab of the DriverStation
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
  }

  public static class DrivetrainConstants {
    // PWM ports/CAN IDs for motor controllers
    public static final int kLeftRearID = 2;
    public static final int kLeftFrontID = 3;
    public static final int kRightRearID = 4;
    public static final int kRightFrontID = 1;

    // Current limit for drivetrain motors
    public static final int kCurrentLimit = 60;

    public static final double kLeftRearSpeed = 0.125;
    public static final double kRightRearSpeed = 0.125;
    public static final double kLeftFrontSpeed = 0.125;
    public static final double kRightFrontSpeed = 0.125;
    public static final double kLeftRearBackSpeed = -0.1;
    public static final double kRightRearBackSpeed = -0.1;
    public static final double kLeftFrontBackSpeed = -0.1;
    public static final double kRightFrontBackSpeed = -0.1;
  }


  public static class IntakeConstants {
    // PWM ports/CAN IDs for motor controllerskkk]k
    public static final int kIntakeID = 8;
    public static final int kIntake2ID = 5;

    // Speeds for wheels when intaking. Intake speeds are negative to run the wheels
    // in reverse
    public static final double kIntakeSpeedClawLeft = 0.5;
    public static final double kIntakeSpeedClawRight = 0.6;
    public static final double kIntakeReverseSpeed = -0.4;

    public static final double kFeederSpeed = -0.5;
    public static final double kFeederReverseSpeed = 0.5;

    
    public static final double kIntakeFeederDelay = 2.0;


  }
  
public static class ElevatorConstants {
    // PWM ports/CAN IDs for motor controllers
    public static final int kElevatorID = 10;
    public static final int kElevator2ID = 12;
    
    // Current limit for Elevator
    public static final int kElevatorCurrentLimit = 80;

    // Speeds for wheels when Elevating. Elevating speeds are negative to run the wheels
    // in reverse
    public static final double kElevatorSpeed = -0.5;
    public static final double kElevatorReverseSpeed = 0.2;

    public static final double kElevatorDelay = 0.000176;
}
}
