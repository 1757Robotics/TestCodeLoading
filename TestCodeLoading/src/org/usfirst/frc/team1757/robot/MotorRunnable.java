package org.usfirst.frc.team1757.robot;

import edu.wpi.first.wpilibj.CANTalon;

public class MotorRunnable implements Runnable {
		
	Thread thread;
	CANTalon talon4;
	double motorSpeed;
	
	public MotorRunnable(CANTalon talon, double motorSpeed) {
		this.talon4 = talon;
		this.motorSpeed = motorSpeed;
		thread = new Thread();
		thread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//talon4.set(motorSpeed);
		System.out.println("Pressed button. motorSpeed: " + motorSpeed);
		try {
			System.out.println("Sleeping for 2500 ms.");
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Sleep.");
			e.printStackTrace();
		}
	}
	
	public void changeMotorSpeed(double motorSpeed) {
		this.motorSpeed = motorSpeed;
		run();
	}
}
