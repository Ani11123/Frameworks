package com.testcase;

import com.pages.LoginPage;
import com.pages.baseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest extends baseClass {
	
	@Test(priority=1)
	public void VerifyLoginSuccess()
	{	
		Logger=Report.createTest("Login to OrangeHRM");
		Logger.info("Test App is starting");
		LoginPage loginToApp=PageFactory.initElements(driver,LoginPage.class);
		loginToApp.loginMethod(Excel.getStringData("Login Details", 0, 0), Excel.getStringData("Login Details", 0, 1));
		Logger.info("Successful Login");	
	}
	
	@Test(priority=2)
	public void VerifyLoginOutFail()
	{	
		Logger=Report.createTest("Login to OrangeHRM is unsuccessful");
		Logger.fail("Login out failed");
	}
	
	
}

