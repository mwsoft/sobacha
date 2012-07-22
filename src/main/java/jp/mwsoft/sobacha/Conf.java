package jp.mwsoft.sobacha;

public class Conf {

	private int ngramLength = 3;

	private int ngramSpan = 3;

	private int corpusType = CORPUS_TYPE_WAKATI;

	public final static int CORPUS_TYPE_FULL = 1;
	public final static int CORPUS_TYPE_WAKATI = 2;

	public int getNgramLength() {
		return ngramLength;
	}

	public void setNgramLength(int ngramLength) {
		this.ngramLength = ngramLength;
	}

	public int getNgramSpan() {
		return ngramSpan;
	}

	public void setNgramSpan(int ngramSpan) {
		this.ngramSpan = ngramSpan;
	}

	public int getCorpusType() {
		return corpusType;
	}

	public void setCorpusType(int corpusType) {
		this.corpusType = corpusType;
	}

}
