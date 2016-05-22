package com.gv.callable;

public class FlightResponse {
	String fltNum;
	String airlinecode;
	double fare;

	public String getFltNum() {
		return fltNum;
	}

	public void setFltNum(String fltNum) {
		this.fltNum = fltNum;
	}

	public String getAirlinecode() {
		return airlinecode;
	}

	public void setAirlinecode(String airlinecode) {
		this.airlinecode = airlinecode;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "FlightResponse [fltNum=" + fltNum + ", airlinecode=" + airlinecode + ", fare=" + fare + "]";
	}
	
	

}
