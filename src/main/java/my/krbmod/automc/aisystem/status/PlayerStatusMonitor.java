package my.krbmod.automc.aisystem.status;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

import my.krbmod.automc.aisystem.aihelpers.MaterialLevel;
import my.krbmod.automc.utility.LogHelper;

//
//Class to manage the current status of the player and to send alerts
//
public class PlayerStatusMonitor {

	private static MaterialLevel materialLevel = MaterialLevel.BAREHAND;
	private static PlayerDamageLevel health;
	private static PlayerFoodLevel hunger;
	private static ThreatLevel threat;
	private static PlayerArmorLevel armorClass;
	private static PlayerCondition playerCondition;
	// TODO - Implement list of player conditions, for testing we just have one
	//private static List<PlayerCondition> playerCondition; 

public PlayerStatusMonitor() {
	this.init();
}

public static void init() {
	//
	// TODO - For now we will assume only one init will be needed later we may need different Pre- and Post-Inits
	//
	LogHelper.info("Player Status Monitor Initialization Started");
	materialLevel = MaterialLevel.BAREHAND;
	health = new PlayerDamageLevel();
	hunger = new PlayerFoodLevel();
	threat = new ThreatLevel();
	armorClass = new PlayerArmorLevel();
	playerCondition = new PlayerCondition("Tired", "4:32");
	LogHelper.info("Player Condition:"+playerCondition.toString());
	// playerCondition = new ArrayList<PlayerCondition>;
	LogHelper.info("Player Status Monitor Initialization Complete");
	
}

public static MaterialLevel getMaterialLevel() {
	return materialLevel;
}

public static void setMaterialLevel(MaterialLevel m) {
	materialLevel = m;
}

}
