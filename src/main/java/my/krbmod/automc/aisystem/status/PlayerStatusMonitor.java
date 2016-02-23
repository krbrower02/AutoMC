package my.krbmod.automc.aisystem.status;

import my.krbmod.automc.aisystem.aihelpers.MaterialLevel;

//
//Class to manage the current status of the player and to send alerts
//
public class PlayerStatusMonitor {
private static MaterialLevel materialLevel = MaterialLevel.WOOD;

public PlayerStatusMonitor() {
	this.init();
}

public static void init() {
	materialLevel = MaterialLevel.WOOD;
}

public static MaterialLevel getMaterialLevel() {
	return materialLevel;
}

public static void setMaterialLevel(MaterialLevel m) {
	materialLevel = m;
}

}
