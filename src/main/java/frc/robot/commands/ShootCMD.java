// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCMD extends CommandBase {
  /** Creates a new ShootCMD. */
  public final ShooterSubsystem shooterSub;
  public final IntakeSubsystem intakeSub;
  public ShootCMD(ShooterSubsystem shooterSub, IntakeSubsystem intakeSub) {
    // Use addRequirements() here to declare subsystem dependencies.\
    this.shooterSub = shooterSub;
    this.intakeSub = intakeSub;
    addRequirements(shooterSub);
    addRequirements(intakeSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSub.resetEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSub.runFlywheel();
    if(shooterSub.getEncoder() < -20) {
      intakeSub.runIntakes();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSub.stopFlywheel();
    shooterSub.resetEncoder();
    intakeSub.stopIntakes();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(shooterSub.getEncoder() < -100) {
      System.out.println(shooterSub.getEncoder());
      return true;
    } else {
      return false;
    }
  }
}