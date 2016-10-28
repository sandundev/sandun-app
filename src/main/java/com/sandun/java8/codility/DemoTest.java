package com.sandun.java8.codility;

public class DemoTest {

	public static void main(String[] args) {
		int[] A = {2,3,7,4,1};
		System.out.println(solution(A ));
	}
	
	 public static int solution(int[] A) {
	       long total = 0; 
		 for (int i : A) {
			 total += i;
		}
		 if(A.length == 1 && total == 0){
			 return -1;
		 }
		
		 long lsum = 0;
		 for (int i = 0; i < A.length; i++) { 
			 lsum += A[i];
			if((total - lsum - lsum + A[i])  == 0){
				return 1;
			}
			 
			
		 }
		 
		 return -1;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void printArray(int[] sorted) {
		for (int i : sorted) {
			System.out.print(i + ",");
		}
		
		System.out.println();
	}
}
