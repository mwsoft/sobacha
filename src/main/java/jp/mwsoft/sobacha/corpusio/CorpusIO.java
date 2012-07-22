package jp.mwsoft.sobacha.corpusio;

import java.util.List;

import jp.mwsoft.sobacha.Conf;
import jp.mwsoft.sobacha.tag.Word;

public abstract class CorpusIO {

	public static CorpusIO getInstance(Conf conf) {
		int corpusType = conf.getCorpusType();
		CorpusIO io = null;
		if (corpusType == Conf.CORPUS_TYPE_FULL)
			io = new FullCorpusIO();
		else if( corpusType == Conf.CORPUS_TYPE_WAKATI )
			io = new WakatiCorpusIO();

		if (io == null)
			throw new IllegalArgumentException("undefined corpus type : " + corpusType);

		return io;
	}

	abstract public void setConf(CorpusIOConf conf);

	abstract public CorpusIOConf getConf();

	abstract public List<Word> readSentence(String sentence) throws InvalidCorpusException;

	abstract public void writeSentence();
}
