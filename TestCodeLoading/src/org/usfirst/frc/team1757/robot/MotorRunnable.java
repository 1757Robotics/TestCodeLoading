package org.usfirst.frc.team1757.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;

public class MotorRunnable implements Runnable {
		
	Thread thread;
	CANTalon talon4;
	
	double motorSpeed;
	
	public MotorRunnable(CANTalon talon, double motorSpeed) {
		this.talon4 = talon;
		this.motorSpeed = motorSpeed;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		//talon4.set(motorSpeed);

      thread = new Thread();
		thread.start();

		System.out.println("Pressed button. motorSpeed: " + motorSpeed);
		System.out.println("Sleeping for 2500 ms.");
		Timer.delay(2);
		return;
	}
	
	public void changeMotorSpeed(double motorSpeed) {
		this.motorSpeed = motorSpeed;
		run();
	}
}
