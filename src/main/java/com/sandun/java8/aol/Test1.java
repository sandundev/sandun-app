package com.sandun.java8.aol;

public class Test1 {

	public static void main(String[] args) {
	//	System.out.println();

		 int x = solution("A0BaX3fdffve4");
		 
		 System.out.println(x);
	}

	private static int solution(String string) {
		  StringBuilder longestPassword = new StringBuilder();
		
		char[] chars = string.toCharArray();
		StringBuilder tempString = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if(!Character.isDigit(chars[i])){
				tempString.append(chars[i]); 
			}else{
				tempString = new StringBuilder();
			}
			
			if(tempString.length() > longestPassword.length() && !tempString.toString().toLowerCase().equals(tempString.toString())){
				longestPassword = tempString;
			}
		}
		
		return longestPassword.length();
	}

}
