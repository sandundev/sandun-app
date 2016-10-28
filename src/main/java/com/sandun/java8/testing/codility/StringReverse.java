package com.sandun.java8.testing.codility;

public class StringReverse {

	

	  
StringReverse(){
	String name = "sandun";
	char[] nameChars = name.toCharArray();
	char[] nameChars1 = new char[nameChars.length];
	
	for (int i = nameChars.length - 1; i >=0; i--) {
		nameChars1[nameChars.length - 1 - i] = nameChars[i];
	}
	name = "sandun";
}
	

}
