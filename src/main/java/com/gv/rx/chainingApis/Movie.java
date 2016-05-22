package com.gv.rx.chainingApis;

import java.util.List;

public class Movie {
	
	
	private String title;
	private List<Song> songs;
	private List<Singer> actors;
	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", songs=" + songs + ", actors=" + actors + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public List<Singer> getActors() {
		return actors;
	}
	public void setActors(List<Singer> actors) {
		this.actors = actors;
	}

	
	
}
