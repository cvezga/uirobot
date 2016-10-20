package com.ids.uirobot;

public class Timer {

	private long start;
	
	public Timer(){
		this.start = System.currentTimeMillis();
	}
	
	
	public long getElapsedTime(){
		return System.currentTimeMillis() - this.start;
	}
}
