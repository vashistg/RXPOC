package com.gv.archaius;

import java.util.ArrayList;
import java.util.List;

public class MoneyMaker {
	public static void main(String[] args) {
		int[] trucks = {1,2,3,4,5};
		System.out.println(MoneyMaker.canPass(trucks));
	}
	
	public static boolean canPass(int[] trucks){
		List<Integer> sideLane = new ArrayList<Integer>();
		List<Integer> goThrough = new ArrayList<Integer>();
		for(int i=0;i<trucks.length;i++){
			if(canGoThrough(i,trucks)){
				goThrough.add(trucks[i]);
			}else {
				if(canGoToSideLane(trucks[i],sideLane)){
					sideLane.add(trucks[i]);
				}else{
					return false;
				}
			}
		}
		return goThrough.size() + sideLane.size() == trucks.length;
	}

	private static boolean canGoThrough(int i, int[] trucks) {
		return allTrucksLarger(i,trucks);
		
	}

	private static boolean canGoToSideLane(int currentTruck,List<Integer> sideLane) {
		
		if(allTrucksLargerinSideLane(currentTruck, sideLane)){
			return true;
		}
		return false;
	}
	
	private static boolean allTrucksLargerinSideLane(int currentTruck,List<Integer> sideLane) {
		boolean allLarger =true;
		for(int index=0;index<sideLane.size();index++){
			if(currentTruck > sideLane.get(index)){
				allLarger = false;
			}
		}
		return allLarger;
	}
	
	
	private static boolean allTrucksLarger(int currentTruck,int[] trucks) {
		boolean allLarger =true;
		for(int index=currentTruck;index<trucks.length;index++){
			if(trucks[currentTruck] > trucks[index]){
				allLarger = false;
			}
		}
		return allLarger;
	}
}
