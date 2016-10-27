package com.ids.uirobot.deamon;

import org.jnativehook.keyboard.NativeKeyEvent;

public interface DeamonKeyListener {
	
	void keyPressed(NativeKeyEvent e);
	void keyReleased(NativeKeyEvent e);
	void keyTyped(NativeKeyEvent e);

}
