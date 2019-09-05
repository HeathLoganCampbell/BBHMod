package games.bevs.bbh.listeners;

import games.bevs.bbh.utils.BadWordUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MuffinChatListener 
{
	private static final String REPLACEMENT_WORD = "muffin";
	
	private String filterBadWords(String statement)
	{
		String[] words = statement.split(" ");
		StringBuilder strBuilder = new StringBuilder();
		
		boolean isBad = false;
		
		for(String word : words)
		{
			if(BadWordUtils.isBad(word))
				isBad = true;
			strBuilder.append(BadWordUtils.isBad(word) 
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
		
		formated = this.filterBadWords(formated);
		
		ChatComponentText chatComponentText = new ChatComponentText(formated);
		Minecraft.getMinecraft().thePlayer.addChatMessage(chatComponentText);
	}
}
