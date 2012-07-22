package jp.mwsoft.sobacha.tag;

public class Char {

	private char c = ' ';

	private char normalized = ' ';

	private int[] parms;

	private int predict = -1;

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public char getNormalized() {
		return normalized;
	}

	public void setNormalized(char normalized) {
		this.normalized = normalized;
	}

	public int[] getParms() {
		return parms;
	}

	public void setParms(int[] parms) {
		this.parms = parms;
	}

	public int getPredict() {
		return predict;
	}

	public void setPredict(int predict) {
		this.predict = predict;
	}

}
