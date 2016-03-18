
package org.usfirst.frc.team1757.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser chooser;

	Joystick gamepad;
	Joystick buttons;

	double breachSpeed;
	boolean isBreaching;

	CANTalon talon4;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		chooser = new SendableChooser();
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);

		gamepad = new Joystick(0);
		buttons = new Joystick(1);
		talon4 = new CANTalon(4);
		talon4.set(0);
		talon4.setInverted(false);	
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
		autoSelected = (String) chooser.getSelected();
		//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		switch(autoSelected) {
		case customAuto:
			//Put custom auto code here   
			break;
		case defaultAuto:
		default:
			//Put default auto code here
			break;
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		doBreach();
		testJoystickButtons();
		doClimb();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

	public void doBreach() {
		if (gamepad.getRawAxis(2) > .2) {
			breachSpeed -= 0.01;
			System.out.println("Decrementing breachSpeed..." + breachSpeed);
			breachSpeed = Math.max(-1, breachSpeed);
		} else if (gamepad.getRawAxis(3) > .2) {
			breachSpeed += 0.01;
			System.out.println("Incrementing breachSpeed..." + breachSpeed);
			breachSpeed = Math.min(1, breachSpeed);
		} 

		if (gamepad.getRawButton(1)) {
			talon4.set(breachSpeed);
		} else {
			talon4.set(0);
			isBreaching = false;
		}

		SmartDashboard.putNumber("Breach-breachSpeed", breachSpeed);
		SmartDashboard.putBoolean("Breach-isBreaching?", isBreaching);
	}

	public void testJoystickButtons()  {

		if (buttons.getRawButton(1)) {
			System.out.println("Button 1");
		} else if (buttons.getRawButton(2)) {
			System.out.println("Button 2");
		} else if (buttons.getRawButton(3)) {
			System.out.println("Button 3");
		} else if (buttons.getRawButton(4)) {
			System.out.println("Button 4");
		} else if (buttons.getRawButton(5)) {
			System.out.println("Button 5");
		} else if (buttons.getRawButton(6)) {
			System.out.println("Button 6");
		}  	
	}

	public void doClimb() {
		
	}

}
