package my.krbmod.automc.aisystem.commandqueue;

import my.krbmod.automc.aisystem.aihelpers.ActionID;
import my.krbmod.automc.aisystem.aihelpers.CommandStatus;
import my.krbmod.automc.aisystem.aihelpers.Actions;

public class CommandQueueItem {

	private Actions source = Actions.NULL;
	private Actions target = Actions.NULL;
	private int actionID = 0;
	private CommandStatus status = CommandStatus.DORMANT;
	private int priority = 0;
	
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
	}
}
