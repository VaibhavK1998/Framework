package org.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	FileInputStream fis;
	Properties prop;
	public String getConfigtestdata(String key) {
			try{
				fis = new FileInputStream("./PropertiesFiles2/config.properties");//step 1
			  	prop=new Properties();
				prop.load(fis); 
			}catch(IOException e) {
				e.printStackTrace();
			} 
		  
			return prop.getProperty(key);
	}
}
