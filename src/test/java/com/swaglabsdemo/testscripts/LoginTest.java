package com.swaglabsdemo.testscripts;



import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swaglabs.constants.Constants;
import com.swaglabs.pages.LoginPage;

import com.swaglabsdemo.TestBase.TestBase;
import com.swaglabsdemo.util.Util;

public class LoginTest extends TestBase{
	
	LoginPage login=new LoginPage();
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUp(String browserName){
		initialization(browserName);
			
	}
	
	
	@DataProvider
	public Object[][] getLoginData()
	{
		Object data[][]=Util.getTestData("login");
		return data;
	}
	
	@Test(dataProvider="getLoginData")
	public void loginTest(String username,String password)
	{
		Properties prop = Util.readProperties(Constants.locator_path);
		String locatorusername = prop.getProperty("locator.username");
		login.enterUsername(locatorusername,username);
		System.out.println("entered username");
		String locatorpwd = prop.getProperty("locator.pwd");
		login.enterPassword(locatorpwd,password);
		System.out.println("entered pwd");
		String locatorlogin = prop.getProperty("locator.loginbutton");
		login.clickOnLogin(locatorlogin);
		System.out.println("clicked");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}

