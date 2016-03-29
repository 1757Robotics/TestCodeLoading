package org.usfirst.frc.team1757.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Breach {
	
	private CANTalon talon;
	private double breachMotorSpeed;
	
	public Breach() {
		talon = new CANTalon(4);
		talon.set(0);
		talon.setInverted(false);
	}
	
	public void downBreach() {
		breachMotorSpeed -= 0.01;
		System.out.println("Decrementing breachMotorSpeed..." + breachMotorSpeed);
		breachMotorSpeed = Math.max(-1, breachMotorSpeed);
	}
	
	public void upBreach() {
		breachMotorSpeed += 0.01;
		System.out.println("Incrementing breachMotorSpeed..." + breachMotorSpeed);
		breachMotorSpeed = Math.min(1, breachMotorSpeed);
	}
	
	public void stopBreach() {
		talon.set(0);
		SmartDashboard.putNumber("Breach-breachMotorSpeed", breachMotorSpeed);
	}
	
	public void resetBreach() {
		breachMotorSpeed = 0;
		System.out.println("breachMotorSpeed: " + breachMotorSpeed);
		talon.set(breachMotorSpeed);
		SmartDashboard.putNumber("Breach-breachMotorSpeed", breachMotorSpeed);
	}
	
	public void doBreach() {
		talon.set(breachMotorSpeed);
		System.out.println("Breaching. Current breachMotorSpeed: " + breachMotorSpeed);
		SmartDashboard.putNumber("Breach-breachMotorSpeed", breachMotorSpeed);
	}
	
}
