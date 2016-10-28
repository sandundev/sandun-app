package com.sandun.java8.testing;
/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.

Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).
 *
 */
public class BinaryGaps {

	public static void main(String[] args) {
		System.out.println(new BinaryGaps().solution(6));
		int xxxx = 22%2;
		System.out.println(xxxx);
	}
	 public int solution(int n){
		 char [] binary = getBinary(n);
		 
		 int maxGap = 0;
		 int tempGap = 0;
		 for (int i = 0; i < binary.length; i++) {
			if(binary[i] == '0'){
				tempGap++;
			}else{
				if(tempGap > maxGap){
					maxGap = tempGap;
				}
				
				tempGap = 0;
			}
	 
		
		 
			
		 }
		 return maxGap;
	 }
	private char[] getBinary(int n) {
		 String x = "";
		
		 while (n/2 > 0) {
			  if(n%2  == 0 ){
				  x = x+ 0;
			  }else{
				  x = x+1;
			  }
			  n = n/2;
			  if(n == 1){
				  x = x+1; 
			  }
		}
		 return	  new StringBuilder(x).reverse().toString().toCharArray();
	 
	}
}
