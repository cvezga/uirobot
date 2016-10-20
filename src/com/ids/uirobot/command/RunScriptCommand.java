package com.ids.uirobot.command;

import com.ids.uirobot.ProcessRunnable;

public class RunScriptCommand implements Command {

	@Override
	public void runCommnand(String command) {
		int idx1 = command.indexOf(" ");
		String scriptname = command.substring(idx1+1).trim();
		
		new Thread( new ProcessRunnable(scriptname)).start();
		
		 		
	}

	@Override
	public boolean isThisCommand(String command) {
		return command.startsWith(":runscript ");
	}

}
