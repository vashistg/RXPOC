package com.gv.rx.chainingApis;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.observers.TestSubscriber;

public class Aggregator {

	public static void main(String[] args) {
		final String[] names = {"Forrest Gump","Cast Away","Departed","Khosla Ka Ghosla","3 Idiots","Tare Zameen Par","Inception","Guru","Lage Raho Munna Bhai"};
		MDB mdb = new MDB();
		Observable<Song> sObservable =  mdb.getMovies().timeout(2500,TimeUnit.MILLISECONDS).take(3).
		flatMap(movie -> {
		  return mdb.getSongs(movie);
		})/*.subscribeOn(Schedulers.io())*/;
		
		sObservable.subscribe(new Subscriber<Song>() {
			@Override
			public void onCompleted() {
			}
			
			@Override
			public void onError(Throwable e) {
				System.out.println("Terminal Error handled in this block");
			}
			
			@Override
			public void onNext(Song t1) {
				if(t1.getError()==null){
					System.out.println(t1.getTitle());
				}else{
					System.out.println("Not Terminal Error but acceptable error.");
				}
				System.out.println("Thread ######################################  "+Thread.currentThread().getName());
			}
		});
	
	
		TestSubscriber<Song>  test = new TestSubscriber<Song>(); 
		sObservable.subscribe(test);
	
	}
	
	
}
