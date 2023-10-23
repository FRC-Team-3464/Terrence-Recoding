// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimberRetractCMD extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ExampleSubsystem climberSub;



  /** Creates a new ClimberRetractCMD. */
  public ClimberRetractCMD(ClimberRetractCMD climberSub) {
    this.climberSub = climberSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climberSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void execute() {
    climberSub.elevatorDown();

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
