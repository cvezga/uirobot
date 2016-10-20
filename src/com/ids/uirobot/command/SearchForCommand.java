package com.ids.uirobot.command;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.ids.uirobot.ScreenCapture;
import com.ids.uirobot.SearchImage;
import com.ids.uirobot.StringUtils;
import com.ids.uirobot.Variables;

public class SearchForCommand implements Command {

	@Override
	public void runCommnand(String command) {

		BufferedImage image = getImageName(command);
		boolean found = false;
		try {
			BufferedImage screen = ScreenCapture.captureScreenAll();
			Rectangle r = SearchImage.search(screen, image);
			if (r != null) {
				Variables.r = r;
				found = true;
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (found) {
			System.out.println("Image was found!" + command);
		} else {
			System.out.println("Image was not found! " + command);
		}
	}

	

	private BufferedImage getImageName(String command) {
		String imageName = StringUtils.substringDelimited(command, "(", ")");
		return (BufferedImage) Variables.get(imageName);
	}

	
	@Override
	public boolean isThisCommand(String command) {
		return command.startsWith(":searchFor(");
	}

}
