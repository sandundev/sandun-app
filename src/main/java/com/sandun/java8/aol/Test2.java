package com.sandun.java8.aol;

public class Test2 {

	public static void main(String[] args) {
 
        int[] a = {0,0,0,1,0,1,1,0,1,0, 0};
		  System.out.println(solution(a));
    
	}
 
	 public static int solution(int[] A) {
		 
		 
	        if (A == null || A.length == 0) {
	            return 0;
	        }
	        
	        for (int i = 1; i < A.length - 1; i++) {
	            if (A[i - 1] != A[i] && A[i] != A[i + 1]) {
	                A[i] = getOpp(A[i]);
	                return getMax(A);
	            }
	        }
	        
	        for (int i = 1; i < A.length - 1; i++) {
	            if (A[i - 1] == A[i] && A[i] != A[i + 1]) {
	            	
	                A[i + 1] = getOpp(A[i + 1]);
	                return getMax(A);
	            } else if (A[i - 1] != A[i] && A[i] == A[i + 1]) {
	            	  A[i - 1] = getOpp(A[i - 1]);
	                return getMax(A);
	            }
	        }
	        
	        A[0] = getOpp(A[0]);
	        
	        return getMax(A);
	    }
	    
	
	 private static int getOpp(int i) {
		 return	(i == 1) ?  0 :   1;
	 
	}
 
	private static int getMax(int[] A) {
	        int max = 0;
	        for (int i = 1; i < A.length; i++) {
	            if (A[i - 1] == A[i]) {
	                max++;
	            }
	        }
	        return max;
	    }
}
