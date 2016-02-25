package my.krbmod.automc.aisystem;

import my.krbmod.automc.aisystem.actions.combat.CombatManager;
import my.krbmod.automc.aisystem.actions.crafter.CraftingManager;
import my.krbmod.automc.aisystem.actions.crafter.RecipeManager;
import my.krbmod.automc.aisystem.actions.exploration.ExplorationManager;
import my.krbmod.automc.aisystem.actions.farmer.FarmingManager;
import my.krbmod.automc.aisystem.actions.inventory.InventoryManager;
import my.krbmod.automc.aisystem.actions.lumberjack.LumberManager;
import my.krbmod.automc.aisystem.actions.miner.MiningManager;
import my.krbmod.automc.aisystem.actions.movement.AvoidanceManager;
import my.krbmod.automc.aisystem.actions.movement.MovementManager;
import my.krbmod.automc.aisystem.actions.movement.TrackingManager;
import my.krbmod.automc.aisystem.actions.movement.waypoints.WaypointManager;
import my.krbmod.automc.aisystem.actions.terraformer.TerraformManager;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.aisystem.goals.GoalManager;
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
		CommandQueue.init();
		GoalManager.init();
		//
		// Start with category order then we will reorder and move above this line as we implement dependencies
		//
		CombatManager.init();
		CraftingManager.init();
		ExplorationManager.init();
		FarmingManager.init();
		InventoryManager.init();
		LumberManager.init();
		MiningManager.init();
		MovementManager.init();
		TerraformManager.init();
		
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
