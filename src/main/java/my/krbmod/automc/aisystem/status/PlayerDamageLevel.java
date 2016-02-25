package my.krbmod.automc.aisystem.status;

import my.krbmod.automc.aisystem.AIReference;

//
//Class to manage player's health: total, actual, regen rate, etc. 
//
public class PlayerDamageLevel {

	float maxLevel= AIReference.FULL_BASE_FOOD;
	float currentLevel= AIReference.FULL_BASE_FOOD;
	
	public PlayerDamageLevel() {
		maxLevel= AIReference.FULL_BASE_FOOD;
		currentLevel = AIReference.FULL_BASE_FOOD;
		
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
