package org.usfirst.frc.team1757.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;

public class MotorRunnable implements Runnable {

	//Thread thread;
	CANTalon talon4;

	private double motorSpeed;

	public MotorRunnable(CANTalon talon, double motorSpeed) {
		this.talon4 = talon;
		this.motorSpeed = motorSpeed;
	}
	
	public void start() {
		
	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Started Thread: " + Thread.currentThread().getName());
			System.out.println("motorSpeed: " + motorSpeed);
			Timer.delay(1.5);
			//Thread.wait();
			Thread.currentThread().interrupt();
		}
	}

	/*public void changeMotorSpeed(double motorSpeed) {
		this.motorSpeed = motorSpeed;
		run();
	}*/
	
	public void waitUntil() {
		
	}
}
