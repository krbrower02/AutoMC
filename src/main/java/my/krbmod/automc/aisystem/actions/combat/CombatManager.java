package my.krbmod.automc.aisystem.actions.combat;

import my.krbmod.automc.aisystem.aihelpers.ActionPriority;
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
	public static long lastChecked = System.currentTimeMillis();
	public static int defaultPriority = ActionPriority.PRIORITY_COMBAT;
	public static int defaultTimer = ActionPriority.TIMER_COMBAT;


	// TODO Setup remaining Combat Manager Fields

	public static void init(){
		//
		// TODO - For now we will assume everything can be done in Init; later we may need different Pre- and Post-Inits
		//
		
		LogHelper.info("Combat Manager Initialization Started");
		
		registerCommands();
		lastChecked = 0; // this is the last time we checked the status; set to 0 so refreshStatus will always run the first time.

		combatStatus = CombatStatus.IDLE;
		
		LogHelper.info("Combat Manager Initialization Complete");
	}

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Attack");
		CommandQueue.registerCommand(thisAction, "Defend");
	}

	public static void refreshStatus() {
		if ((System.currentTimeMillis() - lastChecked) >= defaultTimer) {
			//TODO - Get/Refresh Status of Manager
			LogHelper.info("Combat Manager Status Check");
			// the last thing we do is reset the timer
			lastChecked = System.currentTimeMillis();
		}
		// else we're not ready to check yet and we don't reset the timer
				
	}

	//
	// TODO Implement Combat Manager
	//

}
