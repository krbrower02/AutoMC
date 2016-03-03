package my.krbmod.automc.proxy;

import my.krbmod.automc.client.gui.GuiBasic;
import my.krbmod.automc.client.settings.KeyBindings;
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

    }

/*
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
            return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    if (ID == GuiBasic.GUI_ID)
        return new GuiBasic();
   
            return null;
    }
*/
    
}
