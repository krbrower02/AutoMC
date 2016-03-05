package my.krbmod.automc.init;

import java.util.Random;

import my.krbmod.automc.reference.Names;
import my.krbmod.automc.reference.Textures;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ModBlock extends Block {

	public String blockName = "Default";

	public ModBlock() {
		this(Material.ground);

	}

	public ModBlock(Material material) {
		super(material);
	}

	@Override
	public String getUnlocalizedName() {
		return String.format("tile.%s%s", Textures.RESOURCE_PREFIX,
				getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {

		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);

	}

	public String getName() {
		return this.blockName;

	}
}
