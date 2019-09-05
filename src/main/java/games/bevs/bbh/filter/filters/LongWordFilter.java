package games.bevs.bbh.filter.filters;

import games.bevs.bbh.BBHMod;
import games.bevs.bbh.filter.WordFilter;
import games.bevs.bbh.utils.BadWordUtils;
import games.bevs.bbh.utils.ChatColorUtils;
import net.minecraft.util.EnumChatFormatting;

public class LongWordFilter extends WordFilter
{
	@Override
	public String onFilter(String statement, String unformatted)
	{
		
	    StringBuilder strBuilder = new StringBuilder();
	    boolean isBad = false;
	    for(String word : statement.split(" "))
		{
			String unformattedWord = word;
			unformattedWord = unformattedWord.toLowerCase()
											 .replaceAll("3", "e")
											 .replaceAll("1", "i")
											 .replaceAll("_", "")
											 .replaceAll("-", "")
											 .replaceAll("\\*", "")
											 .replaceAll("!", "");
		    
			//remove chatcolor
			for(EnumChatFormatting chatColor : EnumChatFormatting.values())
				unformattedWord = word.replaceAll(chatColor.toString(), "");
			
			if(BadWordUtils.isBadWordLong(unformattedWord))
			{
				isBad = true;
				String lastColor = ChatColorUtils.getLastChatColor(strBuilder.toString());
				strBuilder.append(BBHMod.REPLACEMENT_WORD + lastColor);
			}
			else
			{
				strBuilder.append(word);
			}
			
			strBuilder.append(" ");
		}
		
	    if(isBad)
	    	return strBuilder.toString();
		return statement;
	}
}
