package com.ids.uirobot.command;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ids.uirobot.Variables;

public class DefineVariableCommand implements Command {

	@Override
	public void runCommnand(String command) {
		int idx1 = command.indexOf("=");
		String varname = command.substring(1, idx1 );
		String varvalue = command.substring(idx1 + 1).trim();
		Object value = null;
		if (varvalue.startsWith("\"") && varvalue.endsWith("\"")) {
			varvalue = varvalue.substring(1, varvalue.length() - 1);
			value = varvalue;
		} else if (varvalue.startsWith(".image(")) {
			value = loadImage(varname, varvalue);

		}else{
			value = varvalue;
		}

		if (value != null) {
			Variables.put(varname, value);
		}
	}

	private BufferedImage loadImage(String varname, String varvalue) {
		BufferedImage image = null;
		String path = (String) Variables.get("$_imagePath");
		String imageName = varvalue.replaceAll("\\.image\\(", "").replace("\"", "").replace(")", "");
		try {
			File imageFile = new File(path, imageName);
			if(!imageFile.exists()){
				throw new IOException("File does not exist. "+imageFile.getPath());
			}
			image = ImageIO.read(new File(path, imageName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

	@Override
	public boolean isThisCommand(String command) {
		return command.startsWith(":$");
	}

}
