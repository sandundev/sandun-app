package com.sandun.personal.project.testing;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StockAlerter {

    public static final int BREAK = 65000;

    public static final String URL1 = "http://www.tesco.com/direct/search-results/results.page?catId=4294967294&searchquery=iphone+7+128gb&SrchId=4294967294";
    public static final String URL2 = "http://www.tesco.com/direct/apple-iphone-7-plus-128gb-gold/156-4936.prd?skuId=156-4936";
    public static final String URL3 = "http://www.tesco.com/direct/iphone-7-128gb-silver/273-6729.prd";
    
    public static void main(String [] args) throws Exception {
        String emailFlag1 = ""; 
        String emailFlag2 = ""; 
        while (true) {
        	try {
        		 Document doc = Jsoup.connect(URL1).timeout(1000*60).get();
           	  
              	 String [] models = {"Add iPhone 7 128GB Gold to Basket" ,
              			 "Add iPhone 7 128GB Gold to Basket", "Add iPhone 7 128GB Silver to Basket" };
              	 
            	emailFlag1 = sendEmail(emailFlag1, doc, models, URL1);
            	
             	 String [] stringToFind = {"Add to basket" };
             	 doc = Jsoup.connect(URL2).timeout(1000*60).get(); 	
             	 emailFlag2 = sendEmail(emailFlag2, doc, stringToFind , URL2);
             	 

             	 doc = Jsoup.connect(URL3).timeout(1000*60).get(); 	
             	 emailFlag2 = sendEmail(emailFlag2, doc, stringToFind , URL3);
            	
        	     Thread.sleep(BREAK);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    
    }
	private static String sendEmail(String emailFlag, Document doc, String[] models , String url) {
		try{
   
		 
		 String docString = doc.html().toLowerCase();
		 boolean sendNew = false;
		 StringBuilder email = new StringBuilder();
		 for (String model : models) {
			if(docString.contains(model.toLowerCase())){
				sendNew = true;
				email.append(model);
				email.append(System.lineSeparator());
				email.append(url);
			}
		 }
		 
		 if(sendNew && !emailFlag.toString().equals(email.toString())){
			emailFlag = email.toString();
			 System.out.println(new Date() +System.lineSeparator()+  " --- Email >>> "+ email);
			 CrunchifyJavaMailExample.generateAndSendEmail(email.toString());
		 }else{
			 System.out.println(new Date() +System.lineSeparator()+" --- already sent!");
		 }
		     
	
		     
		}catch(Exception ex){
		
			System.out.println("error!!!");
		}
		return emailFlag;
	}
}
