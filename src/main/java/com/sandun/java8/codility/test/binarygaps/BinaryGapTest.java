package com.sandun.java8.codility.test.binarygaps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryGapTest {

	@Test
	public void binaryGap_whenInput5_return1(){		
		BinaryGap gap = new BinaryGap();		
		assertEquals(1, gap.getBinaryGap2(5));		
	}
	
	@Test
	public void binaryGap_whenInput2_return0(){		
		BinaryGap gap = new BinaryGap();		
		assertEquals(0, gap.getBinaryGap2(2));		
	}
	
	@Test
	public void binaryGap_whenInput101_return2(){		
		BinaryGap gap = new BinaryGap();		
		assertEquals(2, gap.getBinaryGap2(101));		
	}
	
	@Test
	public void binaryGap_whenInput200_return1(){		
		BinaryGap gap = new BinaryGap();		
		assertEquals(2, gap.getBinaryGap2(200));		
	}
	
	@Test
	public void binaryGap_whenInput127804_return2(){		
		BinaryGap gap = new BinaryGap();		
		assertEquals(2, gap.getBinaryGap2(127804));		
	}
	
	@Test
	public void binaryGap_whenInput1278041_return2(){		
		BinaryGap gap = new BinaryGap();		
		assertEquals(8, gap.getBinaryGap2(1278041));		
	}
}
