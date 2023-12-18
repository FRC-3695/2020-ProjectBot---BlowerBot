//insert cool foximus ASCII art here

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
 
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.SubsystemCompressor;
import frc.robot.subsystems.SubsystemCowbell;
import frc.robot.subsystems.SubsystemDrive;
import frc.robot.subsystems.SubsystemHorn;


/**
 * 3695 Spirit Robot!
 */
public class Robot extends TimedRobot {

  public static SubsystemDrive      SUB_DRIVE;
  public static SubsystemCowbell    SUB_COWBELL;
  public static SubsystemHorn       SUB_HORN;
  public static SubsystemCompressor SUB_COMPRESSOR;
  public static OI                  oi;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    SUB_DRIVE =      new SubsystemDrive();
    SUB_COWBELL =    new SubsystemCowbell();
    SUB_HORN =       new SubsystemHorn();
    SUB_COMPRESSOR = new SubsystemCompressor();
    oi =             new OI();

    DriverStation.reportWarning("ROBOT INIT, HAVE FUN", false);
  }

  /**
   * Called no matter what state the robot is in (disabled, enabled, test, etc)
   */
  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();

    //update dashboard values
    SmartDashboard.putBoolean("Pressure Switch", SUB_COMPRESSOR.pressureSwitchTriggered());

    SmartDashboard.putNumber("Right Power", SUB_DRIVE.getSpeeds()[0]);
    SmartDashboard.putNumber("Left Power", SUB_DRIVE.getSpeeds()[1]);

    SmartDashboard.putNumber("Right Master Amps", SUB_DRIVE.getAmps()[0]);
    SmartDashboard.putNumber("Left Master Amps", SUB_DRIVE.getAmps()[1]);
    SmartDashboard.putNumber("Right Slave Amps", SUB_DRIVE.getAmps()[2]);
    SmartDashboard.putNumber("Left Slave Amps", SUB_DRIVE.getAmps()[3]);
  }

  /**
   * Called when auto starts
   */
  @Override
  public void autonomousInit() {
    DriverStation.reportWarning("AUTO STARTED!", false);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    Scheduler.getInstance().run();
  }
}
