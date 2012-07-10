package jp.mwsoft.sobacha;

import java.util.ArrayList;
import java.util.List;

public class Word {

	private String surface;
	private String norm;
	private List<Tag> tags = new ArrayList<>();
	private boolean certain;
	private boolean unknown;

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public String getNorm() {
		return norm;
	}

	public void setNorm(String norm) {
		this.norm = norm;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public boolean isCertain() {
		return certain;
	}

	public void setCertain(boolean certain) {
		this.certain = certain;
	}

	public boolean isUnknown() {
		return unknown;
	}

	public void setUnknown(boolean unknown) {
		this.unknown = unknown;
	}

}
