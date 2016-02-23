package my.krbmod.automc.aisystem.priorityqueue;

import my.krbmod.automc.aisystem.actions.actionhelpers.ActionID;
import my.krbmod.automc.aisystem.actions.actionhelpers.ActionStatus;
import my.krbmod.automc.aisystem.actions.actionhelpers.Actions;

public class PriorityQueueItem {

	Actions actionSource = Actions.STATUS;
	Actions actionTarget = Actions.STATUS;
	int actionID = ActionID.newID();
	ActionStatus status = ActionStatus.DORMANT;
	int priority = 0;
}
