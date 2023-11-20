// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */

  // Define the sparks
  private final Spark lowerMotor = new Spark(0);
  private final Spark upperMotor = new Spark(1);

  public IntakeSubsystem() {}

  public void runIntakeBottom() {
    lowerMotor.set(0.654);
  }

  public void runIntakes() {
    upperMotor.set(0.34);
    lowerMotor.set(0.592);
  }

  public void spitOutBalls() {
    upperMotor.set(-0.58);
    lowerMotor.set(-0.54);
  }

  public void stopIntakes() {
    upperMotor.set(0);
    lowerMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
