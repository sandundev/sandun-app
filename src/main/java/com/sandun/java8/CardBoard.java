package com.sandun.java8;

public class CardBoard{
	Short story = 200;
	
	CardBoard go (CardBoard cb){
		cb.story = 100;
		cb = null;
		return cb;
	}
	
	public static void main(String[] args) {
		
		CardBoard c1 = new CardBoard();
		CardBoard c2 = new CardBoard();
		CardBoard c3 = c1.go(c2);
 
	}
	
}