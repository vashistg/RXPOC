package com.gv.hystrix;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class HelloWorldCommand extends HystrixCommand<String> {

	boolean fail = false; 
		
	public HelloWorldCommand() {
		super(HystrixCommandGroupKey.Factory.asKey("HelloWorld"));
    }

	public HelloWorldCommand(boolean failDecision) {
    	super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorld"))
        		.andCommandPropertiesDefaults(
        		      HystrixCommandProperties.Setter()
                .withCircuitBreakerEnabled(true)
                .withCircuitBreakerRequestVolumeThreshold(3)
                ));
        this.fail = failDecision;
    }

    @Override
    protected String run() throws Exception {
    	System.out.println("Run called.circuit breaker on :: "+ this.isCircuitBreakerOpen());
    	if(fail){
    		throw new RuntimeException("Fail Condiiton reached");
    	}else{
           return "Hello World";
    	}
    }
    
    @Override
    protected String getFallback() {
    	//System.out.println("Circuit Breaker on fallback:: "+ this.isCircuitBreakerOpen());
        return "Circuit Breaker on fallback:: "+ this.isCircuitBreakerOpen();
    }
    
    public static void main(String[] args) {
		for(int i=0;i<10;i++){
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String output = new HelloWorldCommand(i%2==0).execute();
			System.out.println(output );
		}
	}
}