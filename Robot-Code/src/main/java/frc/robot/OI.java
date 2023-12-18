/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.util.Xbox;
import frc.robot.commands.ButtonCommandBlowLoudHorn;
import frc.robot.commands.ButtonCommandBlowDoubleHorn;
import frc.robot.commands.ButtonCommandBlowBothHorns;
import frc.robot.commands.ButtonCommandDriveCowbells;
import frc.robot.commands.InstantCommandToggleCompressor;

/**
 * Controllers, button controls, and thats about it.
 */
public class OI {
    public static Joystick DRIVER   = new Joystick(0);
    public static Joystick OPERATOR = new Joystick(1);

    public OI() {
        //dashboard buttons
        SmartDashboard.putData("Toggle Compressor", new InstantCommandToggleCompressor());

        //operator controls

        //blow big horn exclusively
        JoystickButton blowLoudHorn = new JoystickButton(OPERATOR, Xbox.B);
            blowLoudHorn.whileHeld(new ButtonCommandBlowLoudHorn());

        //blow double horn exclusively
        JoystickButton blowDoubleHorn = new JoystickButton(OPERATOR, Xbox.Y);
            blowDoubleHorn.whileHeld(new ButtonCommandBlowDoubleHorn());

        //blow both horns
        JoystickButton blowBothHorns = new JoystickButton(OPERATOR, Xbox.A);
            blowBothHorns.whileHeld(new ButtonCommandBlowBothHorns());

        //ring the cowbells
        JoystickButton ringCowbells = new JoystickButton(OPERATOR, Xbox.X);
            ringCowbells.whileHeld(new ButtonCommandDriveCowbells());
    }
}
