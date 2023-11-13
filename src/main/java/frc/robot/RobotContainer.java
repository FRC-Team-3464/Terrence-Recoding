// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDriveCMD;
import frc.robot.commands.BallSpitterCMD;
import frc.robot.commands.BallSwallowerCMD;
import frc.robot.commands.ClimberMoveCMD;
import frc.robot.commands.RunBottomIntakeCMD;
import frc.robot.commands.ShootCMD;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Creates all our subsystem that the robot will be using.
  private final ClimberSubsystem climberSub = new ClimberSubsystem();
  private final IntakeSubsystem intakeSub = new IntakeSubsystem();
  private final ShooterSubsystem shooterSub = new ShooterSubsystem(); 
  private final DriveTrainSubsystem driveSub = new DriveTrainSubsystem();

  // Creates all the commands that use the subsystems to do their functions. 
  private final ClimberMoveCMD pull = new ClimberMoveCMD(false);  
  private final ClimberMoveCMD climb = new ClimberMoveCMD(true);
  private final BallSpitterCMD spitBalls = new BallSpitterCMD(intakeSub, shooterSub);
  private final BallSwallowerCMD swallowBalls = new BallSwallowerCMD(intakeSub);
  private final RunBottomIntakeCMD runBottom = new RunBottomIntakeCMD(intakeSub);
  private final ShootCMD ripOutBalls = new ShootCMD(shooterSub);
  private final ArcadeDriveCMD arcadeDrive = new ArcadeDriveCMD(driveSub);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
  // Default command: this command is called by default
   CommandScheduler.getInstance().setDefaultCommand(driveSub, arcadeDrive);

   Constants.OperatorConstants.button2.whileTrue(spitBalls);
   Constants.OperatorConstants.button3.whileTrue(swallowBalls);
   Constants.OperatorConstants.button1.whileTrue(ripOutBalls);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
