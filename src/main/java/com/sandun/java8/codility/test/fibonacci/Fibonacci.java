package com.sandun.java8.codility.test.fibonacci;

public class Fibonacci {

	public int getFib(int i) {

		// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
		
		if(i == 1){
			return 0;
		}
		if(i == 2){
			return 1;
		}

		return getFib(i - 1) + getFib(i- 2);
	}

}
