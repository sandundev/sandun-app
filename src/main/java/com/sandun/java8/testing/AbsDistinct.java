package com.sandun.java8.testing;

import java.util.HashSet;
import java.util.Set;
 

public class AbsDistinct {

	
	public static void main(String[] args) {
		int[] a = {1,20,3,3,4,5,-9 , -2, 10,11,-4};
		solution(a);
		System.out.println(Math.abs(-10));
		System.out.println(Math.abs(10));
		System.out.println(Math.abs(Integer.MIN_VALUE + 1 ));
	}
	
	
	public static int solution(int[] a){
		Set<Integer> distinctValues = new HashSet<Integer>();
		for (int i : a) {
			distinctValues.add(Math.abs(i));
		}
		
		return distinctValues.size();
	}
}
