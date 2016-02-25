package my.krbmod.automc.aisystem;

import my.krbmod.automc.aisystem.actions.crafting.CraftingManager;
import my.krbmod.automc.aisystem.actions.crafting.RecipeManager;
import my.krbmod.automc.aisystem.actions.farming.FarmingManager;
import my.krbmod.automc.aisystem.actions.lumber.LumberManager;
import my.krbmod.automc.aisystem.actions.mining.MiningManager;
import my.krbmod.automc.aisystem.actions.terraforming.TerraformManager;
import my.krbmod.automc.aisystem.goals.GoalManager;
import my.krbmod.automc.aisystem.inventory.InventoryManager;
import my.krbmod.automc.aisystem.movement.AvoidanceManager;
import my.krbmod.automc.aisystem.movement.MovementManager;
import my.krbmod.automc.aisystem.movement.TrackingManager;
import my.krbmod.automc.aisystem.movement.waypoints.WaypointManager;
import my.krbmod.automc.aisystem.priorityqueue.PriorityQueue;
import my.krbmod.automc.aisystem.status.PlayerStatusMonitor;
import my.krbmod.automc.utility.LogHelper;

public class AISystem {

	public static String aiSystemState = AIReference.AI_STATE_IDLE;

	public static void preInit(){
		LogHelper.info("AI Pre-Initialization Started");

		aiSystemState = AIReference.AI_STATE_PREINIT;
		//
		// TODO determine which managers kick off in preInit.
		//
		aiSystemState = AIReference.AI_STATE_IDLE;
		
		LogHelper.info("AI Pre-Initialization Complete");
	}
	
	public static void Init(){
		LogHelper.info("AI Initialization Started");
		
		aiSystemState = AIReference.AI_STATE_INIT;
		//
		// TODO determine which managers kick off in Init.
		//
		// For now we will assume they all activate in Init.
		//
		PlayerStatusMonitor.init();
		PriorityQueue.init();
		GoalManager.init();
		//
		// Start with category order then we will reorder and move above this line as we implement dependencies
		//
		CraftingManager.init();
		RecipeManager.init();
		FarmingManager.init();
		LumberManager.init();
		MiningManager.init();
		TerraformManager.init();
		InventoryManager.init();
		WaypointManager.init();
		AvoidanceManager.init();
		MovementManager.init();
		TrackingManager.init();
		MovementManager.init();
		
		aiSystemState = AIReference.AI_STATE_IDLE;
		
		LogHelper.info("AI Initialization Complete");
	}
	
	public static void postInit(){
		LogHelper.info("AI Post-Initialization Started");

		aiSystemState = AIReference.AI_STATE_POSTINIT;
		// 
		// TODO determine which managers kick off in postInit.
		//
		
		aiSystemState = AIReference.AI_STATE_IDLE;
		LogHelper.info("AI Post-Initialization Complete");
	}
	
	public String getState(){
		return aiSystemState;
	}
}
