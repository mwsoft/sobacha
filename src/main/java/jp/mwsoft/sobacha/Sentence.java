package jp.mwsoft.sobacha;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Sentence {

	private String surface;
	private String norm;
	List<Float> confs = new ArrayList<>();

	public Sentence(String surface) {
		this.surface = surface;
		this.norm = Normalizer.normalize(surface, Normalizer.Form.NFKC);
	}

	public void calcurate() {
		
	}

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

	public List<Float> getConfs() {
		return confs;
	}

	public void setConfs(List<Float> confs) {
		this.confs = confs;
	}

}
