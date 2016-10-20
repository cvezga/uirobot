package com.ids.uirobot;



import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SearchImage {

	private static final int X_SCAN_WIDTH = 5;
	private static final int Y_SCAN_WIDTH = 5;

	public static Rectangle search(BufferedImage screen, BufferedImage searchFor) {
		Rectangle r = null;

		searchLoop: {
			for (int y = 0; y < screen.getHeight()-searchFor.getHeight(); y++){
				for (int x = 0; x < screen.getWidth()-searchFor.getWidth(); x++) {
					if (fastMatch(x, y, screen, searchFor) && match(x, y, screen, searchFor)) {
						r = new Rectangle(x, y, searchFor.getWidth(), searchFor.getHeight());
						break searchLoop;
					}
				}
			}
		}

		return r;

	}

	private static boolean match(int sx, int sy, BufferedImage screen, BufferedImage searchFor) {
		boolean matched = true;
		scan: {
			for (int y = 0; y < searchFor.getHeight()-1; y = y + Y_SCAN_WIDTH) {
				for (int x = 0; x < searchFor.getWidth()-1; x = x + X_SCAN_WIDTH) {
					int scolor = screen.getRGB(sx + x, sy + y);
					int color = searchFor.getRGB(x, y);
					if (scolor != color) {
						matched = false;
						break scan;
					}

				}
			}
		}
		return matched;
	}
	
	private static boolean fastMatch(int sx, int sy, BufferedImage screen, BufferedImage searchFor) {
		boolean matched = true;
		int xx = searchFor.getWidth()/5;
		int yy = searchFor.getHeight()/5;
		scan: {
			for (int y = 0; y < searchFor.getHeight()-1; y = y + yy) {
				for (int x = 0; x < searchFor.getWidth()-1; x = x + xx) {
					int scolor = screen.getRGB(sx + x, sy + y);
					int color = searchFor.getRGB(x, y);
					if (scolor != color) {
						matched = false;
						break scan;
					}

				}
			}
		}
		return matched;
	}

}
