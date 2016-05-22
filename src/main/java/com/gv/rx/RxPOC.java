package com.gv.rx;

import rx.Subscriber;
import rx.subjects.*;

public class RxPOC {
	
	public void check(){
		Cell cell = new Cell();
		cell.setValue(10);
		
		PublishSubject<Cell> cellObs = PublishSubject.create();
		//cellObs.publish();
		/*Observable<Cell> cellObs = Observable.create(
			    new Observable.OnSubscribe<Cell>() {
			        public void call(Subscriber<? super Cell> sub) {
			            sub.onNext( cell);
			        }
			    }
			);*/
		
		Subscriber<Cell> cellSub1 = new Subscriber<Cell>() {
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
			}
			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onNext(Cell t) {
				System.out.println("in sub 1 "+t.getValue()*100);
				t.setValue(t.getValue()*2);
			}
		};
		
		Subscriber<Cell> cellSub2 = new Subscriber<Cell>() {
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onNext(Cell t) {
				System.out.println("in sub 2 " +t.getValue()*100);
			}
		};
		
		
		cellObs.subscribe(cellSub1);
		cellObs.subscribe(cellSub2);
		
		cell.setValue(20);
		//cellObs.publish();
		cellObs.onNext(cell);
		
		cell.setValue(30);
		cellObs.onNext(cell);
		
		cell.setValue(40);
		cellObs.onNext(cell);
		
		
		cell.setValue(50);
		cellObs.onNext(cell);
	}
	
	
public static void main(String[] args) {
	RxPOC poc = new  RxPOC();
	poc.check();
}
}
