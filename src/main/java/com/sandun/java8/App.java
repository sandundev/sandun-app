package com.sandun.java8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private final static SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
	
	  public static void main(String[] args) throws ParseException {
		  
		  
		  String abc = "abcdefghijklmnopqrstuvwxyz";
		  
		  char [] chars = abc.toCharArray();
		  
		  StringBuilder sb = new StringBuilder();
		  
		  for (int i = chars.length-1; i >=0 ; i--) {
			sb.append(chars[i]);
		  }
		  System.out.println(sb.toString());
		  
		  List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		  
		  Collections.sort(names, (a,  b) -> b.compareTo(a));
		  
		///Library/Java/JavaVirtualMachines/jdk1.8.0_31.jdk/Contents/Home/src.zip  
	
		  ArrayList<String> strs1 = new ArrayList<String>();
		
		  LinkedList<String> strs2 = new LinkedList<String>();
	 
		  LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		  linkedHashSet.add("");
		  LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		 
		  
		  TreeSet<String> TreeSet = new TreeSet<String>();
		   
		  strs1.forEach(System.out::println);

		  System.out.println("sandun...");

		  System.out.println(getNearestMondayForADate("09/02/2016"));
	  }
	  
	  
		
		public static String getNearestMondayForADate(String lastDateToPlay) throws ParseException {
			Date date = dateFormater.parse(lastDateToPlay);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
			
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
				return lastDateToPlay;
			}else{
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				if(calendar.get(Calendar.DAY_OF_YEAR) > dayOfYear){
					calendar.set(Calendar.DAY_OF_YEAR, (calendar.get(Calendar.DAY_OF_YEAR) - 7));					
				}
			}
			
			return dateFormater.format(calendar.getTime());
		}
	  
	static  int monthNameToDays(String s) {
		  switch(s) {
		  case "April": case "June":
		  case "September": case "November":
		  return 30;
		  case "January": case "March":
		  case "May": case "July":
		  case "August": case "December":
		  return 31;
		  case "February":  
			  return 28;
		  default: return 300;
		  }
}
}