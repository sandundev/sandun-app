package com.sandun.java8.codility;

import java.util.Arrays;

public class Triangle {

	
	   public int solution(int[] A) {

		    if(A.length < 3){
		        return 0;
		    }
		      Arrays.sort(A);
		      
		     for(int i = 0 ; i < A.length -2 ; i++){
		         if(A[i] > 0 && A[i] > A[i + 2] - A[i+1] ){
		        return 1;
		        } 
		    }
		        return 0;
		      
		    }
}
