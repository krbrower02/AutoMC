package my.krbmod.automc.aisystem.commandqueue;

import my.krbmod.automc.aisystem.aihelpers.ActionID;
import my.krbmod.automc.aisystem.aihelpers.CommandStatus;
import my.krbmod.automc.aisystem.aihelpers.Actions;

public class CommandQueueItem {

	public Actions source = Actions.NULL;
	public Actions target = Actions.NULL;
	public int actionID = 0;
	public CommandStatus status = CommandStatus.DORMANT;
	public int priority = 0;
	public long lastchecked = System.currentTimeMillis();
	
	public CommandQueueItem() {
		this(Actions.NULL, Actions.NULL, ActionID.newID(), CommandStatus.DORMANT, 0);
	}
	
	public CommandQueueItem(Actions s, Actions t, int id, CommandStatus st, int p){
	// TODO validate parameter inputs
		this.source = s;
		this.target = t;
		this.actionID = id;
		this.status = st;
		this.priority = p;
		this.lastchecked = System.currentTimeMillis();
	}
}
