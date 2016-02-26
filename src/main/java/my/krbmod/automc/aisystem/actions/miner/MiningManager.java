package my.krbmod.automc.aisystem.actions.miner;

import my.krbmod.automc.aisystem.aihelpers.ActionPriority;
import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
// Class to manage activities when in mining mode
//
public class MiningManager {
	
	public static final Actions thisAction = Actions.MINER;
	public static long lastChecked = System.currentTimeMillis();
	public static int defaultPriority = ActionPriority.PRIORITY_MINER;
	public static int defaultTimer = ActionPriority.TIMER_MINER;

	// TODO Setup remaining Mining Manager Fields
	private static int recipe = 0;

	public static void init(){
		//
		// TODO - For now we will assume everything can be done in Init; later we may need different Pre- and Post-Inits
		//

		// TODO Implement MiningManager
		LogHelper.info("Mining Manager Initialization Started");
		
		registerCommands();
		lastChecked = 0; // this is the last time we checked the status; set to 0 so refreshStatus will always run the first time.

		LogHelper.info("Mining Manager Initialization Complete");

	}


	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Dig Shaft");
		CommandQueue.registerCommand(thisAction, "Dig Stairs");
		CommandQueue.registerCommand(thisAction, "Dig Mine");
		CommandQueue.registerCommand(thisAction, "Mine Ore");
	}

	public static void refreshStatus() {
		if ((System.currentTimeMillis() - lastChecked) >= defaultTimer) {
			//TODO - Get/Refresh Status of Manager
			LogHelper.info("Mining Manager Status Check");
			// the last thing we do is reset the timer
			lastChecked = System.currentTimeMillis();
		}
		// else we're not ready to check yet and we don't reset the timer
	}

}
