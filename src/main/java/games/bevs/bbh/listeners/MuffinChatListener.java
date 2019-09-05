package games.bevs.bbh.listeners;

import java.util.LinkedList;
import java.util.List;

import games.bevs.bbh.filter.WordFilter;
import games.bevs.bbh.filter.filters.LongWordFilter;
import games.bevs.bbh.filter.filters.ShortWordFilter;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MuffinChatListener 
{
	private List<WordFilter> filterWords = new LinkedList<>();
	
	public MuffinChatListener()
	{
		this.filterWords.add(new ShortWordFilter());
		this.filterWords.add(new LongWordFilter());
	}
	
	@SubscribeEvent
	public void onChat(ClientChatReceivedEvent e) 
	{
		//ignore actionbars
		if(e.type != 2) return;
		String formated = e.message.getFormattedText();
		String unformated = e.message.getUnformattedTextForChat();
		
		for(WordFilter wordFilter : this.filterWords)
		{
			formated = wordFilter.onFilter(formated, unformated);
		}
		
		ChatComponentText chatComponentText = new ChatComponentText(formated);
		
		Minecraft.getMinecraft().thePlayer.addChatMessage(chatComponentText);
		
		e.setCanceled(true);
	}
}
