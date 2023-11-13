// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  /** Creates a new DriveTrainSubsystem. */
  
  private final CANSparkMax
    leftFront = new CANSparkMax(5, MotorType.kBrushless),
    leftBack = new CANSparkMax(6, MotorType.kBrushless),
    rightFront = new CANSparkMax(7, MotorType.kBrushless),
    rightBack = new CANSparkMax(8, MotorType.kBrushless);

  // Define our encoders
  private final RelativeEncoder leftFrontEncoder = leftFront.getEncoder();
  private final RelativeEncoder rightFrontEncoder = rightFront.getEncoder();
  // Creates a drive that goes forward, back, and rotates left and right. 
  public DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);

  public DriveTrainSubsystem() {
    // Invert the left motor. 
    leftFront.setInverted(true);

    // Set the back motors to follow the front ones. 
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);

    // Set all the motors to be brake mode. 
    enableMotors(true);

  }

  // Create the fuction to enable arcade drive. 
  public void arcadeDrive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }

  public void stopMotors() {
   drive.stopMotor(); // Stop the drive
    // arcadeDrive(0, 0);
  }

  // Gets how much the left motor has turned
  public double getLeft(){
    return leftFrontEncoder.getPosition();
  }

  public double getRight(){
    return rightFrontEncoder.getPosition();
  }

  // Set the motors to be either brake or coast mode
  public void enableMotors(boolean isBrake) {
    IdleMode mode;
    if (isBrake) {
      mode = IdleMode.kBrake;
    } else {
      mode = IdleMode.kCoast;
    }
    
    // Set all the motors to be on that mode. 
    leftFront.setIdleMode(mode);
    leftBack.setIdleMode(mode);
    rightFront.setIdleMode(mode);
    rightBack.setIdleMode(mode);

  }


  @Override
  public void periodic() {
    // Put how much the left motor has rotated on the Smartdashboard. 
    SmartDashboard.putNumber("Left Motor Encoder", getLeft());
    SmartDashboard.putNumber("Right Motor Encoder", getRight());

  }
}
