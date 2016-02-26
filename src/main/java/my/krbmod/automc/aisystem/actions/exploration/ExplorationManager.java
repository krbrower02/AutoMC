package my.krbmod.automc.aisystem.actions.exploration;

import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
// Class to manage exploration of the world, will be split into surface and subsurface and potentially others in the future
//
public class ExplorationManager {
	//
	public static final Actions thisAction = Actions.EXPLORATION;
	public static String name = thisAction.getName();
	public static int defaultPriority = thisAction.getPriority();
	public static long defaultTimer = thisAction.getTimer();
	public static long lastChecked = 0;

	// TODO Setup remaining Exploration Manager Fields
	//
	// TODO Setup Surface and Subsurface exploration
	//
	private static int recipe = 0;

	public static void init() {
		//
		// TODO - For now we will assume everything can be done in Init; later
		// we may need different Pre- and Post-Inits
		//

		// TODO Implement Exploration Manager
		LogHelper.info("Exploration Manager Initialization Started");

		registerCommands();
		lastChecked = 0; // this is the last time we checked the status; set to
							// 0 so refreshStatus will always run the first
							// time.

		LogHelper.info("Exploration Manager Initialization Complete");
	}

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Explore Surface");
		CommandQueue.registerCommand(thisAction, "Explore Mines");
		CommandQueue.registerCommand(thisAction, "Explore Hills");
	}

	public static void refreshStatus() {
		if ((System.currentTimeMillis() - lastChecked) >= defaultTimer) {
			// TODO - Get/Refresh Status of Manager
			LogHelper.info("Exploration Manager Status Check");
			// the last thing we do is reset the timer
			lastChecked = System.currentTimeMillis();
		}
		// else we're not ready to check yet and we don't reset the timer

	}

}
