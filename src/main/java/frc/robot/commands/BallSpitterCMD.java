// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class BallSpitterCMD extends CommandBase {
  /** Creates a new BallSpitterCMD. */

  private final IntakeSubsystem intakeSub;

private final ShooterSubsystem shooterSub;

  public BallSpitterCMD(IntakeSubsystem intakesub, ShooterSubsystem shooterSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intakeSub = intakesub;
    addRequirements(intakesub);
    this.shooterSub = shooterSub;
    addRequirements((shooterSub));
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSub.stopIntakes();
    shooterSub.stopFlywheel();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSub.spitOutBalls();
    shooterSub.reverseFlywheel();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSub.stopIntakes();
    shooterSub.stopFlywheel();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
