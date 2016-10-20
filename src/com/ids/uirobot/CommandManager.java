package com.ids.uirobot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ids.uirobot.command.ClickCommand;
import com.ids.uirobot.command.Command;
import com.ids.uirobot.command.DefineVariableCommand;
import com.ids.uirobot.command.PrintCommand;
import com.ids.uirobot.command.RunScriptCommand;
import com.ids.uirobot.command.SearchForCommand;
import com.ids.uirobot.command.SleepCommand;
import com.ids.uirobot.command.WaitForCommand;

public class CommandManager {
	
	
	private static Map<String, Command> commandMap = new HashMap<String, Command>();
	static {
		
		commandMap.put("print", new PrintCommand());
		commandMap.put("variableDef", new DefineVariableCommand());
		commandMap.put("runScript", new RunScriptCommand());
		commandMap.put("waitFor", new WaitForCommand());
		commandMap.put("searchFor", new SearchForCommand());
		commandMap.put("clickXY", new ClickCommand());
		commandMap.put("sleep", new SleepCommand());
		
	}
	
	
	
	
	
	
	
	
	public void executeCommands(List<String> commands){
		
		
		
		for(String command : commands){
			if(command == null || command.trim().length()==0 || command.startsWith("#")) continue;
			Command cmd = getCommand(command);
			if(cmd!=null){
				cmd.runCommnand(command);
			}else{
				System.out.println("Not supported: "+command);
			}
				
		}
		
	}








	private Command getCommand(String command) {
		for(Command cmd : commandMap.values()){
			if(cmd.isThisCommand(command)){
				return cmd;
			}
		}
		return null;
	}

}
