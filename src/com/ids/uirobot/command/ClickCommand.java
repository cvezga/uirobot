package com.ids.uirobot.command;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import com.ids.uirobot.StringUtils;
import com.ids.uirobot.Variables;

public class ClickCommand implements Command {

	@Override
	public void runCommnand(String command) {
		String px = StringUtils.substringDelimited(command, "(", ",");
		String py = StringUtils.substringDelimited(command, ",", ")");
		
		int x = (int) (Integer.parseInt(px) + Variables.r.getX());
		int y = (int) (Integer.parseInt(py) + Variables.r.getY());
		
		try {
			Robot robot = new Robot();
			
			robot.mouseMove(x, y);
			
			robot.mousePress(InputEvent.BUTTON1_MASK);
			
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean isThisCommand(String command) {
		return command.startsWith(":click(") && command.indexOf(",")>-1;
	}

}
