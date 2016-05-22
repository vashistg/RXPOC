package com.gv.archaius;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test implements Runnable{
	
	/*static int j=func1();
	static int i=10;
	private static int func1() {
		// TODO Auto-generated method stub
		return i;
	}
	
	public static void main(String[] args) {
		System.out.println("i="+i);
		System.out.println("j="+j);
	}*/
	
	int x=0,y=0;
	int addx(){x++; return x;}
	int addy(){y++; return y;}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.print(addx()+" "+addy());
		}
	}
	
	public static void main(String[] args) {
		/*HashSet mySet = new HashSet();
		String s1=new String("shagun");
		String s2=new String("shagun");
		mySet.add(s1);
		mySet.add(s2);
		System.out.println(mySet);*/
		
		/*Set s = new TreeSet();
		s.add("7");
		s.add(9);
		Iterator it = s.iterator();
		while (it.hasNext()) {
			System.out.println(it.next()+" ");
		}*/
		Test run1 = new Test();
		Test run2 = new Test();
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run2);
		t1.start();
		t2.start();
	}
	

}
