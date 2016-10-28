package com.sandun.java8.codility;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] A = {9, 3, 9, 3, 9, 7, 9};
		System.out.println(solution(A));;
	}
	
	
	 public static int solution(int[] A) {
		 
		Set<Long> pairs = new HashSet<Long>();
		
		for (int i = 0; i < A.length; i++) {
			Long val = new Long(A[i]);
			
			if(!pairs.contains(val)){
				pairs.add(val);
			}else{
				pairs.remove(val);
			}
		}
		 
		return pairs.iterator().next().intValue();
	        // write your code in Java SE 8
	    }
}
