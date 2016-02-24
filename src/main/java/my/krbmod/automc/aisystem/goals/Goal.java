package my.krbmod.automc.aisystem.goals;
//
// Class to instantiate a Goal for use by the Goal Manager
// 
import my.krbmod.automc.aisystem.actions.actionhelpers.ActionCommands;
import my.krbmod.automc.aisystem.actions.actionhelpers.ActionID;
import my.krbmod.automc.aisystem.actions.actionhelpers.ActionStatus;
import my.krbmod.automc.aisystem.actions.actionhelpers.Actions;

public class Goal {
	Actions target;
	String command;
	int priority;
	int repeat;	 
	
	public Goal(){
		target = Actions.STATUS;
		command = ActionCommands.ACTION_NULL;
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
