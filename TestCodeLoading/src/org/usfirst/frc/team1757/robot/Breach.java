package org.usfirst.frc.team1757.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**

 */
public class Breach {
	
	double breachSpeed;
	boolean isBreaching;
	
	static CANTalon talon4;
	
	static {
		talon4 = new CANTalon(4);
		talon4.setInverted(false);	
	}
	
	public Breach(double breachSpeed, boolean isBreaching) {
		this.breachSpeed = breachSpeed;
		this.isBreaching = isBreaching;
	}
	
	/**
	 * NEEDS FIXING, AND TUNING!!! (DRIVER OVERRIDE?)
	 */

	public void doBreach(Joystick gamepad) {
		
		if (gamepad.getRawAxis(2) > .2) {
			breachSpeed -= 0.01;
			System.out.println("Decrementing breachSpeed..." + breachSpeed);
			breachSpeed = Math.max(-1, breachSpeed);
			talon4.set(breachSpeed);
		} else if (gamepad.getRawAxis(3) > .2) {
			breachSpeed += 0.01;
			System.out.println("Incrementing breachSpeed..." + breachSpeed);
			breachSpeed = Math.min(1, breachSpeed);
			talon4.set(breachSpeed);
		} else {
			talon4.set(0);
			isBreaching = false;
		}
		
		SmartDashboard.putNumber("Breach-breachSpeed", breachSpeed);
		SmartDashboard.putBoolean("Breach-isBreaching?", isBreaching);
		
	}
}
