package com.sandun.java8.codility;

public class FrogJump {

	public static void main(String[] args) {
		int steps = solution(1, 17, 5);
		
		System.out.println(steps);
	}

	  public static int solution(int X, int Y, int D) {
		  
		long distance =  Math.abs(X- Y);
		long remainder = distance % D;
		
		if(remainder == 0){
			return (int) (distance / D);
		}else{
			return (int) ((distance / D) + 1);
		}
		   
	    }
	  
	  
}
