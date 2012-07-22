package jp.mwsoft.sobacha.corpusio;

import java.util.ArrayList;
import java.util.List;

import jp.mwsoft.sobacha.tag.Word;

public class WakatiCorpusIO extends CorpusIO {

	private CorpusIOConf conf = new CorpusIOConf();

	@Override
	public CorpusIOConf getConf() {
		return conf;
	}

	@Override
	public void setConf(CorpusIOConf conf) {
		this.conf = conf;
	}

	/**
	 * Parse one line sentence
	 * 
	 * @param sentence
	 * @return
	 * @throws InvalidCorpusException
	 */
	@Override
	public List<Word> readSentence(String sentence) throws InvalidCorpusException {

		List<Word> list = new ArrayList<>();

		// word:0b0001, escape 0b1000
		int state = 0b0001;

		int len = sentence.length();
		Word word = new Word();
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char c = sentence.charAt(i);
			if ((state & 0b1000) == 1)
				buf.append(c);
			else if (c == conf.getWordSep()) {
				word.setSurface(buf.toString());
				if (word.getSurface().length() > 0)
					list.add(word);
				word = new Word();
				buf = new StringBuilder();
				state = 0b0001;
			}
			else {
				buf.append(c);
			}
		}
		if (buf.length() > 0)
			word.setSurface(buf.toString());

		if (word.getSurface() != null && word.getSurface().length() > 0)
			list.add(word);

		return list;
	}

	@Override
	public void writeSentence() {

	}

}