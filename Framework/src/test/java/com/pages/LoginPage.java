package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.Inject;

public class LoginPage {
@Inject
	WebDriver driver;
	
	/* By Class exampleesss
	By UserName=By.xpath("//input[@id=\"txtUsername\"]");
	By Password=By.xpath("//input[@id=\"txtPassword\"]");
	By Submit=By.xpath("//input[@id=\"btnLogin\"]");*/
		
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/*TestNG Class Example*/
	@FindBy(xpath="//input[@id=\"txtUsername\"]") WebElement VarUser;
	@FindBy(xpath="//input[@id=\"txtPassword\"]") WebElement VarPass;
	@FindBy(xpath="//input[@id=\"btnLogin\"]") WebElement VarSubmit;
	
	public void loginMethod(String UserID, String Password) 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			System.out.println("Thread Sleep Exception Found");
		}
		
		VarUser.sendKeys(UserID);
		VarPass.sendKeys(Password);
		VarSubmit.click();
	}
	
	
	/*Basic Method
	public void LoginMethod(String UserId,String Pass) throws InterruptedException
	{
		driver.findElement(UserName).sendKeys(UserId);
		driver.findElement(Password).sendKeys(Pass);
		driver.findElement(Submit).click();
		Thread.sleep(5000);
	}*/
	


}
