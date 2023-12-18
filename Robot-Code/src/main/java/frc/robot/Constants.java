/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Enumeration for some numbers that won't change
 */
public class Constants {

    //Drive Motor IDs
    public static final int
        DRIVE_LEFT_MASTER_ID = 1,
        DRIVE_LEFT_SLAVE_ID = 2,
        DRIVE_RIGHT_MASTER_ID = 3,
        DRIVE_RIGHT_SLAVE_ID = 4;

    //Cowbell motor IDs
    public static final int
        COWBELL_MOTOR_ID = 5;

    //Horn Solenoid IDs
    public static final int
        LOUD_HORN_ID = 7,
        DOUBLE_HORN_ID = 6;

    //Some default drive values. Dont take these values though, take them from dash. Only used as backups.
    public static final double
        COWBELL_DRIVE_VALUE = 0.25,
        DRIVE_RAMPS = 0.25;

    //Drive motor inverts
    public static final boolean
        DRIVE_LEFT_MASTER_INVERT  = false,
        DRIVE_LEFT_SLAVE_INVERT   = false,
        DRIVE_RIGHT_MASTER_INVERT = true,
        DRIVE_RIGHT_SLAVE_INVERT  = true;
}