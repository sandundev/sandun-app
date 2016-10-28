package com.sandun.java8.codility;

public class SelectSort {

	public static void main(String[] args) {
		int[] a = {12,4,7,3,11,5,67,43};
		printArray(getSorted(a));
	}
 
	public static int [] getSorted(int []  a){
	 

	 int newLowestIndex = 0;
		for (int i = 0; i < a.length; i++) { 
		 
			for (int j = a.length - 1; j >= i; j--) {
				if(a[i] > a[j]){
					newLowestIndex = j;
				}
			}
			int temp = a[i];
			a[i] = a[newLowestIndex];
			a[newLowestIndex] = temp;
			
			printArray(a);
		}
		return a;
	}
	
 
	private static void printArray(int[] sorted) {
		for (int i : sorted) {
			System.out.print(i + ",");
		}
		
		System.out.println();
	}
}
