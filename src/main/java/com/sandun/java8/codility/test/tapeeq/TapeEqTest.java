package com.sandun.java8.codility.test.tapeeq;

import static org.junit.Assert.*;

import org.junit.Test;

public class TapeEqTest {

	@Test
	public void test() {
		TapeEq tape = new TapeEq();
		int a [] = {3,1,2,4,3};
		assertEquals(1, tape.getMinimum(a , a.length));
	}

}
