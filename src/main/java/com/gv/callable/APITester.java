package com.gv.callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;

public class APITester {

	@Test
	public void compareAPIs(){
		/**
		 * Create pool
		 * create two callables
		 * submit callables
		 * get result
		 * compare
		 * send response
		 */
		ExecutorService pool =  Executors.newFixedThreadPool(2);
		
		Future<FlightResponse> oldAPIFuture = pool.submit(new OlpAPI());
		Future<FlightResponse> newAPIFuture = pool.submit(new NewAPI());
		
		try {
			FlightResponse oldResponse = oldAPIFuture.get();
			FlightResponse newResponse = newAPIFuture.get();
			
			//Comparison Logic
			System.out.println("OLD ::"+oldResponse);
			System.out.println("NEW ::"+newResponse);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
