package my.krbmod.automc.aisystem.priorityqueue;

import my.krbmod.automc.aisystem.actions.actionhelpers.ActionID;
import my.krbmod.automc.aisystem.actions.actionhelpers.ActionStatus;
import my.krbmod.automc.aisystem.actions.actionhelpers.Actions;

public class PriorityQueueItem {

	private Actions source = Actions.STATUS;
	private Actions target = Actions.STATUS;
	private int actionID = 0;
	private ActionStatus status = ActionStatus.DORMANT;
	private int priority = 0;
	
	public PriorityQueueItem() {
		this(Actions.STATUS, Actions.STATUS, ActionID.newID(), ActionStatus.DORMANT, 0);
	}
	
	public PriorityQueueItem(Actions s, Actions t, int id, ActionStatus st, int p){
	// TODO validate parameter inputs
		this.source = s;
		this.target = t;
		this.actionID = id;
		this.status = st;
		this.priority = p;
	}
}
