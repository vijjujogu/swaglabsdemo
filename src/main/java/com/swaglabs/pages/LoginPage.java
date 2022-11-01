package com.swaglabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglabsdemo.TestBase.TestBase;
import com.swaglabsdemo.util.Util;

public class LoginPage extends TestBase{
	Util util=new Util();
	
	public void enterUsername(String locator,String usernm){
		util.sendvalues(driver,locator, usernm);
		
	}
	public void enterPassword(String locator,String pwd)
	{
		util.sendvalues(driver,locator, pwd);
	}
	public void clickOnLogin(String locator)
	{
		util.clickonElement(driver,locator);
	}
}
