package com.sandun.java8.codility;


public class BinaryGaps {

	public static void main(String[] args) {
		int  bi = getBinaryGap(17243);
	 System.out.println(bi);
	}

	public static int getBinaryGap(int value) {
		if(value == 0){
			return 0;
		}
		if(value == 1){
			return 0;
		}
		
		long[] flag = new long[1000];

		int index = 0;
		while (value / 2 > 0) {
			flag[index] = value % 2;
			value = value / 2;
			
			++index;
			
			if (value == 1) {
				flag[index] = 1;
			}
		}

		long[] binary = new long[index+1];

		for (int i = 0 ; i<= index ; i++) {
			binary[i] = flag[index-i];
		}
		
		long maxGap = 0;
		long thisGap = 0;
		for (long i : binary) { 
			if(i == 0){
				thisGap++;
			}else{
				if(thisGap > maxGap){
					maxGap  = thisGap;
				}
				thisGap = 0;
			}
		}

		return (int) maxGap;
	}
}
