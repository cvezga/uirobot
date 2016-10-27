package com.ids.uirobot.deamon;

public class DeamonStarter {
	
	public static void main(String[] args) {
		Daemon d = new Daemon();
		
		GlobalKeyListener globalKeyListener = new GlobalKeyListener();
		
		globalKeyListener.register(d);
		
		new Thread(d).start();
	}

}
