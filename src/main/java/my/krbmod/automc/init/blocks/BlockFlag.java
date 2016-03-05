package my.krbmod.automc.init.blocks;

import java.util.Random;

import my.krbmod.automc.init.ModBlock;
import my.krbmod.automc.init.ModTab;
import my.krbmod.automc.init.items.ItemMapleLeaf;
import my.krbmod.automc.reference.Names;
import my.krbmod.automc.reference.Reference;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockFlag extends ModBlock {

	public BlockFlag() {
		super(Material.ground);
		this.blockName = Names.Blocks.FLAG;
		setUnlocalizedName(Names.Blocks.FLAG);
		setCreativeTab(ModTab.AUTOMC_TAB);

	}

}
