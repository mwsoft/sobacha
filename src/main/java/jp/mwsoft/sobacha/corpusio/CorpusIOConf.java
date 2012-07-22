package jp.mwsoft.sobacha.corpusio;

public class CorpusIOConf {

	private char wordSep = ' ';
	private char featSep = '/';
	private char escChar = '\\';

	public char getWordSep() {
		return wordSep;
	}

	public void setWordSep(char wordSep) {
		this.wordSep = wordSep;
	}

	public char getFeatSep() {
		return featSep;
	}

	public void setFeatSep(char featSep) {
		this.featSep = featSep;
	}

	public char getEscChar() {
		return escChar;
	}

	public void setEscChar(char escChar) {
		this.escChar = escChar;
	}
}
