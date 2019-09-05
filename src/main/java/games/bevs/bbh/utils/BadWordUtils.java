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
		BAD_WORDS.add("hell");
		BAD_WORDS.add("boob");
		BAD_WORDS.add("boobs");
		BAD_WORDS.add("ass");
		BAD_WORDS.add("blowjob");
		BAD_WORDS.add("boner");
		BAD_WORDS.add("hell");
		BAD_WORDS.add("tit");
		BAD_WORDS.add("ballsack");
		
		BAD_WORDS.add("8==D");
		BAD_WORDS.add("8==D~");
	}
	
	public static boolean isBad(String word)
	{
		return BAD_WORDS.contains(word);
	}
}
