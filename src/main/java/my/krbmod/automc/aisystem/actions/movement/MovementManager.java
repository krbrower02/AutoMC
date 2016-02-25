package my.krbmod.automc.aisystem.actions.movement;

import my.krbmod.automc.aisystem.actions.movement.waypoints.WaypointManager;
import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
//Class to manage overall in-game movement
//
public class MovementManager {
	
	public static final Actions thisAction = Actions.MOVEMENT;

	// TODO Setup MovementManager Fields
	private static int mmovement = 0;
	
	public static void init(){
		//
		// TODO - For now we will assume only one init will be needed later we may need different Pre- and Post-Inits
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
		//TODO - Get/Refresh Status of Manager
		
	}

}
