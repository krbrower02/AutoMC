package my.krbmod.automc.init;

import my.krbmod.automc.AutoMC;
import my.krbmod.automc.init.items.ItemMapleLeaf;
import my.krbmod.automc.reference.Names;
import my.krbmod.automc.reference.Reference;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Bootstrap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmorStand;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEmptyMap;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemShears;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

	public static final ModItem mapleLeaf = new ItemMapleLeaf();

	private static ModItem getRegisteredItem(String name) {
		return (ModItem) Item.itemRegistry.getObject(new ResourceLocation(name));
	}

	public static void init() {

		LogHelper.info("Registration of Items should be in Pre Initialization");

		GameRegistry.registerItem(mapleLeaf, Names.Items.MAPLE_LEAF);

	}

	public static void registerRenders() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		renderItem.getItemModelMesher().register(ModItems.mapleLeaf, 0,
				new ModelResourceLocation(Reference.MOD_ID + ":" + ModItems.mapleLeaf.getName(), "inventory"));

	}

}
