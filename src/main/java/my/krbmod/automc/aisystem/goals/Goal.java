package my.krbmod.automc.aisystem.goals;
import my.krbmod.automc.aisystem.aihelpers.UniqueID;
import my.krbmod.automc.aisystem.aihelpers.CommandStatus;
import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandItem;

public class Goal {
	Actions target;
	String command;
	int priority;
	int repeat;	 
	// TODO - Determine if Goals need to go by the Wayside...
	public Goal(){
		//target = Actions.STATUS;
		//command = CommandItem.ACTION_NULL;
		priority = 1;
		repeat = 1;
	}
	
	public Goal(Actions t, String c, int p, int r){
		target = t;
		command = c;
		priority = p;
		repeat = r;
	}
}
