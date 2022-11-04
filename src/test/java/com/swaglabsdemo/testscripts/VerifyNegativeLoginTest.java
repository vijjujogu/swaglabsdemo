package com.swaglabsdemo.testscripts;



import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.swaglabs.constants.Actions;
import com.swaglabsdemo.TestBase.TestBase;
import com.swaglabsdemo.util.Util;

public class VerifyNegativeLoginTest extends TestBase {
	
	Actions actionsClass=new Actions();
	Util commonUtil=new Util();
	
	
	
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
	

}
