
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

/**
 * For motor: 
 * positive = UP
 * negative = DOWN
 * 
 * @author Larry
 *
 */



public class Robot extends IterativeRobot {

	Joystick gamepad;
	MotorTypes motorTypes;

	double breachMotorSpeed;
	double climbMotorSpeed;

	CANTalon talon4;
	CANTalon talon5;

	public static int BUTTON_A, BUTTON_B, BUTTON_X, BUTTON_Y;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	public enum MotorTypes {
		Breach, Climb;
	}

	public void robotInit() {
		//CHECK BUTTON MAPPINGS AGAIN
		//CHANGE BUTTON PORTS BELOW

		BUTTON_A = 1;
		BUTTON_B = 2;
		BUTTON_X = 3;
		BUTTON_Y = 4;

		motorTypes = MotorTypes.Breach;

		gamepad = new Joystick(0);

		talon4 = new CANTalon(4);
		talon4.set(0);
		talon4.setInverted(false);

		talon5 = new CANTalon(5);
		talon5.set(0);
		talon5.setInverted(true);
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
		checkMotorMode();
		SmartDashboard.putString("Current MotorType", motorTypes.toString());
		doMotorTest();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

	public void checkMotorMode() {
		if (gamepad.getRawButton(BUTTON_A)) {
			switch (motorTypes) {
			case Breach:
				motorTypes = MotorTypes.Climb;
				System.out.println("Switched MotorType: " + motorTypes);
				break;
			case Climb:
				motorTypes = MotorTypes.Breach;
				System.out.println("Switched MotorType: " + motorTypes);
				break;
			}
		}
	}

	public void doMotorTest() {
		//CHANGE BUTTON MAPPINGS
		switch (motorTypes) {
		case Breach:
			doBreach();
			break;
		case Climb:
			doClimb();
			break;
		default: 
			System.out.println("Error: No MotorType");
		}
	}
	
	public void doBreach() {
		if (gamepad.getRawButton(4)) {
			breachMotorSpeed -= 0.01;
			System.out.println("Decrementing breachMotorSpeed..." + breachMotorSpeed);
			breachMotorSpeed = Math.max(-1, breachMotorSpeed);
		} else if (gamepad.getRawButton(5)) {
			breachMotorSpeed += 0.01;
			System.out.println("Incrementing breachMotorSpeed..." + breachMotorSpeed);
			breachMotorSpeed = Math.min(1, breachMotorSpeed);
		} 

		if (gamepad.getRawButton(1)) {
			talon4.set(breachMotorSpeed);
			System.out.println("Breaching. Current breachMotorSpeed: " + breachMotorSpeed);
		} else if (gamepad.getRawButton(2)) {
			breachMotorSpeed = 0;
			System.out.println("breachMotorSpeed: " + breachMotorSpeed);
			talon4.set(breachMotorSpeed);
		} else {
			talon4.set(0);
		}

		SmartDashboard.putNumber("Breach-breachMotorSpeed", breachMotorSpeed);
	}
	
	public void doClimb() {
		if (gamepad.getRawButton(4)) {
			climbMotorSpeed -= 0.01;
			System.out.println("Decrementing climbMotorSpeed..." + climbMotorSpeed);
			climbMotorSpeed = Math.max(-1, climbMotorSpeed);
		} else if (gamepad.getRawButton(5)) {
			climbMotorSpeed += 0.01;
			System.out.println("Incrementing climbMotorSpeed..." + climbMotorSpeed);
			climbMotorSpeed = Math.min(1, climbMotorSpeed);
		} 

		if (gamepad.getRawButton(1)) {
			talon5.set(climbMotorSpeed);
			System.out.println("Climbing. Current climbMotorSpeed: " + climbMotorSpeed);
		} else if (gamepad.getRawButton(2)) {
			climbMotorSpeed = 0;
			System.out.println("climbMotorSpeed: " + climbMotorSpeed);
			talon5.set(climbMotorSpeed);
		} else {
			talon5.set(0);
		}

		SmartDashboard.putNumber("climb-climbMotorSpeed", climbMotorSpeed);
	}
}
