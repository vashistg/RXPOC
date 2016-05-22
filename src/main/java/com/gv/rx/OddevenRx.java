package com.gv.rx;

import java.util.List;

import rx.Observable;

public class OddevenRx {
	public static void main(String[] args) {
		Observable<Integer> odds = Observable.just(1, 3, 5, 7, 9);
		Observable<Integer> evens = Observable.just(2, 4, 6);
		Observable
		    .zip(odds, evens, (v1, v2) -> (v1+ "," +v2))
		    .subscribe(System.out::println);
		
		Observable
	    .merge(odds, evens)
	    .subscribe(System.out::println);
		
		List<String> names = null;
	}

}
