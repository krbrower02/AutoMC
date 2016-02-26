package my.krbmod.automc.aisystem.actions.inventory;

import java.util.ArrayList;

import my.krbmod.automc.aisystem.actions.inventory.support.InventoryGoal;
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
	public static ArrayList<InventoryGoal> inventoryGoalList = new ArrayList<InventoryGoal>();

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
		InventoryGoals.addInventoryGoals();
		
		lastChecked = 0; // this is the last time we checked the status; set to 0 so refreshStatus will always run the first time.

		LogHelper.info("Inventory Manager Initialization Complete");

	}

	//
	// Allow inventory manager to add goals dynamically either with or without quantity on-hand.
	//
	//public static void addGoal(MaterialLevel mlevel, String item, int quantity) {
	//	inventoryGoalList.add(new InventoryGoal(mlevel, item, quantity, 0));
	//}

	public static void addGoal(MaterialLevel mlevel, String item, int quantity, int onHand) {
		//inventoryGoalList.add(new InventoryGoal(mlevel, item, quantity, onHand));
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

}
