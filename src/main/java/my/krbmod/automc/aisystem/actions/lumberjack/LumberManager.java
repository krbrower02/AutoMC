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

	// TODO Setup LumberManager Fields
	private static int recipe = 0;

	public static void init(){
		//
		// TODO - For now we will assume only one init will be needed later we may need different Pre- and Post-Inits
		//
		
		// TODO Implement LumberManager
		LogHelper.info("Lumber Manager Initialization Started");
		registerCommands();
		LogHelper.info("Lumber Manager Initialization Complete");

	}

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Chop Tree");
		CommandQueue.registerCommand(thisAction, "Chop Leaves");
		CommandQueue.registerCommand(thisAction, "Plant Tree");
	}

	public static void refreshStatus() {
		//TODO - Get/Refresh Status of Manager
		
	}

	public static void run(){
		CommandQueueItem nextItem = CommandQueue.nextItem(thisAction);
	}
}
