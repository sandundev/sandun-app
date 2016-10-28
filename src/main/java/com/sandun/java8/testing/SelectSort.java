package com.sandun.java8.testing;

public class SelectSort {

	public static void main(String[] args) {
		int x [] = {2,19,7,3,6, 8882,4567,9568,23,4,98231};
		// 3,7,19,6
		// 3,6,7,19

		 
		int left = 	Integer.MAX_VALUE;	
		 
		int right = 	Integer.MAX_VALUE;		
		for (int i = 0; i < x.length; i++) {
		 
			for (int j = i+1; j < x.length; j++) {
				if(x[j] < x[i]){
					left = x[j];
					right = x[i];
					 x[i] = left;
					 x[j] = right;
					 printArray(x);
				}
			}
	
		}
		
		printArray(x);
	}

	private static void printArray(int[] sorted) {
	for (int i : sorted) {
		System.out.print(i+",");
	}

	System.out.println();
	}
}
