package my.krbmod.automc.aisystem.inventory;
//
// enum to support different types of item searches
//
public enum SearchType {
	EXACT,		// search must match item exactly
	IGNORE_MBT,	// search treats items with damage values and enchants as equal
	ORE_DICT	// search treats items equivalent in ore dictionary as equal	
}
