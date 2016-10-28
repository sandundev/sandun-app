package com.sandun.java8.codility.frogjump;

public class FrgJump {

	public int solution(int a, int b, int c) {
		int devision = Math.abs((a - b))/c;
		if(Math.abs((a - b))%c > 0){
			return devision + 1;
		}
		return devision;
	 
	}

}
