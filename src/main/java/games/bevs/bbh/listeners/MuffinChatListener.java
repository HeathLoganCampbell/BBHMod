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
	
	private String filterSimpleBadWords(String statement)
	{
		String[] words = statement.split(" ");
		StringBuilder strBuilder = new StringBuilder();
		
		boolean isBad = false;
		
		for(String word : words)
		{
			String unformattedWord = word;
			
			for(EnumChatFormatting chatColor : EnumChatFormatting.values())
				unformattedWord = word.replaceAll(chatColor.toString(), "");
			unformattedWord = antiEasyByPass(unformattedWord);
			
			if(BadWordUtils.isBad(unformattedWord))
				isBad = true;
			
			strBuilder.append(BadWordUtils.isBad(unformattedWord)
								? REPLACEMENT_WORD 
								: word);
			strBuilder.append(" ");
		}
		
		//if we don't find a bad word, just ignore it
		if(isBad)
			return strBuilder.toString();
		return statement;
	}
	
	private String antiEasyByPass(String word)
	{
		word = word.replaceAll("1", "i");
		word = word.replaceAll("5", "s");
		return word;
	}
	
	@SubscribeEvent
	public void onChat(ClientChatReceivedEvent e) 
	{
		String formated = e.message.getFormattedText();
		
		formated = this.filterSimpleBadWords(formated);
		
		ChatComponentText chatComponentText = new ChatComponentText(formated);
		
		Minecraft.getMinecraft().thePlayer.addChatMessage(chatComponentText);
		
		e.setCanceled(true);
	}
}
