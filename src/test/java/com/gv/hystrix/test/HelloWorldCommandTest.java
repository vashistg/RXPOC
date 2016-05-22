
package com.gv.hystrix.test;


import static org.junit.Assert.assertEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.Test;
import com.gv.hystrix.HelloWorldCommand;
import rx.Observable;

public class HelloWorldCommandTest {
	/**
     * Sequential execution in the same thread.
     */
    /*@Test
    public void testSequentialExecution(){
    	String seqOutput = new HelloWorldCommand(false).execute();
    	assertEquals("success","Hello World", seqOutput);
    }
    
    
    *//**
     * Sequential execution in the different thread.
     *//*
    @Test
    public void testAsynchrnousExecution(){
    	Future<String> seqOutput = new HelloWorldCommand(false).queue();
    	try {
    		*//**
    		 * Can do some other task before we ask for the response from the thread.
    		 *//*
			assertEquals("success","Hello World", seqOutput.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void testAsynchrnousHotObservableExecution(){
    	*//**
    	 * Observable handling of the hystrix command.
    	 * Hot obseravble
    	 *//*
    	Observable<String> seqOutput = new HelloWorldCommand(false).observe();
    	seqOutput.subscribe(s->System.out.println(s));
    }
    
    
    @Test
    public void testAsynchrnousColdObservableExecution(){
    	*//**
    	 * Observable handling of the hystrix command.
    	 * Hot obseravble
    	 *//*
    	Observable<String> seqOutput = new HelloWorldCommand(false).toObservable();
    	seqOutput.subscribe(s->System.out.println(s));
    }
    
    
    @Test
    public void testFallbackExecution(){
    	*//**
    	 * Observable handling of the hystrix command.
    	 * Hot obseravble
    	 * 
    	 *//*
    	String seqOutput = new HelloWorldCommand(true).execute();
    	assertEquals("Fallback worked.", "Good Bye",seqOutput);
    }
    
    @Test
    public void testCircuitBreaker(){
    	for(int i=0;i<10;i++){
    	   String seqOutput = new HelloWorldCommand(true).execute();
    	   if(i<6){
    	      assertEquals("Fallback worked.", "Circuit Breaker is :: false",seqOutput);
    	   }
    	}
    }*/
}
