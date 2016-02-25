package my.krbmod.automc.aisystem.aihelpers;
//
// enum to represent current Mining/Material level
// it starts with BAREHAND, but it gets upgraded each time a new material is found
// this effects default inventory levels which in-turn trigger
// mining, logging, crafting and farming, etc. tasks
//
public enum MaterialLevel {
	DEFAULT,
	BAREHAND,
	WOOD,
	STONE,
	IRON,
	DIAMOND
}
