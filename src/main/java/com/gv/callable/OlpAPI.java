package com.gv.callable;
import java.util.concurrent.Callable;

public class OlpAPI implements Callable<FlightResponse>{
	@Override
	public FlightResponse call() throws Exception {
		FlightResponse oldResponse = new FlightResponse();
		oldResponse.setAirlinecode("G8");
		oldResponse.setFare(3000);
		oldResponse.setFltNum("123");
		return oldResponse;
	}
}
