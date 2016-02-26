package my.krbmod.automc.aisystem.actions.lumberjack;

import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.aisystem.commandqueue.CommandQueueItem;
import my.krbmod.automc.utility.LogHelper;

//
// Class to manage woodcutting and tree farming in general
//
public class LumberManager {
	
	public static final Actions thisAction = Actions.LUMBERJACK;
	public static String name = thisAction.getName();
	public static int defaultPriority = thisAction.getPriority();
	public static long defaultTimer = thisAction.getTimer();

	public static long lastChecked = 0;

	// TODO Setup remaining Lumber Manager Fields
	private static int recipe = 0;

	public static void init(){
		//
		// TODO - For now we will assume everything can be done in Init; later we may need different Pre- and Post-Inits
		//
		
		// TODO Implement Lumber Manager
		LogHelper.info("Lumber Manager Initialization Started");
		
		registerCommands();
		lastChecked = 0; // this is the last time we checked the status; set to 0 so refreshStatus will always run the first time.

		LogHelper.info("Lumber Manager Initialization Complete");

	}

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Chop Tree");
		CommandQueue.registerCommand(thisAction, "Chop Leaves");
		CommandQueue.registerCommand(thisAction, "Plant Tree");
	}

	public static void refreshStatus() {
		if ((System.currentTimeMillis() - lastChecked) >= defaultTimer) {
			//TODO - Get/Refresh Status of Manager
			LogHelper.info("Lumber Manager Status Check");
			// the last thing we do is reset the timer
			lastChecked = System.currentTimeMillis();
		}
		// else we're not ready to check yet and we don't reset the timer
				

	}

	public static void run(){
		CommandQueueItem nextItem = CommandQueue.nextItem(thisAction);
	}
}
