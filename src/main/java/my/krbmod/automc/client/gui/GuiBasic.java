package my.krbmod.automc.client.gui;

import org.lwjgl.opengl.GL11;

import my.krbmod.automc.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiBasic extends GuiScreen {
    public static final int GUI_ID = 20;
   
    public GuiBasic() {}

    public void initGui() {
    	
    }
    
    @Override
    public void drawScreen(int x, int y, float ticks) {
    	drawDefaultBackground();
    	
    	super.drawScreen(x, y, ticks);
    }

}
