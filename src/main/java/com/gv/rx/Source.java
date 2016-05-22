package com.gv.rx;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class Source {

	/**
	 * Verbose 
	 */
	Observable<String> myObservable = Observable.create(
		    new Observable.OnSubscribe<String>() {
		        public void call(Subscriber<? super String> sub) {
		            sub.onNext("Hello, GV!");
		        }
		    }
		);
	
	Observable<Integer> rangeObservable = Observable.range(0, 10);
	Subscriber<Integer> rangeSubscriber = new Subscriber<Integer>() {
	    public void onNext(Integer s) { System.out.println(s); }

	    public void onCompleted() { }

	    public void onError(Throwable e) { }
	};
	
	Subscriber<String> mySubscriber = new Subscriber<String>() {
	    public void onNext(String s) { System.out.println(s); }

	    public void onCompleted() { }

	    public void onError(Throwable e) { }
	};
	
    /**
     * Tacit
     * @param args
     */
	
	Observable<String> myObservableTacit = Observable.just("Hello, Succint!");
	Action1<String> onNextAction = new Action1<String>() {
	    public void call(String s) {
	        System.out.println(s);
	    }
	};
	
	
	public static void main(String[] args) {
		//oldTests();
		/*final CountDownLatch latch = new CountDownLatch(5);
		try {
			Observable.interval(1, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
				@Override
				public void call(Long counter) {
					latch.countDown();
					System.out.println("Got: " + counter + "Thread " + Thread.currentThread().getName());
				}
			});

			latch.await();
		} catch (Exception ex) {
				
		}*/
		
		String s="maharashtra";
		Set<Character>  characters = new LinkedHashSet<Character>();
		for(int i=0;i<s.length();i++){
			characters.add(s.charAt(i));
		}
		String o = "";
		for(Character c:characters){
			o=o.concat(String.valueOf(c));
		}
		System.out.println(o);
		
	}


	private static void oldTests() {
		/*Source src = new Source();
		src.myObservable.subscribe(src.mySubscriber);
		src.myObservableTacit.subscribe(src.onNextAction);

		*//**
		 * Chaining the method calls
		 * @param args
		 *//*
		Observable.just("Hello, Chained Hello World!").subscribe(new Action1<String>() {
			public void call(String s) {
				System.out.println(s);
			}
		});
		
		*//**
		 * Lambdas
		 *//*
		Observable.just("Hello, Lambda world!").subscribe(s -> System.out.println(s));
		
		*//**
		 * Applying some mutation on emitted values
		 * 
		 *//*
		Observable.just("Hello, Lambda Capital world!").
		map(s->s.toUpperCase()).
		subscribe(System.out::println);
		
		*//**
		 * Map takes a stream and can return data of similar or different type as an output
		 * for our subscriber to consume.
		 *//*
		Observable.from("Hello world! Multiple lengths My Length".split(" ")).
		skip(2).
		take(2).
		map(s->s.toUpperCase()).
		subscribe(System.out::println);*/
		
		/**
		 * Working on a list of observables
		 * We start with an array of observables
		 * Which produce another list of observables.
		 */
		Observable.from("Testing flat#map in#good gv".split("#")).
        flatMap(s -> {
			System.out.println(Thread.currentThread().getName());
			return Observable.from(s.split(" "));
		}).subscribeOn(Schedulers.newThread()).subscribe(System.out::println);
		//src.rangeObservable.skip(4).take(1).map(i->i*5).subscribe(src.rangeSubscriber);
	}
	
}