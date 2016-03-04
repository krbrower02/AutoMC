package my.krbmod.automc.proxy;

import my.krbmod.automc.client.gui.GuiBasic;
import my.krbmod.automc.client.settings.KeyBindings;
import my.krbmod.automc.init.ModBlocks;
import my.krbmod.automc.init.ModItems;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(KeyBindings.charge);
        ClientRegistry.registerKeyBinding(KeyBindings.release);
    }
    
    @Override
    public void registerRenders(){
    	//ModBlocks.registerRenders();
		
    	//ModItems.registerRenders();

    }
    
}
