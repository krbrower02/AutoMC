package my.krbmod.automc.aisystem.actions.farmer;

import my.krbmod.automc.aisystem.aihelpers.ActionPriority;
import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
// Class to manage setup and harvesting of food
//
public class FarmingManager {

	public static final Actions thisAction = Actions.FARMER;
	public static long lastChecked = System.currentTimeMillis();
	public static int defaultPriority = ActionPriority.PRIORITY_FARMER;
	public static int defaultTimer = ActionPriority.TIMER_FARMER;


	// TODO Setup remaining FarmingManager Fields
	private static int recipe = 0;

	public static void init(){
		//
		// TODO - For now we will assume everything can be done in Init; later we may need different Pre- and Post-Inits
		//

		// TODO Implement Farming Manager
		LogHelper.info("Farming Manager Initialization Started");
		
		registerCommands();
		lastChecked = 0; // this is the last time we checked the status; set to 0 so refreshStatus will always run the first time.

		LogHelper.info("Farming Manager Initialization Complete");

	}

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Build Tree Fram");
		CommandQueue.registerCommand(thisAction, "Build Vegetable Farm");
		CommandQueue.registerCommand(thisAction, "Build Sugar Cane Farm");
		CommandQueue.registerCommand(thisAction, "Build Cactus Farm");
		CommandQueue.registerCommand(thisAction, "Till Soil");
		CommandQueue.registerCommand(thisAction, "Plant Vegetables");
		CommandQueue.registerCommand(thisAction, "Plant Cactus");
		CommandQueue.registerCommand(thisAction, "Plant Sugar Cane");
		CommandQueue.registerCommand(thisAction, "Harvest Vegetables");
		CommandQueue.registerCommand(thisAction, "Harvest Cactus");
		CommandQueue.registerCommand(thisAction, "Harvest Sugar Cane");
		
	}

	public static void refreshStatus() {
		if ((System.currentTimeMillis() - lastChecked) >= defaultTimer) {
			//TODO - Get/Refresh Status of Manager
			LogHelper.info("Farming Manager Status Check");
			// the last thing we do is reset the timer
			lastChecked = System.currentTimeMillis();
		}
		// else we're not ready to check yet and we don't reset the timer
				
	}
	

}
