package com.myvidessa.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MyvidessaLoadPropertiesFileImpl {
	
	public Properties loadParamPropertiesFile()
	{
		File file=new File("C:\\Users\\Birjesh\\Desktop\\iAssess_Automation\\Provista Automation\\src\\com\\myvidessa\\configuration\\param.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
