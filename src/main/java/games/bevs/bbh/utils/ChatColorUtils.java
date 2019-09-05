package games.bevs.bbh.utils;

public class ChatColorUtils
{
	public static String getLastChatColor(String statement)
	{
		//§
		char lastChatColor = 'r';
			
		for (int i = 0; i < statement.length(); i++) {
			char Character = statement.charAt(i);
			if (Character == '§' && statement.length() > i + 1)
				lastChatColor = statement.charAt(i + 1);
		}
		
		return "§" + lastChatColor;
	}
}
