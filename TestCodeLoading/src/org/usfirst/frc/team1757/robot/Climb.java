package org.usfirst.frc.team1757.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climb {
	
	private CANTalon talon;
	private double climbMotorSpeed;
	
	public Climb() {
		talon = new CANTalon(4);
		talon.set(0);
		talon.setInverted(true);
	}
	
	public void downClimb() {
		climbMotorSpeed -= 0.01;
		System.out.println("Decrementing climbMotorSpeed..." + climbMotorSpeed);
		climbMotorSpeed = Math.max(-1, climbMotorSpeed);
	}
	
	public void upClimb() {
		climbMotorSpeed += 0.01;
		System.out.println("Incrementing climbMotorSpeed..." + climbMotorSpeed);
		climbMotorSpeed = Math.min(1, climbMotorSpeed);
	}
	
	public void stopClimb() {
		talon.set(0);
		SmartDashboard.putNumber("climb-climbMotorSpeed", climbMotorSpeed);
	}
	
	public void resetClimb() {
		climbMotorSpeed = 0;
		System.out.println("climbMotorSpeed: " + climbMotorSpeed);
		talon.set(climbMotorSpeed);
		SmartDashboard.putNumber("climb-climbMotorSpeed", climbMotorSpeed);
	}
	
	public void doClimb() {
		talon.set(climbMotorSpeed);
		System.out.println("climbing. Current climbMotorSpeed: " + climbMotorSpeed);
		SmartDashboard.putNumber("climb-climbMotorSpeed", climbMotorSpeed);
	}
}
