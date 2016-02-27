package org.usfirst.frc.team5422.navigator;

import org.usfirst.frc.team5422.DSIO.DSIO;
import org.usfirst.frc.team5422.navigator.trapezoidal.TrapezoidThread;
import org.usfirst.frc.team5422.utils.ConfigureRobot;
import org.usfirst.frc.team5422.utils.StrongholdConstants;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public abstract class Driver implements DriverInterface {

    protected static CANTalon masterTalon[] = new CANTalon[2];
    protected TrapezoidThread trapThread;
	public ConfigureRobot configureRobot;
 
	public Driver() {
		// TODO Auto-generated constructor stub
	}


    /**
     * This function drives the robot around the carpet. It is not precise.
     */
    @Override
    public void openDrive(double yJoystick, double xJoystick, CANTalon.TalonControlMode controlMode) {
        //Declare variables
        double velocityLeft = 0, velocityRight = 0;

        //Declare talons
        if (controlMode == CANTalon.TalonControlMode.Speed | controlMode == CANTalon.TalonControlMode.PercentVbus) {
           // masterTalon[0].reverseOutput(true);
            for (int i = 0; i < 2; i++) {
                masterTalon[i].changeControlMode(controlMode);
                masterTalon[i].setPID(StrongholdConstants.OPEN_DRIVE_P, StrongholdConstants.OPEN_DRIVE_I, StrongholdConstants.OPEN_DRIVE_D);
                masterTalon[i].setF(StrongholdConstants.OPEN_DRIVE_F);
            }
        } else {
            System.out.println("Invalid Talon Control Mode, set the talon in Speed mode or PercentVbus mode");
        }

        //Calculate velocities
        ArcadeDrive.arcadeDrive(xJoystick, yJoystick);
        
        //OLD LINE: velocityRight = ArcadeDrive.arcadeDriveRight() * 0.5; 
        velocityLeft = ArcadeDrive.arcadeDriveLeft();
        velocityRight = ArcadeDrive.arcadeDriveRight() * -1;

        //Set the velocity of the talons
        if (controlMode == CANTalon.TalonControlMode.Speed | controlMode == CANTalon.TalonControlMode.PercentVbus) {
            if (controlMode == CANTalon.TalonControlMode.Speed) {
                masterTalon[0].set(velocityLeft * 81.92 * 0.5);
            } else masterTalon[0].set(velocityLeft);

            if (controlMode == CANTalon.TalonControlMode.Speed) {
                masterTalon[1].set(velocityRight * 81.92 * 0.5);
            } else masterTalon[1].set(velocityRight);
        } else {
            System.out.println("Invalid Talon Control Mode, set the master talons in Speed mode or PercentVbus mode");
        }
       
        //Output to SmartDashboard for diagnostics

        DSIO.outputToSFX("velocityLeft", velocityLeft);
        DSIO.outputToSFX("velocityRight", velocityRight);

        //Current being put through the talons
        DSIO.outputToSFX("Talon ID 3 Current (Right)", masterTalon[0].getOutputCurrent());
        DSIO.outputToSFX("Talon ID 0 Current (Right)", masterTalon[1].getOutputCurrent());

        //Talon speeds
        DSIO.outputToSFX("Talon ID 3 Velocity (Right)", masterTalon[0].getSpeed());
        DSIO.outputToSFX("Talon ID 0 Velocity (Right)", masterTalon[1].getSpeed());
    }

    @Override
    public void moveTrapezoid(int leftTicks, int rightTicks, double leftVelocity, double rightVelocity, int tableID) {	
		trapThread.activateTrap(-1 * leftTicks, rightTicks, leftVelocity, rightVelocity, tableID);
	}

    @Override
    public void stopTrapezoid() {
    	trapThread.resetTrapezoid();
    }

	@Override
    public CANTalon getDriveTalonLeftMaster() {
    	return masterTalon[0];
    }

	@Override
    public CANTalon getDriveTalonRightMaster() {
    	return masterTalon[1];
    }

}
