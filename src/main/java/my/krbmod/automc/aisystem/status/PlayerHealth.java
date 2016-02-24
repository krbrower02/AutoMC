package my.krbmod.automc.aisystem.status;

import my.krbmod.automc.aisystem.AIReference;

//
//Class to manage player's health: total, actual, regen rate, etc. 
//
public class PlayerHealth {

	float maxLevel= AIReference.FULL_BASE_HEALTH;
	float currentLevel= AIReference.FULL_BASE_HEALTH;
	
	public PlayerHealth() {
		maxLevel= AIReference.FULL_BASE_HEALTH;
		currentLevel = AIReference.FULL_BASE_HEALTH;
		
	}
	
	public float getLevel(){
		return currentLevel;
	}
	
	public float getMaxLevel(){
		return maxLevel;
	}

	public void setLevel(float level){
		currentLevel = level;
	}
	
	public void setMaxLevel(float level){
		maxLevel = level;
	}
}
