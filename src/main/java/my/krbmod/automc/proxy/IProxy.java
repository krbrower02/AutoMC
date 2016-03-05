package my.krbmod.automc.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;

public interface IProxy {
    public abstract void registerKeyBindings();
    
    public abstract void registerRenders();

}
