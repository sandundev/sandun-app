package com.sandun.java8.testing;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class testttt {

	
	
public static void main(String[] args) {

	int [][] ranges = {{1,2} , {100,200}  , {50,150}  , {10,21}  , {5,75} };
	
	TreeMap<Integer , Integer> map = new TreeMap<Integer, Integer>();
	
	for (int i = 0; i < ranges.length; i++) {
		map.put(ranges[i] [0] , ranges[i] [1]);
	}
	
	Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
	
	while (itr.hasNext()) {
		  Entry<Integer, Integer> next = itr.next();
		  Entry<Integer, Integer> nextNext = itr.next();
		  
		  if(nextNext.getKey() < next.getValue()){
			  
		  }
		  
	}

	System.out.println("x");
}
}
