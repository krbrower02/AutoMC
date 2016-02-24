package my.krbmod.automc.aisystem.goals;

import my.krbmod.automc.aisystem.actions.actionhelpers.ActionCommands;
import my.krbmod.automc.aisystem.actions.actionhelpers.Actions;
//
//Goals are fed into the Priority Queue at a relatively low priority.
//They instigate Actions when nothing else is going on and serve to keep the player busy
//and progressing toward some sort of end game.
//
public class GoalManager {
private static Goal[] goalList = new Goal[] {
		new Goal(Actions.LUMBERJACK, ActionCommands.ACTION_LUMBERJACK_CHOP, 10, 1),
		new Goal(Actions.LUMBERJACK, ActionCommands.ACTION_LUMBERJACK_PRUNE, 10, 1)
	};


// TODO Setup GoalManager Fields
private static int goal = 0;

public static void init(){
	// TODO Implement GoalManager
}

}
