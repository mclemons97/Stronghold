package org.usfirst.frc.team5422.shooter;

import org.usfirst.frc.team5422.DSIO.DSIO;
import org.usfirst.frc.team5422.controller.StrongholdRobot;
import org.usfirst.frc.team5422.utils.StrongholdConstants;
import org.usfirst.frc.team5422.utils.StrongholdUtils;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class helps develop the methods for a boulder/ball Shooter mechanism 
 */

/*
 *@author Aditya Naik
 */


public class BallShooter extends Subsystem {
	/**
	 * This function helps shoot the ball/boulder into the low goal
	 */
	
	public CANTalon talonL;
	public CANTalon talonR;
	public CANTalon actuator;
	Relay relay;
	
	public BallShooter() {
		talonL = new CANTalon(StrongholdConstants.TALON_LEFT_SHOOTER);
		talonL.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		talonL.changeControlMode(TalonControlMode.Speed);
		//Reverse output may be needed
//		talonL.configEncoderCodesPerRev(StrongholdConstants.ENCODER_TICKS_CPR);	
		talonL.configNominalOutputVoltage(+0.0f, -0.0f);
		talonL.setPID(StrongholdConstants.SHOOTER_LEFT_P, StrongholdConstants.SHOOTER_LEFT_I, StrongholdConstants.SHOOTER_LEFT_D);
		talonL.setF(StrongholdConstants.SHOOTER_LEFT_F);
		talonL.setCloseLoopRampRate(0.95);
		
		talonR = new CANTalon(StrongholdConstants.TALON_RIGHT_SHOOTER);
		talonR.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		talonR.changeControlMode(TalonControlMode.Speed);
		//Reverse output may be needed
//		talonR.configEncoderCodesPerRev(StrongholdConstants.ENCODER_TICKS_CPR);	
		talonR.configNominalOutputVoltage(+0.0f, -0.0f);
		talonR.setPID(StrongholdConstants.SHOOTER_RIGHT_P, StrongholdConstants.SHOOTER_RIGHT_I, StrongholdConstants.SHOOTER_RIGHT_D);
		talonR.setF(StrongholdConstants.SHOOTER_RIGHT_F);
		talonR.setCloseLoopRampRate(0.95);
		
		actuator = new CANTalon(StrongholdConstants.TALON_ACTUATOR);
		actuator.setFeedbackDevice(FeedbackDevice.AnalogPot);
		actuator.changeControlMode(TalonControlMode.Position);
		actuator.configNominalOutputVoltage(+0.0f, -0.0f);
		
		actuator.setPID(StrongholdConstants.ANGLE_MOTOR_DOWN_P, StrongholdConstants.ANGLE_MOTOR_DOWN_I, StrongholdConstants.ANGLE_MOTOR_DOWN_D
				, StrongholdConstants.ANGLE_MOTOR_DOWN_F, StrongholdConstants.ANGLE_MOTOR_DOWN_IZONE, StrongholdConstants.ANGLE_MOTOR_DOWN_RAMP_RATE, 
				StrongholdConstants.ANGLE_MOTOR_DOWN_PROFILE);
		
		actuator.setPID(StrongholdConstants.ANGLE_MOTOR_UP_P, StrongholdConstants.ANGLE_MOTOR_UP_I, StrongholdConstants.ANGLE_MOTOR_UP_D
				, StrongholdConstants.ANGLE_MOTOR_UP_F, StrongholdConstants.ANGLE_MOTOR_UP_IZONE, StrongholdConstants.ANGLE_MOTOR_UP_RAMP_RATE, 
				StrongholdConstants.ANGLE_MOTOR_UP_PROFILE);
	
		relay = new Relay(StrongholdConstants.SOLENOID_SHOOTER);
	}
	
	//Shoots the ball
	//Inputs: distance, low or high goal
	


//	public double getAngle(StrongholdConstants.shootOptions goal) {
//		return ShooterHelper.calculateAngle(goal);
//	}

//	public void fineTune(double sliderValue) {
//		sliderValue -= 0.008;
//
//		double adjustment = sliderValue * StrongholdConstants.TUNER_MULTIPLIER;
//
//		//Adjust actuator
//		changeAngle(ShooterHelper.calculateAngle(StrongholdRobot.shootOptionSelected));
//	}
	
//	public double fineTuneSpeed(double multiplier) {
//
//		double speed = (multiplier + 1)/2;
//		
//		return speed;
//	}
	
//	private double calculateSpeed(double angle, StrongholdConstants.shootOptions goal){
//		double speed;
//		//Theta is assumed to be 45 degrees.
//		speed = Math.pow(Math.sqrt(2 * Math.pow(ShooterHelper.getDistanceToGoal(goal), 2) - 5536), -4);
//		if (speed > 1) speed = 1;
//		else if (speed < 0.5) speed = 0.5;
//		return speed;
//	}
	
	//Changes the angle of the actuator
	public void changeAngle(double sliderVal) {

		double potTicks = StrongholdConstants.ACTUATOR_ARM_SLIDER_TO_POT_CONVERSION_FACTOR * 
								(sliderVal - StrongholdConstants.ACTUATOR_ARM_SLIDER_MIN) + 
								StrongholdConstants.ACTUATOR_ARM_UP_POT_FULLRANGE; 

//		if (encoderTicks < StrongholdConstants.ACTUATOR_ARM_POT_OPT_UP) {
//			encoderTicks = StrongholdConstants.ACTUATOR_ARM_POT_OPT_UP;
//		} else if (encoderTicks > StrongholdConstants.ACTUATOR_ARM_POT_OPT_DOWN) {
//			encoderTicks = StrongholdConstants.ACTUATOR_ARM_POT_OPT_DOWN;
//		}		
		
		if (potTicks > actuator.getPosition()) actuator.setProfile(StrongholdConstants.ANGLE_MOTOR_DOWN_PROFILE);
		else actuator.setProfile(StrongholdConstants.ANGLE_MOTOR_UP_PROFILE);
		
		SmartDashboard.putNumber("potTicks", potTicks);
		
		actuator.set(potTicks);

		SmartDashboard.putNumber("pot value: ", actuator.getPosition());

	}
	
	public void changeAngleAssisted(double angle) {
		//524 ticks = 0 degrees (real robot)
//		double angleToTicks = 524 - angle * 414.0 / 95.0;
		
//		819 ticks = 0 degrees (real robot)
		double angleToTicks = ShooterHelper.getAngleToTicks(angle);
		
		//Used for real robot
//		if (angleToTicks > 620) angleToTicks = 620;
//		else if (angleToTicks < 206) angleToTicks = 206;
		
		//Used in replica robot
		if (angleToTicks > StrongholdConstants.ACTUATOR_ARM_DOWN_POT_FULLRANGE) angleToTicks = StrongholdConstants.ACTUATOR_ARM_DOWN_POT_FULLRANGE;
		else if (angleToTicks < StrongholdConstants.ACTUATOR_ARM_UP_POT_FULLRANGE) angleToTicks = StrongholdConstants.ACTUATOR_ARM_UP_POT_FULLRANGE;
		//907 = -20degrees
		//570 = 57degrees
		
		if (angleToTicks > actuator.getPosition()) actuator.setProfile(StrongholdConstants.ANGLE_MOTOR_DOWN_PROFILE);
		else actuator.setProfile(StrongholdConstants.ANGLE_MOTOR_UP_PROFILE);
		actuator.setVoltageRampRate(0.05);
		actuator.set(angleToTicks);
	}
	
	public void intakeManual() {
		intake();
	}
	
	public void intakeAssisted() {
		actuator.setProfile(StrongholdConstants.ANGLE_MOTOR_DOWN_PROFILE);
		actuator.set(StrongholdConstants.ACTUATOR_ARM_DOWN_POT_FULLRANGE);
		intake();
	}
	
	private void intake() {
		talonR.changeControlMode(TalonControlMode.PercentVbus);
		talonL.changeControlMode(TalonControlMode.PercentVbus);
		talonR.set(0.5);
		talonL.set(-0.5);
	}
	
	public void stop() {
		talonR.set(StrongholdConstants.NO_THROTTLE);
		talonL.set(StrongholdConstants.NO_THROTTLE);
	}

	public void reverseShooter() {
		talonR.changeControlMode(TalonControlMode.Speed);
		talonL.changeControlMode(TalonControlMode.Speed);
		
		talonR.set(1000);
		talonL.set(-1000);
		Timer.delay(0.2);
		stop();
	}
	
	public void setShooterSpeed(double encoderSpeed) {
		talonR.changeControlMode(TalonControlMode.Speed);
		talonL.changeControlMode(TalonControlMode.Speed);
		
		talonR.set(-encoderSpeed);
		talonL.set(encoderSpeed);
	}

	//Used by autonomous/assisted mode
	public void shoot(double speedMultiplier) {
		_shoot(speedMultiplier);
	}
	
	public void shoot(double degrees, double speedMultiplier) {
		changeAngleAssisted(degrees);
		_shoot(speedMultiplier);
	}
	
	//Used by manual mode
	private void _shoot(double speedMultiplier) {
		
		talonR.changeControlMode(TalonControlMode.Speed);
		talonL.changeControlMode(TalonControlMode.Speed);
				
		boolean full_speed = false;
		
		//Direction of motor to be found out
		//P, I, D, F--->  0.02, 0, 1.65, 0
//		talonR.set(0.1 * StrongholdConstants.SHOOTER_MAX_SPEED); //* StrongholdConstants.VEL_PER_10MS
//		talonL.set(-0.1 * StrongholdConstants.SHOOTER_MAX_SPEED); //8465
//		
//		Timer.delay(0.2);
//		
//		stop();
//		
//		Timer.delay(0.5);
		
//		talonR.set(-StrongholdConstants.SHOOTER_MAX_SPEED * 0.25 * speedMultiplier); //* StrongholdConstants.VEL_PER_10MS
//		talonL.set(StrongholdConstants.SHOOTER_MAX_SPEED * 0.25 * speedMultiplier); //8465
//		talonR.set(-StrongholdConstants.SHOOTER_MAX_SPEED * speedMultiplier); //* StrongholdConstants.VEL_PER_10MS
//		talonL.set(StrongholdConstants.SHOOTER_MAX_SPEED * speedMultiplier); //8465
		
		System.out.println("Shooter TalonR/L Set VElocity : " + 10* StrongholdConstants.SHOOTER_MAX_SPEED * speedMultiplier);

		double timer = Timer.getFPGATimestamp();

		while (full_speed == false && (Timer.getFPGATimestamp() - timer) <= 3) {		
			if (Math.abs(talonR.getEncVelocity()) >= 10 * 0.95 * StrongholdConstants.SHOOTER_MAX_SPEED * speedMultiplier && 
					Math.abs(talonL.getEncVelocity()) >= 10 * 0.95 * StrongholdConstants.SHOOTER_MAX_SPEED * speedMultiplier) {
				full_speed = true;
//				System.out.println("Shooter Current FULL SPEED Velocity " + " R: " + talonR.getEncVelocity() + " L: " + talonL.getEncVelocity());
			} else {
//				System.out.println("Shooter Current Velocity " + " R: " + talonR.getEncVelocity() + " L: " + talonL.getEncVelocity());				
			}

		}
		
		SmartDashboard.putNumber("Enc1 vel:  ", talonR.getEncVelocity());
		SmartDashboard.putNumber("Enc2 vel:  ", talonL.getEncVelocity());
		
		relay.set(Relay.Value.kForward);
		
		Timer.delay(StrongholdConstants.SHOOT_DELAY2);
		stop();
		relay.set(Relay.Value.kOff);
		DSIO.shooterRunning = false;
		StrongholdRobot.shootCount ++;

	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
		
}