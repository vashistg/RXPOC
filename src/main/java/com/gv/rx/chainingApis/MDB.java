package com.gv.rx.chainingApis;

import java.util.List;
import java.util.Random;

import rx.Observable;
import rx.Subscriber;

public class MDB {
	final String[] names = {"Forrest Gump","Cast Away","Departed","Khosla Ka Ghosla","3 Idiots","Tare Zameen Par","Inception","Guru","Lage Raho Munna Bhai"};
	final String[][] songs = {
			                  {"Chak De Phattey","Din Din Gin Gin","Iss Se Pyaar Kaise Karoon","Ab Kya Karenge","Intezar Aitbaar Tumse Pyaar","Iss Se Pyaar Kaise Karoon","Chak De Phattey"},
			                  {"Chak De Phattey","Din Din Gin Gin","Iss Se Pyaar Kaise Karoon","Ab Kya Karenge","Intezar Aitbaar Tumse Pyaar","Iss Se Pyaar Kaise Karoon","Chak De Phattey"},
			                  {"Chak De Phattey","Din Din Gin Gin","Iss Se Pyaar Kaise Karoon","Ab Kya Karenge","Intezar Aitbaar Tumse Pyaar","Iss Se Pyaar Kaise Karoon","Chak De Phattey"},
	                         };
	
	public Observable<Movie> getMovies(){
		return Observable.create(new Observable.OnSubscribe<Movie>() {
			@Override
			public void call(Subscriber<? super Movie> t) {
				for(int i=0;i<10;i++){
					Movie movie = new Movie();
					movie.setTitle(names[i]);
					t.onNext(movie);
				}
			}
		});
	}
	
	public Observable<Song> getSongs(Movie m){
		return Observable.create(new Observable.OnSubscribe<Song>() {
			@Override
			public void call(Subscriber<? super Song> t) {
				String[] sngs = new String[songs[2].length];
				sngs = songs[2];
				int i=0;
				for (String title : sngs) {
					try {
						i++;
						if (true || i % 2 == 0) {
							Song song = new Song();
							song.setTitle(title);
							t.onNext(song);
						} else {
							throw new RuntimeException();
						}
					} catch (Exception ex) {
						Song song = new Song();
						song.setError(new Error("Some issue"));
						t.onNext(song);
					}
				}
			}
		});
	}
	
	
	
}
