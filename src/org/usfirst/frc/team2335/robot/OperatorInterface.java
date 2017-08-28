package org.usfirst.frc.team2335.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OperatorInterface
{
	Joystick xbox;
	
	public OperatorInterface()
	{
		xbox = new Joystick(0);
	}
	
	public double getAxis(int port, double maxVal)
	{
		return deadzone(xbox.getRawAxis(port), maxVal);
	}
	
	private static double deadzone(double controllerInput, double max) //Creates a deadzone for the axes of the controller
	{
    	//If the value from the controller is less than the deadzone value then it zeros out
    	//If not it subtracts the deadzone from the controller value
		controllerInput = -(Math.abs(controllerInput) <= Robot.DEADZONE ? 0 : (controllerInput = (controllerInput < 0) ? controllerInput : controllerInput));
		
		//Multiplies the controller value by the slope made from (y2 - y1) / (x2 - x1)
		return ((max - 0) / ((1 - Robot.DEADZONE) - 0) * (controllerInput - 0));
	}
}