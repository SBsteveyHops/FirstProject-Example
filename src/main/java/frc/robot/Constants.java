// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int CLIMBER1_PORT = 9;
    public static final int CLIMBER2_PORT = 10;
    public static final double CLIMBER_POWER = 1.0;
    // Create a new constant Called CLIMBER_CURRENT_LIMIT and set to 10
    public static final int CLIMBER_CURRENT_LIMIT = 10;
    public static final int INDEXER_EXTENSION = 40;
    public static final int INDEXER_SERVO_PORT = 0;
    public static final int TOP_SHOOTER_PORT = 6;
    public static final int BOTTOM_SHOOTER_PORT = 5;

    public static final int WHEEL_PORT_FRONT_LEFT = 1;
    public static final int WHEEL_PORT_REAR_LEFT = 3;
    public static final int WHEEL_PORT_FRONT_RIGHT = 2;
    public static final int WHEEL_PORT_REAR_RIGHT = 4;

    public static final double MOVEMENT_SPEED = 1;
    public static final double TURN_SPEED = 1;
    public static final double DRIVE_SPEED_MULTI = 1.0;

    public static final double DEADBAND = 0.06;
    public static final double EXPONENT = 0.1;
}
