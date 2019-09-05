package games.bevs.bbh;

import games.bevs.bbh.listeners.MuffinChatListener;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = BBHMod.MODID, version = BBHMod.VERSION)
public class BBHMod
{
	public static String REPLACEMENT_WORD = EnumChatFormatting.BOLD + "muffin" + EnumChatFormatting.RESET;
	
    public static final String MODID = "bbhmod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	FMLCommonHandler.instance().bus().register(new MuffinChatListener());
    }
}
