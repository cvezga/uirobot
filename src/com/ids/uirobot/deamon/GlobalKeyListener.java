package com.ids.uirobot.deamon;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {

	private List<DeamonKeyListener> keyListenerList;
	

	public GlobalKeyListener() {
		this.keyListenerList = new ArrayList<>();
		init();
	}
	
	public void register(DeamonKeyListener e){
		this.keyListenerList.add(e);
	}

	private void init() {
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);

		// Don't forget to disable the parent handlers.
		logger.setUseParentHandlers(false);

		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(this);
	}

	public void nativeKeyPressed(NativeKeyEvent e) {
		for(DeamonKeyListener kl : this.keyListenerList){
			kl.keyPressed(e);
		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		for(DeamonKeyListener kl : this.keyListenerList){
			kl.keyReleased(e);
		}
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		for(DeamonKeyListener kl : this.keyListenerList){
			kl.keyTyped(e);
		}
	}

}