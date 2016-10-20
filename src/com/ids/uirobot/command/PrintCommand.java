package com.ids.uirobot.command;

public class PrintCommand implements Command {

	@Override
	public void runCommnand(String command) {
		int idx1 = command.indexOf("(");
		int idx2 = command.lastIndexOf(")");
		if(idx1>-1 && idx1<idx2){
			String message = command.substring(idx1+1,idx2).trim();
			if(message.startsWith("\"") && message.endsWith("\"")){
				message = message.substring(1, message.length()-1);
			}
			System.out.println(message);
		}
		
	}

	@Override
	public boolean isThisCommand(String command) {
		return command.startsWith(":print(");
	}

}
