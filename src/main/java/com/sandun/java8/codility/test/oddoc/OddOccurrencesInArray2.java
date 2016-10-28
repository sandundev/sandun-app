package com.sandun.java8.codility.test.oddoc;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray2 {

	public int getUnpairedOdd(int[] array) {

		Set<Integer> items = new HashSet<>();
		int unpairedOdd = 0;
		for (int i : array) {
			if (i % 2 == 1) {
				if(!items.contains(i)){
					items.add(new Integer(i));
					unpairedOdd = i;
				} 
				
			}
		}
		return unpairedOdd;
	}

}
