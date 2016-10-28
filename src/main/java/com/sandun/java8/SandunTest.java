package com.sandun.java8;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
 
public class SandunTest {

	public static int solution(int[] A) { 
		if(A.length == 0){
			return 1;
		}
		if(A.length == 1 & A[0] == 1){
			return 2;
		}

		Set<Long> items = new TreeSet<Long>();
		
		for (int i : A) {
			items.add((long) i);
		}
		
		Iterator<Long> it = items.iterator();
		Long next = 0L ;
		Long nextNext = next;
		while(it.hasNext()){
			next = it.next();
			
			if(it.hasNext()){
				nextNext = it.next();
			}	
			
			if(!it.hasNext()){
				if(next.equals((long)(items.size()-1))){
					return 	(int) (next+ 2);
				} 
			}
			
			if(nextNext > 0 && !nextNext.equals(next+ 1)){
			return 	(int) (next+ 1);
			}
			
			 
		}
		 
		return -1;
	}

	public static void main(String[] args) {
		int[] A  = {2,3,1,5};
		System.out.println(solution(A));
	}
	 
}
