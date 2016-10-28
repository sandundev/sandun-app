package com.sandun.java8;

import java.util.Arrays;

public class MyList {

	private Object [] elements;
	
	 private int size = 0;
	  private static final int DEFAULT_CAPACITY = 5;
 
	  public MyList() {
	    elements = new Object[DEFAULT_CAPACITY];
	  }

	
	public Object get(int i){
		return elements [i];
	}
	

	private void add(Object object) {
		ensureCapacity();
		elements[size] = object;
		size = size + 1;
	}
	
	private void ensureCapacity() {
		if(size == elements.length){
			elements = Arrays.copyOf(elements, size * 2);
		}
	}


	public static void main(String[] args) {
		MyList myList = new MyList();
		myList.add(new Long(1L));
		myList.add(new Long(2L));
		myList.add(new Long(3L));
		myList.add(new Long(6L));

		System.out.println(myList.get(13));
		System.out.println(myList.size);
	}


}
