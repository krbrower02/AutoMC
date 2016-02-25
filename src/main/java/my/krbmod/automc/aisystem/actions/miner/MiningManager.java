package my.krbmod.automc.aisystem.actions.miner;

import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
// Class to manage activities when in mining mode
//
public class MiningManager {
	
	public static final Actions thisAction = Actions.MINER;

	// TODO Setup MiningManager Fields
	private static int recipe = 0;

	public static void init(){
		//
		// TODO - For now we will assume only one init will be needed later we may need different Pre- and Post-Inits
		//

		// TODO Implement MiningManager
		LogHelper.info("Mining Manager Initialization Started");
		registerCommands();
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
		//TODO - Get/Refresh Status of Manager
		
	}

}
