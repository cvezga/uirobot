package com.ids.uirobot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessRunnable implements Runnable {

	private String scriptname;

	public ProcessRunnable(String scriptname) {
		super();
		this.scriptname = scriptname;
	}

	@Override
	public void run() {

		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", scriptname);

		builder.redirectErrorStream(true);

		try {
			Process p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
				sleep(500);

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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

}
