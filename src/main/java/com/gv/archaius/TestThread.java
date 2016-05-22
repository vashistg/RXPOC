package com.gv.archaius;

public class TestThread {
	public static synchronized void printName(){
		System.out.println("print name");
		try {
			Thread.sleep(5000);
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void printValue(){
		System.out.println("print value");
	}
	
	public static void main(String[] args) {
		
		
	}
	
}
