package com.ids.uirobot.command;

public interface Command {
	
	void runCommnand(String command);
	
	boolean isThisCommand(String command);

}
