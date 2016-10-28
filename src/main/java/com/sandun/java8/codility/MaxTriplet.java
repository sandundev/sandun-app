package com.sandun.java8.codility;

import java.util.Arrays;


public class MaxTriplet {

	public static void main(String[] args) {
		int a [] = {1,2,4};
		System.out.println(getMaxTriplet(a));
	}

	private static int getMaxTriplet(int[] a) {
		if(a.length < 3){
			return 0;
		}
		Arrays.sort(a);
		long maxProduct = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1 ; j >= i; j--) {
				  
			}
		}
		return (int) maxProduct;
	}
	
	
}
