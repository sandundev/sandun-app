package com.sandun.java8.codility.perm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermMissingElemTest {

	@Test
	public void test(){
		 PermMissingElem element = new PermMissingElem();
		 
		 assertEquals(4, element.getMissingValue(new int [] {2,3,1,5}));
	}
}
