package my.krbmod.automc.aisystem.actions.combat;

import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.aihelpers.CombatStatus;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
// Class to manage combat either planned or unplanned
//

public class CombatManager {

	private static CombatStatus combatStatus;
	public static final Actions thisAction = Actions.COMBAT;

	// TODO Setup Combat Manager Fields

	public static void init(){
		//
		// TODO - For now we will assume only one init will be needed later we may need different Pre- and Post-Inits

		LogHelper.info("Combat Manager Initialization Started");
		registerCommands();
		combatStatus = CombatStatus.IDLE;
		
		LogHelper.info("Combat Manager Initialization Complete");
	}

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Attack");
		CommandQueue.registerCommand(thisAction, "Defend");
	}

	public static void refreshStatus() {
		//TODO - Get/Refresh Status of Manager
		
	}

	//
	// TODO Implement Combat Manager
	//

}
