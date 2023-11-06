// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.lang.ModuleLayer.Controller;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final Joystick auxJoystick = new Joystick(0);
    public static final JoystickButton button1 = new JoystickButton (auxJoystick, 1);
    public static final POVButton povUp = new POVButton(auxJoystick, 0);
    public static final POVButton povDown = new POVButton(auxJoystick, 180);
    public static final JoystickButton button2 = new JoystickButton(auxJoystick, 2);
    public static final JoystickButton button3 = new JoystickButton(auxJoystick,3);
    
    public static final XboxController xboxControlluh = new XboxController(2);
  }
}
