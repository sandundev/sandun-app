package com.sandun.java8.testing.codility;
/**
 * 
A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is also moved to the first place.

For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times; that is, each element of A will be shifted to the right by K indexes.

Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.


 *
 */
public class CyclicRotation {
	 
	private static final int[] A = {3, 8, 9, 7, 6} ;

	public static void main(String[] args) {
		int k = 3;
		printArray(solution(A, k));
	}
	
	public static int[] solution(int[] a, int k){
		//3, 8, 9, 7, 6
		//6, 3, 8, 9, 7
		
		if(k == 0){
			return a;
		}
		if(a.length == 0){
			return a;
		}
		int flag [] = new int[a.length];
		 
		for (int i = 0; i < a.length - 1; i++) {
			flag[i + 1] = a[i];
		}
		flag[0]  = a[a.length - 1];
		
		k = k - 1;
		
		if(k > 0){
			flag = solution(flag, k);
		}
		return flag;
	}
	
	
	private static void printArray(int[] sorted) {
		for (int i : sorted) {
			System.out.print(i + ",");
		}
		
		System.out.println();
	}
}
