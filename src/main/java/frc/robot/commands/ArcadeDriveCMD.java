// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubsystem;

public class ArcadeDriveCMD extends CommandBase {
  /** Creates a new ArcadeDriveCMD. */

  // Create drivesystem object
  private final DriveTrainSubsystem driveSub;
  private final XboxController controller = Constants.OperatorConstants.xboxControlluh;


  public ArcadeDriveCMD(DriveTrainSubsystem drive) {
    // AddRequirements allows us to pass the drivetrain subsystem around different commands. 
    driveSub = drive;
    addRequirements(driveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSub.arcadeDrive(controller.getLeftY()*.69, controller.getRightX()*.69);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSub.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
