package my.krbmod.automc.aisystem.actions.actionhelpers;
//
// Determines the type of action in the Priority Queue as follows:
//
// DORMANT = Not used. Represents the default state following a constructor - can be removed by Priority Queue
//
// REQUESTED = Action has been Requested by Source game system but not yet Authorized by Priority Queue
//
// AUTHORIZED = Action has been been Authorized by Priority Queue and Target game system can now act upon it
//
// CANCELED = Action was Canceled by another game system. Target game system must Complete without action
//
// COMPLETED = Action was Completed by target game system and can be removed by Priority Queue
//
public enum ActionStatus {
	DORMANT,
	REQUESTED,
	AUTHORIZED,
	CANCELED,
	COMPLETED	
}
