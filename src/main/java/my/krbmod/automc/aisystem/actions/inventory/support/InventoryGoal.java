package my.krbmod.automc.aisystem.actions.inventory.support;

import my.krbmod.automc.aisystem.aihelpers.MaterialLevel;

public class InventoryGoal {

	MaterialLevel materialLevel;
	String itemName;
	int need;
	int have;	 
	
	public InventoryGoal(){
		materialLevel=MaterialLevel.DEFAULT;
		itemName = "None";
		need = 0;
		have = 0;	 
	}
	
	public InventoryGoal(MaterialLevel m, String s, int n, int h) {
		materialLevel=m;
		itemName = s;
		need = n;
		have = h;	 
	}
	
}
