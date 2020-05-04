package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class handler {
	
	public static String captureScreenShot(WebDriver driver) 
	{	
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println("Screen Shot taken");
		
		String screenShotPath=System.getProperty("user.dir")+"/Screenshots/"+ getCurrentDateTime()+".png";
		
		try 
		{
			FileHandler.copy(src, new File(screenShotPath));
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to captrure Screenshots"+e.getMessage());
		}
		
		return screenShotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat CustomFormat=new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date currentDate=new Date();
		return CustomFormat.format(currentDate);
		
	}

}
