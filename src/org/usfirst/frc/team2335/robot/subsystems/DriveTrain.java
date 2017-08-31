package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem
{
	Victor frontLeft, frontRight, backLeft, backRight;
	RobotDrive drive;
	
    public void initDefaultCommand()
    {
        frontLeft = new Victor(Robot.FRONT_LEFT_MOTOR);
        frontRight = new Victor(Robot.FRONT_RIGHT_MOTOR);
        backLeft = new Victor(Robot.BACK_LEFT_MOTOR);
        backRight = new Victor(Robot.BACK_RIGHT_MOTOR);
        
        drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
        
        drive.setSafetyEnabled(false);
    }
    
    public void drive(double move, double rotate)
    {
    	drive.arcadeDrive(-move, rotate);
    }
}

