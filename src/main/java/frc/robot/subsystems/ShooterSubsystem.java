// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private final CANSparkMax shooterMotor = new CANSparkMax(10, MotorType.kBrushless);
  private final RelativeEncoder shootEncoder = shooterMotor.getEncoder();

  public ShooterSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double getEncoder() {
    return shootEncoder.getPosition();
  }

  public void resetEncoder() {
    shootEncoder.setPosition(0);
  }

  public void runFlywheel(){
    shooterMotor.set(-0.65);
  }

 public void stopFlywheel(){
  shooterMotor.set(0);
 }

 public void reverseFlywheel(){
  shooterMotor.set(0.7345921);
 }

}
