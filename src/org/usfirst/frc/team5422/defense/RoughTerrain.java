package org.usfirst.frc.team5422.defense;

import org.usfirst.frc.team5422.utils.StrongholdConstants.defenseTypeOptions;
import org.usfirst.frc.team5422.utils.StrongholdConstants.shootOptions;

/*
 * @author Michael
 */

public class RoughTerrain implements Defense {
	public RoughTerrain(defenseTypeOptions defenseType, int defensePosition) {
		
	}

	@Override
	public void align(defenseTypeOptions defenseType, int defensePosition) {
		System.out.println("Aligning the Robot to the Rough Terrain defense at " + defensePosition);
		// TODO Auto-generated method stub, defensePositionOptions defensePosition

	}

	@Override
	public void reach(defenseTypeOptions defenseType, int defensePosition) {
		System.out.println("Robot needs the source and destination coordinates as parameters to reach RoughTerrain defense..." + defensePosition);
		System.out.println("Robot Reaching the RoughTerrain defense at " + defensePosition);
		// TODO Auto-generated method stub

	}
	@Override
	public void cross(defenseTypeOptions defenseType, int defensePosition) {
		System.out.println("Robot crossing the RoughTerrain defense at " + defensePosition);
		// TODO Auto-generated method stub

	}

	@Override
	public void positionToShoot(defenseTypeOptions defenseType, int defensePosition, shootOptions shootOption) {
		System.out.println("Robot positioning to shoot after crossing the RoughTerrain defense at " + defensePosition + " shooting into " + shootOption);
		// TODO Auto-generated method stub

	}

}
