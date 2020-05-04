package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	public Properties Pro;
	
	public ConfigDataProvider() 
	{
		File src=new File("./Config/Config.properties");
		FileInputStream fis;
		
		try 
		{
			fis = new FileInputStream(src);
			Pro=new Properties();
			Pro.load(fis);
		}
		catch (Exception e) 
		{
			System.out.println("Not able to load Config File"+e.getMessage());
		}
	}
	
	public String getDataFromConfig(String KeyToSearch) /*Generic Call for AnyKey Value from Config Property*/
	{
		return Pro.getProperty(KeyToSearch);
	}
	
	public String getBrowser()/*Will get browser from Config.properties file*/
	{
	 return Pro.getProperty("Browser");
	}
	
	public String getTestUrl()/*Will get Application URL from Config.properties file*/
	{
	 return Pro.getProperty("TestUrl");
	}

}
