// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  /** Creates a new DriveTrainSubsystem. */
  
  private final CANSparkMax
    leftFront = new CANSparkMax(5, MotorType.kBrushless),
    leftBack = new CANSparkMax(6, MotorType.kBrushless),
    rightFront = new CANSparkMax(7, MotorType.kBrushless),
    rightBack = new CANSparkMax(8, MotorType.kBrushless);
  
  public DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);
  

  public DriveTrainSubsystem() {
    leftFront.setInverted(true);
  }
//yippie!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!111


  public void arcadeDrive(double speed, double rotation) {

    drive.arcadeDrive(speed, rotation);
    
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
  }

//help me ben is holding me hostage
//me too

  public void stopMotors() {
    arcadeDrive(0, 0);
  }

  public double getLeft(){
    return leftFront.get();
  }

  public double getRight(){
    return rightFront.get();
  }


  public void enableMotors(boolean on) {
    IdleMode mode;
    if (on) {
      mode = IdleMode.kBrake;
    } else {
      mode = IdleMode.kCoast;
    }
    
    leftFront.setIdleMode(mode);
    leftBack.setIdleMode(mode);
    rightFront.setIdleMode(mode);
    rightBack.setIdleMode(mode);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
