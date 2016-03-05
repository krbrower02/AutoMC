package my.krbmod.automc.init;

import my.krbmod.automc.init.ModItems;
import my.krbmod.automc.reference.Reference;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModTab {

	public static final CreativeTabs AUTOMC_TAB = new CreativeTabs(Reference.MOD_ID) {

		@Override
		public Item getTabIconItem() {
			return ModItems.mapleLeaf;
		}
	};

}
