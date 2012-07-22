package jp.mwsoft.sobacha.corpusio;

import java.util.ArrayList;
import java.util.List;

import jp.mwsoft.sobacha.tag.Tag;
import jp.mwsoft.sobacha.tag.Word;

public class FullCorpusIO extends CorpusIO {

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

		// word:0b0001, feature: 0b0010, pronounce: 0b0100, escape 0b1000
		int state = 0b0001;

		int len = sentence.length();
		Word word = new Word();
		Tag tag = new Tag();
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char c = sentence.charAt(i);
			if ((state & 0b1000) == 1)
				buf.append(c);
			else if (c == conf.getEscChar()) {
				state |= 0b1000;
			}
			else if (c == conf.getFeatSep()) {
				if ((state & 0b0100) == 1)
					throw new InvalidCorpusException("too many feature splitter");
				setWordParam(buf, word, tag, state);
				state <<= 1;
			}
			else if (c == conf.getWordSep()) {
				setWordParam(buf, word, tag, state);
				addWord(list, word);
				word = new Word();
				tag = new Tag();
				state = 0b0001;
			}
			else {
				buf.append(c);
			}
		}
		setWordParam(buf, word, tag, state);

		if (word.getSurface() != null)
			addWord(list, word);

		return list;
	}

	private void setWordParam(StringBuilder buf, Word word, Tag tag, int state) {
		if ((state & 0b0001) == 0b0001) {
			if (buf.length() > 0)
				word.setSurface(buf.toString());
		}
		else if ((state & 0b0010) == 0b0010) {
			tag.setFeature(buf.toString());
			word.addTag(tag);
		}
		else if ((state & 0b0100) == 0b0100) {
			tag.setPronounce(buf.toString());
		}
		buf.delete(0, buf.length());
	}

	private void addWord(List<Word> list, Word word) throws InvalidCorpusException {
		tagCheck(word);
		list.add(word);
	}

	private void tagCheck(Word word) throws InvalidCorpusException {
		List<Tag> tags = word.getTags();
		if (tags.size() == 0)
			throw new InvalidCorpusException("Tag size equal 0 : " + word.getSurface());
		Tag tag = tags.get(0);
		if (tag.getFeature() == null || tag.getFeature().length() == 0)
			throw new InvalidCorpusException("Tag feature is empty : " + word.getSurface());
		if (tag.getPronounce() == null || tag.getPronounce().length() == 0)
			throw new InvalidCorpusException("Tag feature is empty : " + word.getSurface());
	}

	@Override
	public void writeSentence() {

	}

}
