package com.ids.uirobot.deamon;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;

public class Daemon implements Runnable, DeamonKeyListener {
	
	private boolean isRunning;

	private ImageSelectorUI imageSelectorUI;

	@Override
	public void run() {
		
		 
		
		this.isRunning = true;
		
		while(this.isRunning){
			
			sleep(100);
		}
		
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void keyPressed(NativeKeyEvent e) {
		System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			try {
				GlobalScreen.unregisterNativeHook();
			} catch (NativeHookException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyReleased(NativeKeyEvent e) {
		String c = NativeKeyEvent.getKeyText(e.getKeyCode());
		if("P".equals(c)){
			ImageSelectorUI.show(null);
			
		}
		
	}

	@Override
	public void keyTyped(NativeKeyEvent e) {
		//System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
		
	}



}
