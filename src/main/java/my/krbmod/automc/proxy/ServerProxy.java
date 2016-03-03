package my.krbmod.automc.proxy;

import my.krbmod.automc.client.gui.GuiBasic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ServerProxy extends CommonProxy {
	
    @Override
    public void registerKeyBindings()
    {
        // NOOP
    }

    @Override
    public void registerRenders()
    {
        // NOOP
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
