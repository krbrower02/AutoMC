package my.krbmod.automc.aisystem.status;

import my.krbmod.automc.aisystem.AIReference;

//
//Class to manage player's hunger level
//
public class PlayerHunger {

	float maxLevel= AIReference.FULL_HUNGER;
	float currentLevel= AIReference.FULL_HUNGER;
	
	public PlayerHunger() {
		maxLevel= AIReference.FULL_HUNGER;
		currentLevel = AIReference.FULL_HUNGER;
		
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
