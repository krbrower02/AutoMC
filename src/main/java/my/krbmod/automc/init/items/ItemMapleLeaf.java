package my.krbmod.automc.init.items;

import java.util.List;

import my.krbmod.automc.init.ModItem;
import my.krbmod.automc.init.ModTab;
import my.krbmod.automc.reference.Names;
import my.krbmod.automc.reference.Reference;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMapleLeaf extends Item {

	public ItemMapleLeaf(){
		super();
		GameRegistry.registerItem(this, Names.Items.MAPLE_LEAF);
		setUnlocalizedName(Reference.MOD_ID+":"+Names.Items.MAPLE_LEAF);
        setMaxStackSize(64);
        setCreativeTab(ModTab.AUTOMC_TAB);
                
	}
	
	public String getName() {
		return Names.Items.MAPLE_LEAF;
	
	}
	
}
