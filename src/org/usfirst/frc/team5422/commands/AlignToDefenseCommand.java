package org.usfirst.frc.team5422.commands;

import org.usfirst.frc.team5422.controller.StrongholdRobot;
import org.usfirst.frc.team5422.utils.StrongholdConstants;
import org.usfirst.frc.team5422.utils.StrongholdConstants.defenseOptions;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignToDefenseCommand extends Command {

    public AlignToDefenseCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // Use requires() here to declare subsystem dependencies
        requires(StrongholdRobot.navigatorSubsystem);
        
        defenseOptions defense = (defenseOptions) StrongholdRobot.dsio.defenseChooser.getSelected(); 
        
        if(defense == defenseOptions.CHIVAL_DE_FRISE){
        
        }else if(defense == defenseOptions.DRAWBRIDGE){
        	
        }else if(defense == defenseOptions.LOW_BAR){
        	
        }else if(defense == defenseOptions.MOAT){
        	
        }else if(defense == defenseOptions.PORTCULLIS){
        	
        }
        
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("[AutoComm] Robot aligning to shoot...");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[AutoComm] Robot aligned to shoot");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
