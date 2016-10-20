package com.ids.uirobot;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class TestParameterReader {
	
	private File propertiesFile;
	public TestParameterReader(File file){
		this.propertiesFile = file;
	}
	
	public TestParemeters getProperties(){
		TestParemeters testParemeters = new TestParemeters();
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader(this.propertiesFile));
			
			
			
			testParemeters.logPath = prop.getProperty("log.path");
			testParemeters.testPath = prop.getProperty("test.path");
			testParemeters.testList = getAllTest(testParemeters.testPath);
			
			System.out.println("log.path = "+testParemeters.logPath);
			System.out.println("test.path = "+testParemeters.testPath);
			System.out.println("test.list:");
			for(File f: testParemeters.testList){
				System.out.println(f.getPath());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testParemeters;
	}

	private List<File> getAllTest(String path) {
		List<File> testList = new ArrayList<File>();
		File[] files = new File(path).listFiles();
		for(File f : files){
			if(f.isDirectory()){
			   testList.add(f);
			}
		}
		Collections.sort(testList);
		return testList;
	}

}
