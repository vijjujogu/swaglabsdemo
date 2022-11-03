package com.swaglabsdemo.testscripts;





import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swaglabs.constants.Actions;

import com.swaglabsdemo.TestBase.TestBase;
import com.swaglabsdemo.util.Util;

public class VerifyMenuItemsTest extends TestBase{
	
	Actions actionsClass=new Actions();
	Util commonUtil=new Util();
	
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUp(String browserName){
		initialization(browserName);
			
	}
	@DataProvider
	public Object[][] getLoginData()
	{
		Object data[][]=Util.getTestData("logindata");
		return data;
	}
	
	@Test(dataProvider="getLoginData")
	public void verifyMenuItems(String username,String password) throws InterruptedException
	{
		
		actionsClass.login(driver, "locator.username", "locator.pwd", "locator.loginbutton",username,password);
		actionsClass.clickonElement(driver, "locator.menubtn");
		actionsClass.verifyPositiveLinks(driver, "locator.allItems");
		actionsClass.verifyNegativeLinks(driver, "locator.about");
        actionsClass.getUrl(driver, "url");
		actionsClass.clickonElement(driver, "locator.menubtn");
		actionsClass.verifyPositiveLinks(driver, "locator.resetApp");
		actionsClass.verifyNegativeLinks(driver, "locator.logOut");
		
		driver.close();
	
	}
	
	@AfterMethod
	public void exit() throws Exception
	{
		//commonUtil.takeScreenshotAtEndOfTest(driver, "verifymenu");
		tearDown();
	}


}
