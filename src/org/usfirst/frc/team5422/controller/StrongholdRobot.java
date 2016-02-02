package org.usfirst.frc.team5422.controller;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team5422.DSIO.DSIO;
import org.usfirst.frc.team5422.commands.AlignToDefenseCommand;
import org.usfirst.frc.team5422.navigator.Driver;
import org.usfirst.frc.team5422.navigator.Navigator;
import org.usfirst.frc.team5422.opener.Opener;
import org.usfirst.frc.team5422.opener.SallyPortOpener;
import org.usfirst.frc.team5422.shooter.BallShooter;
import org.usfirst.frc.team5422.shooter.Shooter;
import org.usfirst.frc.team5422.utils.PIDTuner;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * This is a demo program showing the use of the RobotDrive class.
 * The SampleRobot class is the base of a robot application that will automatically call your
 * Autonomous and OperatorControl methods at the right time as controlled by the switches on
 * the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class StrongholdRobot extends SampleRobot {
	public static final Navigator navigatorSubsystem = new Navigator();
	public static final Shooter shooterSubsystem = new BallShooter();
	public static final Opener openerSubsystem = new SallyPortOpener();

	public static DSIO dsio;
	public static Driver driver;
	public static PIDTuner pidTuner;

	RobotDrive myRobot;
	Joystick stick;
	Ultrasonic usonic;
	LiveWindow lw;

	Command autonomousCommand;
	Command alignToDefense;

	public StrongholdRobot() {
		lw = new LiveWindow();
		/*      
 		myRobot = new RobotDrive(0, 1);
        myRobot.setExpiration(0.1);
        stick = new Joystick(0);
		 */    
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.

		dsio = new DSIO(0, 0);
		driver = new Driver(CANTalon.TalonControlMode.Speed);
		dsio.createAutonomousUI();
		//		pidTuner = new PIDTuner();

		//instantiate commands used for the autonomous period
		//for example, start with aligning the robot to the appropriate 
		//defense position with the required defense type
		alignToDefense = new AlignToDefenseCommand();
	}    

	/**
	 * Drive left & right motors for 2 seconds then stop 
	 */
	public void autonomous() {
		if (autonomousCommand != null) autonomousCommand.start();
		System.out.println("auto init started.");

		//		PIDTuner.tunePIDPosition();

		AutonomousController.go();
		System.out.println("auto init ended.");
	}

	/**
	 * Runs the motors with arcade steering.
	 */
	public void operatorControl() {
		System.out.println("Printing in Teleop...");
		while (isOperatorControl() && isEnabled()) {        	
			Scheduler.getInstance().run();
			
			//Run the openDrive() method 
			Driver.openDrive(DSIO.getLinearY(), DSIO.getLinearX(), CANTalon.TalonControlMode.Speed);        
		}

	}

	/**
	 * Runs during test mode
	 */
	public void test() {
		System.out.println("Printing in Test Mode...");

	}

}
