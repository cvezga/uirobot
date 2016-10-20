package com.ids.uirobot.command;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.ids.uirobot.ScreenCapture;
import com.ids.uirobot.SearchImage;
import com.ids.uirobot.StringUtils;
import com.ids.uirobot.Timer;
import com.ids.uirobot.Variables;

public class WaitForCommand implements Command {

	@Override
	public void runCommnand(String command) {
	
		BufferedImage image = getImageName(command);
		long timeout = getTimeout(command);
		
		Timer timer = new Timer();
		boolean found=false;
		while(timer.getElapsedTime() < timeout){
			try {
				BufferedImage screen = ScreenCapture.captureScreenAll();
				Rectangle r = SearchImage.search(screen, image);
				if(r!=null){
					Variables.r = r;
					found=true;
					break;
				}else{
					sleep(100);
				}
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(found){
			System.out.println("Image was found!" + command);
		}else{
			System.out.println("Image was not found! " + command);
		}
	}

	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private BufferedImage getImageName(String command) {
		String imageName =  StringUtils.substringDelimited(command, "(",",");
		return (BufferedImage) Variables.get(imageName);
	}

	private Long getTimeout(String command) {
		String timeout =  StringUtils.substringDelimited(command, ",",")");
		if(timeout.startsWith("$")){
			timeout = (String) Variables.get(timeout);
		}
		return Long.parseLong(timeout);
	}

	@Override
	public boolean isThisCommand(String command) {
		return command.startsWith(":waitFor(");
	}

}
