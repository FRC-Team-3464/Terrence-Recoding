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
 private final DigitalInput topLimitswitch = new DigitalInput(1);
 private final DigitalInput bottomLimitswitch = new DigitalInput(0);

/*   public void [functionName](args){
  ajf;sldkfjasldkjf
}
*/
// Public void elevatorUP

  public ClimberSubsystem() {}

// Method to move the elevator up if it doesn't hit switch.
public void elevatorUp(){
  if(!topLimitswitch.get() == true){
      elevatorMotor.set(0);
    } else {
      elevatorMotor.set(-1);
    }
  }

// Method to move the elevator down if it hits switch.
public void elevatorDown(){
  if (!bottomLimitswitch.get() == true){
    elevatorMotor.set(0);
  } else {
      elevatorMotor.set(1);
    }
  }
  
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
