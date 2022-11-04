package com.swaglabsdemo.testscripts;



import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swaglabs.constants.Actions;
import com.swaglabs.constants.Constants;

import com.swaglabsdemo.TestBase.TestBase;
import com.swaglabsdemo.util.Constantvalues;
import com.swaglabsdemo.util.Util;

public class LoginTest extends TestBase{
	
	Actions ac=new Actions();
	Util ut=new Util();
	
	
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
		ac.sendvalues(driver, locatorusername,username);
		System.out.println("entered username");
		String locatorpwd = prop.getProperty("locator.pwd");
		ac.sendvalues(driver, locatorpwd,password);
		System.out.println("entered pwd");
		String locatorlogin = prop.getProperty("locator.loginbutton");
		ac.clickonElement(driver, locatorlogin);
		System.out.println("clicked");
		
	}
	@Test
	public void loginPageTitleTest(){
		String title=ac.getTitleOfPage(driver);
		ac.verifyPositiveResult(title,Constantvalues.Title.toString(),"verification passed");
	}
	
	
	@AfterMethod 
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-" 
					+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
		} 
	}

	/**@AfterMethod
	public void exit()
	{
		/**try {
			ut.takeScreenshotAtEndOfTest(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}**/
		//tearDown();
	
	
	
	

}

