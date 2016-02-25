package my.krbmod.automc.aisystem.status;

import my.krbmod.automc.aisystem.AIReference;

//
//Class to manage base armor class and additional protections of player's armor 
//
public class PlayerArmorLevel {

	int maxLevel= AIReference.FULL_BASE_ARMOR;
	int currentLevel= AIReference.FULL_BASE_ARMOR;
	
	public PlayerArmorLevel() {
		maxLevel= AIReference.FULL_BASE_ARMOR;
		currentLevel = AIReference.FULL_BASE_ARMOR;
		
	}
	
	public int getLevel(){
		return currentLevel;
	}
	
	public int getMaxLevel(){
		return maxLevel;
	}

	public void setLevel(int level){
		currentLevel = level;
	}
	
	public void setMaxLevel(int level){
		maxLevel = level;
	}

	
}
