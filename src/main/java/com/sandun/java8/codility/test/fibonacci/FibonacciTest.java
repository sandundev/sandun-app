package com.sandun.java8.codility.test.fibonacci;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibonacciTest {
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
	
	@Test
	public void testFib1(){
		Fibonacci fb = new Fibonacci();
		assertEquals(0, fb.getFib(1));
	}
	
	@Test
	public void testFib2(){
		Fibonacci fb = new Fibonacci();
		assertEquals(1, fb.getFib(2));
	}

	@Test
	public void testFib3(){
		Fibonacci fb = new Fibonacci();
		assertEquals(5, fb.getFib(6));
	}
	@Test
	public void testFib4(){
		Fibonacci fb = new Fibonacci();
		assertEquals(8, fb.getFib(7));
	}	
	
}
