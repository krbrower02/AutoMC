package my.krbmod.automc.aisystem.actions.farmer;

import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
// Class to manage setup and harvesting of food
//
public class FarmingManager {

	public static final Actions thisAction = Actions.FARMER;

	// TODO Setup FarmingManager Fields
	private static int recipe = 0;

	public static void init(){
		//
		// TODO - For now we will assume only one init will be needed later we may need different Pre- and Post-Inits
		//

		// TODO Implement Farming Manager
		LogHelper.info("Farming Manager Initialization Started");
		registerCommands();
		LogHelper.info("Farming Manager Initialization Complete");

	}


	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "");
	}

	public static void refreshStatus() {
		//TODO - Get/Refresh Status of Manager
		
	}
	public String ACTION_FARM_BUILD = "Build Farm";
	public String ACTION_FARM_TILL = "Till Soil";
	public String ACTION_FARM_PLANT_WHEAT = "Plant Wheat";
	public String ACTION_FARM_PLANT_POTATOES = "Plant Potatoes";
	public String ACTION_FARM_PLANT_CARROTS = "Plant Carrots";
	public String ACTION_FARM_HARVEST = "Harvest";
	public String ACTION_FARM_HARVEST_GRASS = "Harvest Grass";

}
