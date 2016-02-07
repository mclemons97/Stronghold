package org.usfirst.frc.team5422.commands;

import org.usfirst.frc.team5422.controller.StrongholdRobot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PositionToShootCommand extends DefenseCommand {

    public PositionToShootCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super();
    	requires(StrongholdRobot.navigatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("[AutoComm] Robot moving to position to shoot...");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[AutoComm] Robot in position to shoot");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
