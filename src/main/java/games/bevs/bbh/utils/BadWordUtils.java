package games.bevs.bbh.utils;

import java.util.Arrays;
import java.util.HashSet;

public class BadWordUtils 
{
	private static HashSet<String> SHORT_WORDS;
	private static HashSet<String> LONG_WORDS;
	
	static
	{
		populate();
	}
	
	private static void populate()
	{
		SHORT_WORDS = new HashSet<String>(Arrays.asList(new String[] { "ass", "sex", "tits", "tit", "fuk", "fag", "cum", "shit", "cock", "cunt", "dick", "dildo", "wank", "ddos", "butt", "piss" }));
		LONG_WORDS = new HashSet<String>(Arrays.asList(new String[] {  "fuck", "whore", "bitch", "fukc", "faggot", "faggit", "nigger", "nigga", "niqqer", "niggers", "slut", "buttplug", "queer", "penis" }));
	}
	
	public static boolean isBadWordShort(String word)
	{
		return SHORT_WORDS.contains(word);
	}
	
	public static boolean isBadWordLong(String word)
	{
		return LONG_WORDS.contains(word);
	}
}
