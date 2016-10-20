package com.ids.uirobot;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

public class Variables {

	private static Map<String, Object> variableMap = new HashMap<String, Object>();
	
	public static Rectangle r; //Last Image Found Position

	static {
          variableMap.put("$_timeout", 5000);
	}

	
	public static void put(String varname, Object varvalue){
		variableMap.put(varname,varvalue);
	}
	
	public static Object get(String varname){
		return variableMap.get(varname);
	}
}
