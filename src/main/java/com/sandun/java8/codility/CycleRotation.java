package com.sandun.java8.codility;

public class CycleRotation {

	public static void main(String[] args) {
		//A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
		
	 	int A [] = {3, 8, 9, 7, 6} ;
	 	int[] xxx = solution(A, 1);
	 	for (int i : xxx) {
			System.out.print(i + ",");
		}
	}
	
	
	public static int[] solution(int[] A, int K) {

		if (K > 0) {
			int flag [] = new int [A.length]; 
			
			for (int i = 0; i < A.length; i++) {
 
				if(i == 0){
					flag[i] = A[A.length - 1];
				}else{
					flag[i] = A[i - 1];
				}
			}
			
			return solution(flag, K-1);
		}

		return A; 
    }
}
