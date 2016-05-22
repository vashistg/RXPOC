package com.gv.rx.chainingApis;

import java.util.List;

public class Song {
	
	private String title;
	private List<Singer> singers;
	private Error error;
	
	@Override
	public String toString() {
		return "Song [title=" + title + ", singers=" + singers + "]";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Singer> getSingers() {
		return singers;
	}
	public void setSingers(List<Singer> singers) {
		this.singers = singers;
	}
	
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	
	
	
	
}
