package com.gv.archaius;

public class MazeRunner {

	public static int largestCycle(int[] edges, int N) {
		boolean[] visited = new boolean[N];
		/**
		 * As outgoing edge is only one. For any number S the next element will
		 * be at the Sth index. Keep going till you reach back to yourself.
		 */
		int maxHop = -1;
		int startPoint = -1;
		for (int i = 0; i < N; i++) {
			startPoint = edges[i];
			if (startPoint!=-1 && !visited[startPoint]) {
				visited[startPoint] = true;
				int nextPoint = edges[startPoint];
				if (nextPoint!=-1 && !visited[nextPoint] ) {
					visited[nextPoint] = true;
					/**
					 * Loop breaks if 
					 * 1) we find a match 
					 * 2) outgoing -1 case
					 */
					int hop = 1;
					while (nextPoint != -1 && (startPoint != nextPoint)) {
						nextPoint = edges[nextPoint];
						if(nextPoint!=-1){
						   visited[nextPoint] = true;
						   hop++;
						}
					}

					/**
					 * Just check if while loop 
					 * broke because of a loop condition.
					 * and then compare the hops with maxHop
					 */
					if (startPoint == nextPoint) {
						if (hop > maxHop) {
							maxHop = hop;
						}
					}
				}
			}
		}
		return maxHop;
	}

	public static void main(String[] args) {
		int[] edges = { 4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21, 22 };
		System.out.println(largestCycle(edges, 23));
	}

}
