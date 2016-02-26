package my.krbmod.automc.aisystem.actions.crafter;

import my.krbmod.automc.aisystem.aihelpers.ActionPriority;
import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
// Class to manage requests for crafted items, look up recipes, check inventory
//     request crafting task, etc.
//
public class CraftingManager {

	public static final Actions thisAction = Actions.CRAFTER;
	public static long lastChecked = System.currentTimeMillis();
	public static int defaultPriority = ActionPriority.PRIORITY_CRAFTER;
	public static int defaultTimer = ActionPriority.TIMER_CRAFTER;

	// TODO Setup remaining Crafting Manager Fields
	public static int crafting = 0;

	public static void init() {
		//
		// TODO - For now we will assume everything can be done in Init; later we may need different Pre- and Post-Inits
		//

		// TODO Implement Crafting Manager
		LogHelper.info("Crafting Manager Initialization Started");
		
		registerCommands();
		RecipeManager.init();
		lastChecked = 0; // this is the last time we checked the status; set to 0 so refreshStatus will always run the first time.

		LogHelper.info("Crafting Manager Initialization Complete");

	}

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Craft");
	}

	public static void refreshStatus() {
		if ((System.currentTimeMillis() - lastChecked) >= defaultTimer) {
			// TODO - Get/Refresh Status of Manager
			LogHelper.info("Crafting Manager Status Check");
			// the last thing we do is reset the timer
			lastChecked = System.currentTimeMillis();
		}
		// else we're not ready to check yet and we don't reset the timer

	}

}
