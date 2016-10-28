package com.sandun.java8.codility.test.oddoc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OddOccurrencesInArrayTest {
	/**
	 * Created by yaodh on 2014/12/13.
	 * 1. OddOccurrencesInArray
	 * Find value that occurs in odd number of elements.
	 * Task description
	 * A non-empty zero-indexed array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
	 * For example, in array A such that:
	 * A[0] = 9  A[1] = 3  A[2] = 9
	 * A[3] = 3  A[4] = 9  A[5] = 7
	 * A[6] = 9
	 * the elements at indexes 0 and 2 have value 9,
	 * the elements at indexes 1 and 3 have value 3,
	 * the elements at indexes 4 and 6 have value 9,
	 * the element at index 5 has value 7 and is unpaired.
	 * Write a function:
	 * class Solution { public int solution(int[] A); }
	 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
	 * For example, given array A such that:
	 * A[0] = 9  A[1] = 3  A[2] = 9
	 * A[3] = 3  A[4] = 9  A[5] = 7
	 * A[6] = 9
	 * the function should return 7, as explained in the example above.
	 * Assume that:
	 * N is an odd integer within the range [1..1,000,000];
	 * each element of array A is an integer within the range [1..1,000,000,000];
	 * all but one of the values in A occur an even number of times.
	 * Complexity:
	 * expected worst-case time complexity is O(N);
	 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
	 * Elements of input arrays can be modified.
	 */
	@Test
	public void getUnpairedOdd1(){
		OddOccurrencesInArray2 odd = new OddOccurrencesInArray2();
		int array [] = {9,3,9,3,9,7,9};
		assertEquals(7, odd.getUnpairedOdd(array));
		
	}
	
	@Test
	public void getUnpairedOdd2(){
		OddOccurrencesInArray2 odd = new OddOccurrencesInArray2();
		int array [] = {9,3,9,3,9,7,9,7,7,1,3,5,6,7};
		assertEquals(5, odd.getUnpairedOdd(array));
		
	}
}
