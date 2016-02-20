package org.usfirst.frc.team5422.navigator;


import edu.wpi.first.wpilibj.Notifier;

/*
 * @author Mayank
 */

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team5422.controller.StrongholdRobot;
import org.usfirst.frc.team5422.navigator.trapezoidal.TrapezoidThread;
import org.usfirst.frc.team5422.utils.StrongholdConstants;
import org.usfirst.frc.team5422.utils.StrongholdConstants.*;


public class Navigator extends Subsystem{

	private boolean isRunning;
	
	Notifier thread; 
	
	private int currentProfileID = 0;
	
	private NetworkTable netTable = NetworkTable.getTable("Trapezoid");
	
	public Navigator(){

		//right is Driver.talon[0].setFeedbackDevice(FeedbackDevice.QuadEncoder); [0]
		//left is Driver.talon[1].setFeedbackDevice(FeedbackDevice.QuadEncoder); [1]
		
		//Driver.talons[0] is right
		//Driver.talon[1] is left
		
		
		thread = new Notifier(new GlobalMapping());
		thread.startPeriodic(0.001);

		GlobalMapping.resetValues(0,0,Math.PI/2);
		
		
	}
	
	public double powerFromSpeed(Speed speed){
		double power = 0.0;
		
		switch(speed){
			case FAST:
				power = 0.5;
				break;
			case MEDIUM:
				power = 0.3;
				break;
			case SLOW:
				power = 0.1;
				break;
			default:
				power = 0.3;
				break;
		}
		
		return power;
	}
	
	
	
	private void StopRunning(){
		isRunning = false;
		
	}
	
	private boolean Running() {
		return isRunning;
	}

	public void trapWheelTicks(double rTicks, double lTicks, double lVelRPM, double rVelRPM, int tableID){
		//dummy function (actually written elsewhere by aditya)
		
		StrongholdRobot.driver.moveTrapezoid((int)lTicks, (int)rTicks, lVelRPM, rVelRPM, tableID);
		
	}
	
	public void speedWheelTicks(double rTicks, double lTicks, double lVelRPM, double rVelRPM){
		
		Driver.talon[0].set(Math.signum(rTicks)*0.4);
		Driver.talon[1].set(-Math.signum(lTicks)*0.4);
		
	}
	
	private void rotateToTheta(double theta, double rpmR, double rpmL){
		
		theta = GlobalMapping.reduceRadiansUtil(theta);
		
		double relInitTheta = theta - GlobalMapping.getTheta();
		
		if(relInitTheta > Math.PI){
			relInitTheta -= 2*Math.PI;
		}else if(relInitTheta < -Math.PI){
			relInitTheta += 2*Math.PI;
		}
		
		System.out.format("[GP][robot at] (%4.3g, %4.3g) @ %4.3g (in)\n", GlobalMapping.getX(), GlobalMapping.getY(), GlobalMapping.getTheta());
		System.out.format("[GP][rotate to] %4.3g [rotate by] %4.3g (rad)\n", theta, relInitTheta );
		
		
		double lTicksDest = -StrongholdConstants.WHEEL_BASE/2*relInitTheta/StrongholdConstants.INCHES_PER_TICK;
		double rTicksDest = StrongholdConstants.WHEEL_BASE/2*relInitTheta/StrongholdConstants.INCHES_PER_TICK;
		
		
		
		trapWheelTicks(rTicksDest, lTicksDest, rpmR, rpmL, currentProfileID);
		
		
		isRunning = true;
		
		while(Running()){
			
			if(netTable.getString("Trap Status", "running").equals("finished")){
				currentProfileID+=1;
				StrongholdRobot.driver.stopTrapezoid();
				StopRunning();
			}
			
		}
	}
	
	public void moveByDistance(double targDistance, double rps){
		
		System.out.format("[GP][robot at] (%4.3g, %4.3g) @ %4.3g (in)\n", GlobalMapping.getX(), GlobalMapping.getY(), GlobalMapping.getTheta());
		System.out.format("[GP][translate by] %.3g (in)\n", targDistance );
		
		double tickDist = targDistance/StrongholdConstants.INCHES_PER_TICK;
		
		
		trapWheelTicks(tickDist, tickDist, rps, rps, currentProfileID);
		 
		
		isRunning = true;
		
		while(Running()){
			
			if(netTable.getString("Trap Status", "running").equals("finished")){
				currentProfileID+=1;
				StrongholdRobot.driver.stopTrapezoid();
				StopRunning();
			}
			
		}
	}
	
	
	/**
	 * This function helps drive the robot to precise coordinates on the field 
	 */
	//TODO: Modularization
	public void driveTo(double xField, double yField, double thetaField){
		
		double xRel = xField - GlobalMapping.getX();
		double yRel = yField - GlobalMapping.getY();
		
		double targInitTheta = GlobalMapping.reduceRadiansUtil(Math.atan2(yRel, xRel));
		
		double rps = 3;
		
		rotateToTheta(targInitTheta, rps, rps);
		
		double targDistance = Math.sqrt(xRel*xRel + yRel*yRel);
		
		moveByDistance(targDistance, rps);
		
		thetaField = GlobalMapping.reduceRadiansUtil(thetaField);
		
		rotateToTheta(thetaField, rps, rps);
		
	}
	
	public void driveTo(double xField, double yField){
		
		double xRel = xField - GlobalMapping.getX();
		double yRel = yField - GlobalMapping.getY();
		
		double targInitTheta = Math.atan2(yRel, xRel);
		
		if(targInitTheta < 0){
			targInitTheta+=2*Math.PI;
		}
		
		double rps = 3;
		
		rotateToTheta(targInitTheta, rps, rps);
		
		double targDistance = Math.sqrt(xRel*xRel + yRel*yRel);
		
		moveByDistance(targDistance, rps);
		
	}
	
	public void turnTo(double thetaField){
		
		double rps = 3;
		
		thetaField = GlobalMapping.reduceRadiansUtil(thetaField);
		
		rotateToTheta(thetaField, rps, rps);
		
	}
	
	public void turnTo(double xField, double yField){
		double xRel = xField - GlobalMapping.getX();
		double yRel = yField - GlobalMapping.getY();
		
		double targInitTheta = GlobalMapping.reduceRadiansUtil(Math.atan2(yRel, xRel));
		
		double rps = 3;
		
		rotateToTheta(targInitTheta, rps, rps);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	
}//end of class
