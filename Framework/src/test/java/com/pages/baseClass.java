package com.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utilities.ConfigDataProvider;
import com.utilities.ExcelDataProvider;
import com.utilities.browserFactory;
import com.utilities.handler;

public class baseClass {
	
public WebDriver driver;
public ExcelDataProvider Excel;
public ConfigDataProvider Config;
public ExtentReports Report;
public ExtentTest Logger;

	
	@BeforeSuite()
	public void setUpSuite()
	{
		Reporter.log("Setting up report and Test is getting ready",true);
		Excel=new ExcelDataProvider();
		Config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"+handler.getCurrentDateTime()+".html"));
		Report=new ExtentReports();
		Report.attachReporter(extent);
		Reporter.log("Setting up report is done and Test is started",true);
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start browser",true);
		driver= browserFactory.startApplication(driver, Config.getBrowser(),Config.getTestUrl());
		//driver= browserFactory.startApplication(driver, browser,Config.getTestUrl());
		Reporter.log("Browser is started",true);
	}
	

	@AfterClass
	public void teardown() 
	{
		Reporter.log("Closing browser, and closed!",true);
		browserFactory.quiteBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) 
	{
		Reporter.log("Test is about to end",true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				Logger.fail("Test case is failed bhai",MediaEntityBuilder.createScreenCaptureFromPath(handler.captureScreenShot(driver)).build());
			} 
			catch (IOException e) {
				System.out.println("screenshot path not found");
			
			}
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			try {
				Logger.pass("Test case is Passed ",MediaEntityBuilder.createScreenCaptureFromPath(handler.captureScreenShot(driver)).build());
			} 
			catch (IOException e) {
				System.out.println("screenshot path not found");

			}
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			try {
				Logger.skip("Test case is skipped ",MediaEntityBuilder.createScreenCaptureFromPath(handler.captureScreenShot(driver)).build());
			} 
			catch (IOException e) {
				System.out.println("screenshot path not found");

			}
		}
		
		Report.flush();
		Reporter.log("Test is completed report is ready",true);
	}
	

}
