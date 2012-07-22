package jp.mwsoft.sobacha.tag;

public class Tag {

	private String feature;

	private String pronounce;

	private double score;

	private boolean unknown;

	public String getFeature() {
		return feature;
	}

	public void setFeature(String name) {
		this.feature = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getPronounce() {
		return pronounce;
	}

	public void setPronounce(String pronounce) {
		this.pronounce = pronounce;
	}

	public boolean isUnknown() {
		return unknown;
	}

	public void setUnknown(boolean unknown) {
		this.unknown = unknown;
	}

	@Override
	public String toString() {
		return "Tag [feature=" + feature + ", pronounce=" + pronounce + ", score=" + score + ", unknown=" + unknown + "]";
	}
}
