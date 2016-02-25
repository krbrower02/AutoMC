package my.krbmod.automc.aisystem.actions.crafter;

import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
// Class to manage requests for crafted items, look up recipes, check inventory
//     request crafting task, etc.
//
public class CraftingManager {

	// TODO Setup CraftingManager Fields
	private static int crafting = 0;
	public static final Actions thisAction = Actions.CRAFTER;

	public static void init() {
		//
		// TODO - For now we will assume only one init will be needed later we
		// may need different Pre- and Post-Inits
		//

		// TODO Implement Crafting Manager
		LogHelper.info("Crafting Manager Initialization Started");
		registerCommands();
		RecipeManager.init();
		LogHelper.info("Crafting Manager Initialization Complete");

	}

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Craft");
	}

	public static void refreshStatus() {
		//TODO - Get/Refresh Status of Manager
		
	}

}
