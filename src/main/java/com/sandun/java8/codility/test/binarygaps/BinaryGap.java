package com.sandun.java8.codility.test.binarygaps;

public class BinaryGap {

	public int getBinaryGap(int i) {
		int maxGapCount = 0;
		int currentCount = 0;
		if(i/2 == 1){
			return maxGapCount;
		}
		
		while(i/2 > 0){
			if(i%2 == 0){
				currentCount++;
			}
			maxGapCount = (currentCount > maxGapCount) ? currentCount : maxGapCount;
			if(i%2 == 1){
				currentCount = 0;
			}
			i = i/2;
		}
		
		return maxGapCount;
	}


	

	public int getBinaryGap2(int i) {
		int maxGapCount = 0;
		int currentCount = 0;
		//ignore leading and trailing 0s
		boolean beginCount = false;
		while (i / 2 > 0) {
			if (i % 2 == 0 && beginCount) {
				currentCount++;
			}
			maxGapCount = (maxGapCount > currentCount) ? maxGapCount : currentCount;

			if (i % 2 == 1) {
				beginCount = true;
				currentCount = 0;
			}

			i = i / 2;
		}
	 
		return maxGapCount;
	}

}
