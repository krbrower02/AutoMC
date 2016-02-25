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

	// TODO Setup Exploration Manager Fields
	// TODO Setup Surface and Subsurface exploration
	//
	private static int recipe = 0;

	public static void init(){
		//
		// TODO - For now we will assume only one init will be needed later we may need different Pre- and Post-Inits
		//

		// TODO Implement Exploration Managerr
		LogHelper.info("Exploration Manager Initialization Started");
		registerCommands();
		LogHelper.info("Exploration Manager Initialization Complete");
	}


	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Explore Surface");
		CommandQueue.registerCommand(thisAction, "Explore Mines");
		CommandQueue.registerCommand(thisAction, "Explore Hills");
	}

	public static void refreshStatus() {
		//TODO - Get/Refresh Status of Manager
		
	}
	

}
