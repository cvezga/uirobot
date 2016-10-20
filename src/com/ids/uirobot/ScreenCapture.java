package com.ids.uirobot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenCapture {
	
	public static void main(String[] args) throws AWTException, IOException {
		//Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		for(int i=0; i<100; i++){
			//BufferedImage capture = new Robot().createScreenCapture(screenRect);
			BufferedImage capture = captureScreenAll();
			ImageIO.write(capture, "bmp", new File("cap-"+i+".bmp"));
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static BufferedImage captureScreenAll() throws AWTException{
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect);
		return capture;
	}

}
