package my.krbmod.automc.aisystem.status;

import my.krbmod.automc.aisystem.AIReference;

//
//Class to manage player's hunger level
//
public class PlayerFoodLevel {

	float maxLevel= AIReference.FULL_BASE_FOOD;
	float currentLevel= AIReference.FULL_BASE_FOOD;
	
	public PlayerFoodLevel() {
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
