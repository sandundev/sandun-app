package com.sandun.java8.aol;

public class Test3 {

	public static void main(String[] args) {

	System.out.println(getBill());  

	}

	private static int getBill() {
		String log = "00:05:07,400-234-090" ;
	      
	      String [] logLine = log.split("/r/n");
			  long total = 0;
			  
			  long longestDuration = 0;
			  String longestCallDurationNumber = "";
		    for(String s : logLine){
		    	String callDuration = s.split(",")[0];
		    	int callLengthInSec = callLengthInSec(callDuration);
		    	
		    	if(longestDuration < callLengthInSec  ){
		    		longestDuration =  callLengthInSec;
		    		longestCallDurationNumber = s.split(",")[1].replaceAll("-", "");
		    	}else if(longestDuration == callLengthInSec){
		    	  
		    	}
                if(callLengthInSec < 5 * 60){
                	total = total + (callLengthInSec * 3);
                    }else if (callLengthInSec >= 5 * 60){
                        if(callLengthInSec % 60 == 0 ){
                        	total = total + (callLengthInSec/ 60 * 150);	
                        }else{
                        	total = total + (callLengthInSec/ 60 * 150) + 150;	
                        }
                 
                } 
	  
		  }
		    total = total - 2;
		  return (int) total;
	}

	private static int callLengthInSec(String s) {
		 int hours = Integer.parseInt(s.split(":")[0]);
		 int mins =  Integer.parseInt(s.split(":")[1]);
		 int secs =  Integer.parseInt(s.split(":")[2]);
		 
		return (hours * 60 * 60) + mins*60 + secs;
	}

}
