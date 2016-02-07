package org.usfirst.frc.team5422.commands;

import org.usfirst.frc.team5422.controller.StrongholdRobot;
import org.usfirst.frc.team5422.defense.Defense;
import org.usfirst.frc.team5422.defense.LowBar;
import org.usfirst.frc.team5422.defense.Moat;
import org.usfirst.frc.team5422.defense.Ramparts;
import org.usfirst.frc.team5422.defense.RockWall;
import org.usfirst.frc.team5422.defense.RoughTerrain;
import org.usfirst.frc.team5422.utils.StrongholdConstants.defensePositionOptions;
import org.usfirst.frc.team5422.utils.StrongholdConstants.defenseTypeOptions;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DefenseCommand extends Command {
	protected defenseTypeOptions defenseTypeSelected;
	protected defensePositionOptions defensePositionSelected;
	protected Defense defense;

    public DefenseCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        defenseTypeSelected = (defenseTypeOptions) StrongholdRobot.dsio.defenseChooser.getSelected(); 
        defensePositionSelected = (defensePositionOptions) StrongholdRobot.dsio.defensePositionChooser.getSelected();
        
        switch(defenseTypeSelected){
        	case CHIVAL_DE_FRISE:
        		defense = null;
        		break;
        	case LOW_BAR:
        		defense = new LowBar(defenseTypeSelected, defensePositionSelected); 
        		break;
        		
        	case MOAT:
        		defense = new Moat(defenseTypeSelected, defensePositionSelected); 
        		break;
        		
        	case PORTCULLIS:
        		defense = null;
        		break;
        		
        	case RAMPARTS:
        		defense = new Ramparts(defenseTypeSelected, defensePositionSelected); 
        		break;
        		
        	case ROCK_WALL:
        		defense = new RockWall(defenseTypeSelected, defensePositionSelected); 
        		break;
        		
        	case ROUGH_TERRAIN:
        		defense = new RoughTerrain(defenseTypeSelected, defensePositionSelected); 
        		break;
        		
        	case SALLYPORT:
        		defense = null;
        		break;
        	
        	case NONE:
        		defense = null;
        		break;
        		
        	default:
        		defense = null;
        		break;
        }
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
