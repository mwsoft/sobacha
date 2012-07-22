package jp.mwsoft.sobacha.tag;

import java.util.ArrayList;
import java.util.List;

public class Word {

	private String surface;

	private List<Tag> tags = new ArrayList<>();

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public List<Tag> getTags() {
		return tags;
	}
	
	public void addTag(Tag tag) {
		this.tags.add(tag);
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Word [surface=" + surface + ", tags=" + tags + "]";
	}
}
