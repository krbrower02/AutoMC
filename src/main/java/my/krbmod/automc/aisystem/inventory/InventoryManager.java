package my.krbmod.automc.aisystem.inventory;

import my.krbmod.automc.aisystem.actions.actionhelpers.ActionCommands;
import my.krbmod.automc.aisystem.actions.actionhelpers.Actions;
import my.krbmod.automc.aisystem.aihelpers.MaterialLevel;
import my.krbmod.automc.aisystem.inventory.InventoryGoal;

public class InventoryManager {
	private InventoryGoal[] inventoryGoalList = new InventoryGoal[] {
			new InventoryGoal(MaterialLevel.DEFAULT, "None", 0, 0),
			new InventoryGoal(MaterialLevel.WOOD, "Wood Block", 10, 0),
			new InventoryGoal(MaterialLevel.WOOD, "Wood Plank", 10, 0),
			new InventoryGoal(MaterialLevel.WOOD, "Stick", 10, 0),
			new InventoryGoal(MaterialLevel.WOOD, "Wood Axe", 1, 0),
			new InventoryGoal(MaterialLevel.WOOD, "Wood Pick", 1, 0),
			new InventoryGoal(MaterialLevel.STONE, "Wood Block", 20, 0),
			new InventoryGoal(MaterialLevel.STONE, "Wood Plank", 20, 0),
			new InventoryGoal(MaterialLevel.STONE, "Stick", 20, 0),
			new InventoryGoal(MaterialLevel.STONE, "Cobble Stone", 20, 0),
			new InventoryGoal(MaterialLevel.STONE, "Coal", 10, 0),
			new InventoryGoal(MaterialLevel.STONE, "Torch", 10, 0),
			new InventoryGoal(MaterialLevel.STONE, "Stone Axe", 2, 0),
			new InventoryGoal(MaterialLevel.STONE, "Stone Pick", 2, 0),
			new InventoryGoal(MaterialLevel.STONE, "Stone Shovel", 2, 0),
			new InventoryGoal(MaterialLevel.STONE, "Stone Hoe", 2, 0),
			new InventoryGoal(MaterialLevel.IRON, "Wood Block", 40, 0),
			new InventoryGoal(MaterialLevel.IRON, "Wood Plank", 40, 0),
			new InventoryGoal(MaterialLevel.IRON, "Stick", 40, 0),
			new InventoryGoal(MaterialLevel.IRON, "Cobble Stone", 10, 0),
			new InventoryGoal(MaterialLevel.IRON, "Coal", 40, 0),
			new InventoryGoal(MaterialLevel.IRON, "Torch", 40, 0),
			new InventoryGoal(MaterialLevel.IRON, "Iron Ore", 20, 0),
			new InventoryGoal(MaterialLevel.IRON, "Iron", 20, 0),
			new InventoryGoal(MaterialLevel.IRON, "Iron Axe", 2, 0),
			new InventoryGoal(MaterialLevel.IRON, "Iron Pick", 2, 0),
			new InventoryGoal(MaterialLevel.IRON, "Iron Shovel", 2, 0),
			new InventoryGoal(MaterialLevel.IRON, "Stone Hoe", 2, 0),
			new InventoryGoal(MaterialLevel.IRON, "Iron Helmet", 1, 0),
			new InventoryGoal(MaterialLevel.IRON, "Iron Chestplate", 1, 0),
			new InventoryGoal(MaterialLevel.IRON, "Iron Leggings", 1, 0),
			new InventoryGoal(MaterialLevel.IRON, "Iron Boots", 1, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Wood Block", 64, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Wood Plank", 64, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Stick", 40, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Cobble Stone", 64, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Coal", 64, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Torch", 64, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Iron Ore", 40, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Iron", 40, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Diamond", 20, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Diamond Axe", 1, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Diamond Pick", 1, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Diamond Shovel", 1, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Stone Hoe", 2, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Diamond Helmet", 1, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Diamond Chestplate", 1, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Diamond Leggings", 1, 0),
			new InventoryGoal(MaterialLevel.DIAMOND, "Diamond Boots", 1, 0),

	};

	// TODO Setup InventoryManager Fields
	private static int inventory = 0;
	
	public static void init(){
		// TODO Implement InventoryManager
	}


}
