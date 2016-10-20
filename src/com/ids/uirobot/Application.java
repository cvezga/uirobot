package com.ids.uirobot;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Application {

	public static void main(String[] args) throws IOException {

		if(args==null || args.length!=1){
			System.out.println("Usage:");
			System.out.println("java com.ids.uirobot.Application <test properties file>");
			System.exit(1);
		}
		
		File file = new File(args[0]);
		
		TestParemeters params = new TestParameterReader(file).getProperties();
		
		for(File test : params.testList){
			runTest(test);
		}
		
		
	}

	private static void runTest(File testDir) throws IOException {
		System.out.println("=============================================================");
        System.out.println("Pricessing test: "+testDir.getPath());
        
        File test = getTestFileName(testDir);
		
		List<String> commands = FileUtil.loadFile(test);
		
		CommandManager commandManager = new CommandManager();
		
		commandManager.executeCommands(commands);
		
	}

	private static File getTestFileName(File testDir) {
		for( File f : testDir.listFiles() ){
			if(f.getName().endsWith(".uitest")){
				return f;
			}
		}
		return null;
	}



}
