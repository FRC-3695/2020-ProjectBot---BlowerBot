/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Add your docs here.
 */
public class SubsystemHorn extends Subsystem {
  private Solenoid
    loudHorn,
    doubleHorn;

  public SubsystemHorn() {
    loudHorn   = new Solenoid(Constants.LOUD_HORN_ID);
    doubleHorn = new Solenoid(Constants.DOUBLE_HORN_ID);

    loudHorn.set(false);
    doubleHorn.set(false);
  }
  
  @Override
  public void initDefaultCommand() {
  }

  public void setLoudHornIsBlowing(boolean blowing) {
    loudHorn.set(blowing);
  }

  public void setDoubleHornIsBlowing(boolean blowing) {
    doubleHorn.set(blowing);
  }

  public void stopHorns() {
    loudHorn.set(false);
    doubleHorn.set(false);
  }
}
