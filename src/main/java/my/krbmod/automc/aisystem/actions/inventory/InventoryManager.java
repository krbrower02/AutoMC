package my.krbmod.automc.aisystem.actions.inventory;

import my.krbmod.automc.aisystem.actions.inventory.InventoryGoal;
import my.krbmod.automc.aisystem.actions.inventory.support.InventoryGoals;
import my.krbmod.automc.aisystem.aihelpers.ActionPriority;
import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.aihelpers.CombatStatus;
import my.krbmod.automc.aisystem.aihelpers.MaterialLevel;
import my.krbmod.automc.aisystem.commandqueue.CommandItem;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

public class InventoryManager {

	public static final Actions thisAction = Actions.INVENTORY;
	public static InventoryGoals inventoryGoals = new InventoryGoals();
	public static long lastChecked = System.currentTimeMillis();
	public static int defaultPriority = ActionPriority.PRIORITY_INVENTORY;
	public static int defaultTimer = ActionPriority.TIMER_INVENTORY;

	// TODO Setup remaining Inventory Manager Fields
	private static int inventory = 0;

	public static void init() {
		//
		// TODO - For now we will assume everything can be done in Init; later we may need different Pre- and Post-Inits
		//
		LogHelper.info("Inventory Manager Initialization Started");
		
		registerCommands();
		lastChecked = 0; // this is the last time we checked the status; set to 0 so refreshStatus will always run the first time.

		LogHelper.info("Inventory Manager Initialization Complete");

	}

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Equipped");
		CommandQueue.registerCommand(thisAction, "In Hot Bar");
		CommandQueue.registerCommand(thisAction, "In Personal Inventory");
		CommandQueue.registerCommand(thisAction, "In Inventory");
	}

	public static void refreshStatus() {
		if ((System.currentTimeMillis() - lastChecked) >= defaultTimer) {
			// TODO - Get/Refresh Status of Manager
			LogHelper.info("Inventory Manager Status Check");
			// the last thing we do is reset the timer
			lastChecked = System.currentTimeMillis();
		}
		// else we're not ready to check yet and we don't reset the timer

	}

	//
	// TODO Implement Inventory Manager Commands

}
