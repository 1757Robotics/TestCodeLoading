
package org.usfirst.frc.team1757.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	//Joystick gamepad;
	Joystick buttons;
	
	double motorSpeed;
	
	MotorRunnable motorRunnable;

	CANTalon talon4;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {

		//gamepad = new Joystick(0);
		buttons = new Joystick(0);
		
		talon4 = new CANTalon(4);
		talon4.set(0);
		talon4.setInverted(false);
		
		motorRunnable = new MotorRunnable(talon4, 0);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
	public void autonomousInit() {
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		doMotorTest();
		testJoystickButtons();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

	public void doMotorTest() {
		/*if (gamepad.getRawAxis(2) > .2) {
			motorSpeed -= 0.01;
			System.out.println("Decrementing motorSpeed..." + motorSpeed);
			motorSpeed = Math.max(-1, motorSpeed);
		} else if (gamepad.getRawAxis(3) > .2) {
			motorSpeed += 0.01;
			System.out.println("Incrementing motorSpeed..." + motorSpeed);
			motorSpeed = Math.min(1, motorSpeed);
		} 

		if (gamepad.getRawButton(1)) {
			talon4.set(motorSpeed);
		} else if (gamepad.getRawButton(2)) {
			motorSpeed = 0;
			talon4.set(motorSpeed);
		} else {
			talon4.set(0);
			isActivated = false;
		}

		SmartDashboard.putNumber("Motor-motorSpeed", motorSpeed);
		SmartDashboard.putBoolean("Motor-isActivated?", isActivated); */
	}

	public void testJoystickButtons()  {
		if (buttons.getRawButton(1)) {
			motorSpeed = 0;
			motorRunnable.changeMotorSpeed(motorSpeed);
		} if (buttons.getRawButton(2)) {
			motorSpeed = .5;
			motorRunnable.changeMotorSpeed(motorSpeed);
		}
	}
}
