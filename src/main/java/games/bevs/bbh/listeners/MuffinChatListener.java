package games.bevs.bbh.listeners;

import games.bevs.bbh.utils.BadWordUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.client.config.GuiConfigEntries.ChatColorEntry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MuffinChatListener 
{
	private static final String REPLACEMENT_WORD = EnumChatFormatting.BOLD + "muffin" + EnumChatFormatting.RESET;
	
	private String filterBadWords(String statement)
	{
		String[] words = statement.split(" ");
		StringBuilder strBuilder = new StringBuilder();
		
		boolean isBad = false;
		
		for(String word : words)
		{
			String unformattedWord = word;
			
			for(EnumChatFormatting chatColor : EnumChatFormatting.values())
				unformattedWord = word.replaceAll(chatColor.toString(), "");
			
			if(BadWordUtils.isBad(unformattedWord))
				isBad = true;
			
			strBuilder.append(isBad
								? REPLACEMENT_WORD 
								: word);
			strBuilder.append(" ");
		}
		
		//if we don't find a bad word, just ignore it
		if(isBad)
			return strBuilder.toString();
		return statement;
	}
	
	@SubscribeEvent
	public void onChat(ClientChatReceivedEvent e) 
	{
		String formated = e.message.getFormattedText();
		String unformated = e.message.getUnformattedText();
		
		formated = this.filterBadWords(formated);
		
		ChatComponentText chatComponentText = new ChatComponentText(formated);
		
		Minecraft.getMinecraft().thePlayer.addChatMessage(chatComponentText);
		
		e.setCanceled(true);
	}
}
