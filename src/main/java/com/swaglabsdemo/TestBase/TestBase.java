package com.swaglabsdemo.TestBase;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.swaglabs.constants.Constants;
import com.swaglabsdemo.util.Constantvalues;
import com.swaglabsdemo.util.Util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports extent;
	public ExtentTest extentTest;
	Util commonUtil=new Util();
	
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUp(String browserName){
		initialization(browserName);
			
	}
	@AfterMethod 
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + testResult.getName() +"-"+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
		}
		tearDown();
	}

	
	
	public static void initialization(String browserName) {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		 Properties prop = Util.readProperties(Constants.configpath);
		
		
		
		if(browserName.equals(Constantvalues.CHROME.toString())){
			driver=WebDriverManager.chromedriver().create();
		}
		else if(browserName.equals(Constantvalues.FF.toString())){
			driver=WebDriverManager.firefoxdriver().create();
		}
		else if(browserName.equals(Constantvalues.IE.toString())){
			driver=WebDriverManager.iedriver().create();
		}
		else if(browserName.equals(Constantvalues.EDGE.toString())){
			driver=WebDriverManager.edgedriver().create();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
		
	}

	/**public void tearDown(){
		
		driver.quit();
	}**/
	public void tearDown(){
		
		
	driver.quit();
	}
}
