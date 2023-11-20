// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. */
  private final Spark elevatorMotor = new Spark(2);
 private final DigitalInput topLimitSwitch = new DigitalInput(1);
 private final DigitalInput bottomLimitSwitch = new DigitalInput(0);
 private static ClimberSubsystem instance = null;


public ClimberSubsystem() {}

// Method to move the elevator up if it doesn't hit switch.
public void elevatorUp(){
  if(!topLimitSwitch.get() == true){
      elevatorMotor.set(0);
    } else {
      elevatorMotor.set(-1);
    }
  }

// Method to move the elevator down if it hits switch.
public void elevatorDown(){
  if (!bottomLimitSwitch.get() == true){
    elevatorMotor.set(0);
  } else {
      elevatorMotor.set(1);
    }
  }

  // Return top and bottom switch states (true/false)
public boolean bottomSwitchState(){
  return bottomLimitSwitch.get();
} 

public boolean topSwitchState(){
  return topLimitSwitch.get();
} 

public void stopMotor(){
  elevatorMotor.stopMotor();
}

  // Function returns the climberSubsystem instance
  // public static ClimberSubsystem getInstance(){
  //   if(instance == null) {
  //     instance = new ClimberSubsystem();
  //   }
  //   return instance;
  // }

  public void periodic() {
    // This method will be called once per scheduler run
    System.out.print(bottomLimitSwitch.get());
    System.out.println(topLimitSwitch.get());
    
  }
}
