package com.ids.uirobot.command;

import com.ids.uirobot.StringUtils;

public class SleepCommand implements Command {

	@Override
	public void runCommnand(String command) {
		String sleepTime = StringUtils.substringDelimited(command, "(", ")");
		
		long s = Long.parseLong(sleepTime);
		
		
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean isThisCommand(String command) {
		return command.startsWith(":sleep(");
	}

}
