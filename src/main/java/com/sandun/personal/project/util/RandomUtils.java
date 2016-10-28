package com.sandun.personal.project.util;

import java.util.Date;
import java.util.Random;

public class RandomUtils {
 
	private static Random random = new Random();
	
	public static String getRandomMD5SUM(){
		return MD5(new Date().getTime()+"").substring(0, 15)+MD5(random.nextLong()+"hash").substring(0, 17);
	}
	
	public static String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
}
