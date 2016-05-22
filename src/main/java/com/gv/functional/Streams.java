package com.gv.functional;

import java.util.Arrays;
import java.util.List;

public class Streams {
	public static void main(String[] args) {
		Integer[] numbers = {1,2,3,4,5,6,7,8,9};
		List<Integer> numlist = Arrays.asList(numbers);
		numlist.stream().map(i->i*5).filter(i->i%2==0).forEach(System.out::println);
	}
}
