package my.krbmod.automc.aisystem.actions.inventory;

import my.krbmod.automc.aisystem.aihelpers.MaterialLevel;

public class InventoryGoal {

	MaterialLevel materialLevel;
	String item;
	int need;
	int have;	 
	
	public InventoryGoal(){
		materialLevel=MaterialLevel.DEFAULT;
		item = "None";
		need = 0;
		have = 0;	 
	}
	
	public InventoryGoal(MaterialLevel m, String s, int n, int h) {
		materialLevel=m;
		item = s;
		need = n;
		have = h;	 
	}
	
}
