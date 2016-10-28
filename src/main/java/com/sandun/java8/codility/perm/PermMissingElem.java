package com.sandun.java8.codility.perm;

public class PermMissingElem {

	public int getMissingValue(int[] a) {
		int total = 0;
		for (int i : a) {
			total += i;
		}
		
		int totalShouldBe = getShouldBeCount(a.length + 1);
		return totalShouldBe - total;
	}

	private int getShouldBeCount(int length) {
		int count = 0;
		for (int i = 0; i <= length; i++) {
			count += i;
		}
		return count;
	}

}
