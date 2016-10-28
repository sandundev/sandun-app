package com.sandun.java8.codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	public static void main(String[] args) {

		int[] A = { 2, 1, 2, 2 };

		System.out.println(solution(2, A));
	}

	public static int solution(int X, int[] A) {

		Set<Long> steps = new HashSet<Long>();

		for (int i = 0; i < A.length; i++) {
			steps.add((long) A[i]);
			if (allPreviousStepsVisited(steps, X)) {
				return i;
			}

		}

		return -1;

	}

	public static boolean allPreviousStepsVisited(Set<Long> steps, int x) {
		if (steps.size() < x) {
			return false;
		}
		for (int i = 1; i <= x; i++) {
			boolean contains = steps.contains(new Long(i));
			if (!contains) {
				return contains;
			}
		}
		return true;
	}
}
