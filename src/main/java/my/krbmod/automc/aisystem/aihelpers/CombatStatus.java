package my.krbmod.automc.aisystem.aihelpers;

//
//Determines the type of action in the Priority Queue as follows:
//

public enum CombatStatus {
	IDLE,	// No Mobs in the Vicinity
	AWARE,	// Mobs in the Vicinity but they do not have aggro
	ALERT,	// Mobs in the Vicinity with aggro
	ATTACK,	// Nearby Mob that you can kill - go to attack mode
	DEFEND,	// Temporary protect from attacks 
	FLEE,	// Nearby Mob with aggro that you cannot kill - start to flee
	DECEASED	// Player is deceased
}

