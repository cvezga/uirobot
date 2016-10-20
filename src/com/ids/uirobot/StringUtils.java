package com.ids.uirobot;

public class StringUtils {
	
	
	
	public static String substringDelimited(String source, String tag1, String tag2){
		int idx1 = source.indexOf(tag1);
		int idx2 = source.indexOf(tag2, idx1 + tag1.length());
		if(idx1>-1 && idx1<idx2){
			return source.substring(idx1+tag1.length(),idx2).trim();
		}
		
		return null;
		
	}

}
