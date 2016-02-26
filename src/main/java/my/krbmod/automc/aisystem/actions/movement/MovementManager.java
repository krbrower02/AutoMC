package my.krbmod.automc.aisystem.actions.movement;

import my.krbmod.automc.aisystem.actions.movement.waypoints.WaypointManager;
import my.krbmod.automc.aisystem.aihelpers.ActionPriority;
import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
//Class to manage overall in-game movement
//
public class MovementManager {
	
	public static final Actions thisAction = Actions.MOVEMENT;
	public static long lastChecked = System.currentTimeMillis();
	public static int defaultPriority = ActionPriority.PRIORITY_MOVEMENT;
	public static int defaultTimer = ActionPriority.TIMER_MOVEMENT;
		
	// TODO Setup remaining Movement Manager Fields
	private static int mmovement = 0;
	
	public static void init(){
		//
		// TODO - For now we will assume everything can be done in Init; later we may need different Pre- and Post-Inits
		//

		// TODO Implement MovementManager
		LogHelper.info("Movement Manager Initialization Started");
		registerCommands();
		WaypointManager.init();
		AvoidanceManager.init();
		TrackingManager.init();
		LogHelper.info("Movement Manager Initialization Complete");

	}

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Avoid");
		CommandQueue.registerCommand(thisAction, "Track");
		CommandQueue.registerCommand(thisAction, "Flee");
		CommandQueue.registerCommand(thisAction, "Go To Waypoint");
		
	}

	public static void refreshStatus() {
		if ((System.currentTimeMillis() - lastChecked) >= defaultTimer) {
			//TODO - Get/Refresh Status of Manager
			LogHelper.info("Movement Manager Status Check");
			// the last thing we do is reset the timer
			lastChecked = System.currentTimeMillis();
		}
		// else we're not ready to check yet and we don't reset the timer
	}

}
