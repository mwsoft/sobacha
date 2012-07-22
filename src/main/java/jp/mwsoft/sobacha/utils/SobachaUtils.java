package jp.mwsoft.sobacha.utils;

import java.lang.Character.UnicodeBlock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SobachaUtils {

	private static final Map<String, Integer> gramIds = new ConcurrentHashMap<>();
	
	private static final Map<String, Integer> wordIds = new ConcurrentHashMap<>();

	private static final int CHAR_TYPE_ALPHA = 1;
	private static final int CHAR_TYPE_NUMERIC = 2;
	private static final int CHAR_TYPE_HIRAGANA = 3;
	private static final int CHAR_TYPE_KATAKANA = 4;
	private static final int CHAR_TYPE_KANJI = 5;
	private static final int CHAR_TYPE_SYMBOL = 6;
	private static final int CHAR_TYPE_CONTROL = 7;
	private static final int CHAR_TYPE_OTHER = 8;

	private static int addString(Map<String, Integer> map, String key) {
		synchronized (map) {
			int size = map.size();
			map.put(key, size);
			return size;
		}
	}

	/**
	 * get ngram char id
	 * 
	 * @param gram
	 * @return return gram id
	 */
	public static int getGramId(String gram) {
		if (gramIds.containsKey(gram))
			return gramIds.get(gram);
		return addString(gramIds, gram);
	}

	/**
	 * get character type
	 * 
	 * @param c
	 * @return type id
	 */
	public static int getCharType(char c) {
		if (Character.isAlphabetic(c))
			return CHAR_TYPE_ALPHA;
		if (Character.isDigit(c))
			return CHAR_TYPE_NUMERIC;
		if (Character.isISOControl(c))
			return CHAR_TYPE_CONTROL;
		if (!Character.isLetter(c))
			return CHAR_TYPE_SYMBOL;

		UnicodeBlock block = UnicodeBlock.of(c);
		if (block.equals(UnicodeBlock.HIRAGANA))
			return CHAR_TYPE_HIRAGANA;
		if (block.equals(UnicodeBlock.KATAKANA))
			return CHAR_TYPE_KATAKANA;
		if (block.toString().startsWith("CJK"))
			return CHAR_TYPE_KANJI;

		return CHAR_TYPE_OTHER;
	}

	/**
	 * get dictionary word id
	 * @param word
	 * @return id
	 */
	public static int getWordId(String word) {
		if (wordIds.containsKey(word))
			return wordIds.get(word);
		return addString(wordIds, word);
	}

}
