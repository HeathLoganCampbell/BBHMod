package games.bevs.bbh.utils;

import java.util.HashSet;

public class BadWordUtils 
{
	private static HashSet<String> BAD_WORDS = new HashSet<>();
	
	static 
	{
		populate();
	}
	
	private static void populate()
	{
		BAD_WORDS.add("fuck");
		BAD_WORDS.add("cunt");
		BAD_WORDS.add("bitch");
		BAD_WORDS.add("slut");
	}
	
	public static boolean isBad(String word)
	{
		return BAD_WORDS.contains(word);
	}
}
