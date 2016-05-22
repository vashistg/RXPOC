package com.gv.rx;

import rx.Observable;
import rx.Subscriber;

public class Cell {
    int value =0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Observable<Integer> valueObservable() {
	    return Observable.just(value);
	}
	
	public Observable<Integer> deferValueObservable() {  
		  return Observable.defer(() -> Observable.just(value));
	}
	
	
	public Cell mulitply(int factor){
		value = value *factor;
		return this;
	}
	
	
	@Override
	public String toString() {
		return "Cell [value=" + value + "]";
	}

	public static void main(String[] args) {
		Cell cell = new Cell();
		Observable<Integer> obsInt = cell.valueObservable();
		Observable<Integer> obsDeferInt = cell.deferValueObservable();
		cell.setValue(100);
		obsInt.subscribe(System.out::println);
		obsDeferInt.subscribe(new Subscriber<Integer>() {

			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable e) {
			}

			@Override
			public void onNext(Integer t) {
				System.out.println(t *5);
				
			}
		})	;
		
		cell.setValue(100);
		cell.setValue(200);
		cell.setValue(300);
		
		
	}
}


