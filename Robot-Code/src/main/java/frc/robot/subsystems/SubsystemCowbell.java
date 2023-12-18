/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.util.Util;

/**
 * Add your docs here.
 */
public class SubsystemCowbell extends Subsystem {
  private TalonSRX cowbell;

  public SubsystemCowbell() {
    cowbell = new TalonSRX(Constants.COWBELL_MOTOR_ID);
    setBraking(true);
  }

  @Override
  public void initDefaultCommand() {
  }

  public void spin() {
    double bellDriveValue = Util.getAndSetDouble("Cowbell Drive Power", Constants.COWBELL_DRIVE_VALUE);
    cowbell.set(ControlMode.PercentOutput, bellDriveValue);
  }

  public void stopSpinning() {
    cowbell.set(ControlMode.PercentOutput, 0);
  }

  private void setBraking(boolean brake) {
    cowbell.setNeutralMode((brake ? NeutralMode.Brake : NeutralMode.Coast));
  }
}
