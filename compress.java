package javaCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

public class compress
{
	static String compressWord(String str)
	{
		String sCompress = "";
		int iInputLenght = str.length();
		if (0 < iInputLenght && iInputLenght < 1024)
		{
			Map<Character, Integer> mapCharCount = new HashMap<Character, Integer>();
			LinkedList<Character> charLL = new LinkedList<Character>();

			for (int iCharIndex = 0; iCharIndex < iInputLenght; iCharIndex++)
			{
				char cTemp = str.charAt(iCharIndex);
				if (mapCharCount.containsKey(cTemp))
				{
					int iCharCount = mapCharCount.get(cTemp);
					mapCharCount.put(cTemp, ++iCharCount);
				}
				else
				{
					charLL.add(cTemp);
					mapCharCount.put(cTemp, 1);
				}
			}

			ListIterator<Character> it = charLL.listIterator();
			while (it.hasNext())
			{
				char cTemp = it.next();
				if (mapCharCount.containsKey(cTemp))
				{
					int iCharCount = mapCharCount.get(cTemp);
					sCompress += cTemp;
					if (iCharCount > 1)
						sCompress += iCharCount;
				}
			}
		}
		return sCompress;
	}

	public static void main (String[] args)
	{
		//		string of n (max 1024) length, compress it by replacing consecutive letters by one instance of the character following by the count denoting the number of repetitions.
		//		If there is no repeitition, leave it as is.

		String sWord = "aaaaabbbbbbbbbccccdeeeeeee";
		System.out.println(compressWord(sWord)); // a5b9c4de7
	}
}