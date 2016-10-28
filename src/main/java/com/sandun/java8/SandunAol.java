package com.sandun.java8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
 
public class SandunAol  {
		int count = 0;
	 public static void main(String [] args) {
		 new SandunAol().start();
	 }

	private void start() {
	    synchronized(SandunAol.class){
	       
			this.count += 3;   
	     }
	} 
 
}
