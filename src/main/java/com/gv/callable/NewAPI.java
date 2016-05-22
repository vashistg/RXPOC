package com.gv.callable;
import java.util.concurrent.Callable;

public class NewAPI implements Callable<FlightResponse>{

	@Override
	public FlightResponse call() throws Exception {
		FlightResponse oldResponse = new FlightResponse();
		oldResponse.setAirlinecode("G8");
		oldResponse.setFare(3500);
		oldResponse.setFltNum("123");
		return oldResponse;
	}

}
