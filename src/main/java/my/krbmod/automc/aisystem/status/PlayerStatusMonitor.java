package my.krbmod.automc.aisystem.status;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

import my.krbmod.automc.aisystem.aihelpers.MaterialLevel;

//
//Class to manage the current status of the player and to send alerts
//
public class PlayerStatusMonitor {

	private static MaterialLevel materialLevel = MaterialLevel.WOOD;
	private static PlayerHealth health;
	private static PlayerHunger hunger;
	private static ThreatLevel threat;
	private static ArmorClass armorClass;
	private static List<PlayerCondition> playerCondition; 

public PlayerStatusMonitor() {
	this.init();
}

public static void init() {
	materialLevel = MaterialLevel.WOOD;
	health = new PlayerHealth();
	hunger = new PlayerHunger();
	threat = new ThreatLevel();
	armorClass = new ArmorClass();
	// playerCondition = new ArrayList<PlayerCondition>;
}

public static MaterialLevel getMaterialLevel() {
	return materialLevel;
}

public static void setMaterialLevel(MaterialLevel m) {
	materialLevel = m;
}

}
