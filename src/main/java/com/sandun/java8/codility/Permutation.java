package com.sandun.java8.codility;

import java.util.HashSet;
import java.util.Set;
 
public class Permutation {
	
	public static void main(String[] args) {
		
		final int[] A = {1, 4, 1}; 
		
		System.out.println(solution(A));
	}
	
	private static int solution(int[] A) {
	
		Set<Long> items = new HashSet<Long>();
		for (int i : A) {
			items.add((long) i);
		}
		
		if(items.size() == A.length){
			long n = A.length;
			long total = n * (n + 1)/2;
			
			for (Long i : items) {
				total -= i;
			}
			
			if(total == 0){
				return 1;
			}
		}
		return 0; 
	}

	public static int solution1(int A []){
		
		long n = A.length;
		long total = n * (n + 1)/2;
		
		for (int i : A) {
			total -= i;
		}
		
		if(total == 0){
			return 1;
		}
		return 0;
	}
}
