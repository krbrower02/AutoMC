package my.krbmod.automc.proxy;

import my.krbmod.automc.client.gui.GuiBasic;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ServerProxy extends CommonProxy {
	
    @Override
    public void registerKeyBindings()
    {
		LogHelper.info("__**ServerProxy is doing nothing");

    	// NOOP
    }

    @Override
    public void registerRenders()
    {
    	LogHelper.info("__**ServerProxy is doing nothing");
    	// NOOP
    }
 
    
}
