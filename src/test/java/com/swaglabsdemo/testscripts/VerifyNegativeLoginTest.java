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

public class VerifyNegativeLoginTest extends TestBase {
	
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
		Object data[][]=Util.getTestData("negativelogindata");
		return data;
	}
	
	@Test(dataProvider="getLoginData")
	public void loginTest(String username,String password,String title)
	{
		actionsClass.login(driver, "locator.username", "locator.pwd", "locator.loginbutton", username, password, "locator.error", title);
		driver.close();
	}
	
	@AfterMethod
	public void exit() throws Exception
	{
		//commonUtil.takeScreenshotAtEndOfTest(driver, "loginfailedscreenshot");
		tearDown();
	}

}
