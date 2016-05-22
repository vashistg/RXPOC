package com.gv.archaius;

import java.util.ArrayList;
import java.util.List;

public class GCDCalc {
public static void main(String[] args) {
	String[] friends = {"YNNNN","YYYN","NYYN","NNNY"};
	System.out.println(friendCircle(friends));
}

	private static int findGCD(int number1, int number2) { // base case
		if (number2 == 0) {
			return number1;
		}
		return findGCD(number2, number1 % number2);
	} 
	
	
	static int friendCircle(String[] friends ){
		int numOfFriends = friends.length;
		List<List<Integer>> friendCircles = new ArrayList<>();
		int[] myFirstCircle = new int[numOfFriends];
		for(int i=0;i<numOfFriends;i++){
			myFirstCircle[i]=-1;
		}
		
		for (int i = 0; i < numOfFriends; i++) {
			if (myFirstCircle[i]==-1) {
				char[] myFriends = friends[i].toCharArray();
				List<Integer> myFriendList = new ArrayList<>();
				myFriendList.add(i);
				for (int j = 0; j < numOfFriends; j++) {
					if (myFriends[j] == 'Y' && j != i) {
						if(myFirstCircle[j]==-1){
							myFriendList.add(j);
							myFirstCircle[j]=i;
						}else{
							friendCircles.get(myFirstCircle[j]).add(j);
							for(int fr:myFriendList){
								if(!friendCircles.get(myFirstCircle[j]).contains(fr)){
								   friendCircles.get(myFirstCircle[j]).add(fr);
								}
							}
							myFriendList.clear();
							
						}
					}
				}
				if(myFriendList!=null && myFriendList.size()>0)
				  friendCircles.add(myFriendList);
			}
		}
		return friendCircles.size();
	}

}
