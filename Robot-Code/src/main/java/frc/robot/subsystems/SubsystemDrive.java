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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.util.Util;
import frc.robot.util.Xbox;
import frc.robot.commands.ManualCommandDrive;

/**
 * The thing that makes the wheels move bro
 */
public class SubsystemDrive extends Subsystem {
  
  private TalonSRX
    leftMaster,
    leftSlave,
    rightMaster,
    rightSlave;


  public SubsystemDrive() {
    leftMaster  = new TalonSRX(Constants.DRIVE_LEFT_MASTER_ID);
    leftSlave   = new TalonSRX(Constants.DRIVE_LEFT_SLAVE_ID);
    rightMaster = new TalonSRX(Constants.DRIVE_RIGHT_MASTER_ID);
    rightSlave  = new TalonSRX(Constants.DRIVE_RIGHT_SLAVE_ID);

    //configure settings
    setInverts();
    setBraking(true);
    setRamps();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ManualCommandDrive());
  }

  public void setInverts() {
    leftMaster.setInverted(Constants.DRIVE_LEFT_MASTER_INVERT);
    leftSlave.setInverted(Constants.DRIVE_LEFT_SLAVE_INVERT);
    rightMaster.setInverted(Constants.DRIVE_RIGHT_MASTER_INVERT);
    rightSlave.setInverted(Constants.DRIVE_RIGHT_SLAVE_INVERT);
  }

  public void drive(Joystick joy) {
    double throttle = Xbox.RT(joy) - Xbox.LT(joy);
    double steering = Xbox.LEFT_X(joy);

    double driveRight = throttle - steering;
    double driveLeft = throttle + steering;

    driveRight = (driveRight < -1 ? -1 : (driveRight > 1 ? 1 : driveRight));
    driveLeft = (driveLeft < -1 ? -1 : (driveLeft > 1 ? 1 : driveLeft));

    setMotors(driveLeft, driveRight);
  }

  public void setMotors(double left, double right) {
    leftMaster.set(ControlMode.PercentOutput, left);
    leftSlave.set(ControlMode.PercentOutput, left);
    rightMaster.set(ControlMode.PercentOutput, right);
    rightSlave.set(ControlMode.PercentOutput, right);
  }

  /**
   * Returns an array containing the speeds the motors are set to.
   * [0] = right speed
   * [1] = left speed
   */
  public double[] getSpeeds() {
    double[] speeds = {
      rightMaster.getMotorOutputPercent(),
      leftMaster.getMotorOutputPercent()
    };

    return speeds;
  }

  /**
   * Returns an array containing the amp draw of the motors.
   * [0] = right master amps
   * [1] = left master amps
   * [2] = right slave amps
   * [3] = left slave amps
   */
  public double[] getAmps() {
    double[] amps = {
      rightMaster.getOutputCurrent(),
      leftMaster.getOutputCurrent(),
      rightSlave.getOutputCurrent(),
      leftSlave.getOutputCurrent()
    };

    return amps;
  }

  private void setBraking(boolean braking) {
    NeutralMode newMode = (braking ? NeutralMode.Brake : NeutralMode.Coast);

    leftMaster.setNeutralMode(newMode);
    leftSlave.setNeutralMode(newMode);
    rightMaster.setNeutralMode(newMode);
    rightSlave.setNeutralMode(newMode);
  }

  private void setRamps() {
    double ramp = Util.getAndSetDouble("Drive Ramps", Constants.DRIVE_RAMPS);
    leftMaster.configOpenloopRamp(ramp);
    leftSlave.configOpenloopRamp(ramp);
    rightMaster.configOpenloopRamp(ramp);
    rightSlave.configOpenloopRamp(ramp);
  }
}
