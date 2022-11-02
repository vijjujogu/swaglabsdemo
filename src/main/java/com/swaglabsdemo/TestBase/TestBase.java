package com.swaglabsdemo.TestBase;

import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.swaglabs.constants.Constants;
import com.swaglabsdemo.util.Constantvalues;
import com.swaglabsdemo.util.Util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public static void initialization(String browserName) {
		
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		 
        option.setCapability("build", "Testing Chrome Options [Selenium 4]");
        option.setCapability("name", "Testing Chrome Options [Selenium 4]");
       // option.setCapability("platformName", "Windows 10");
       // option.setCapability("browserName", "Chrome");
        //option.setCapability("browserVersion", "latest");
		 InternetExplorerOptions options =new InternetExplorerOptions();
		 options.destructivelyEnsureCleanSession();
		 options.enablePersistentHovering();
		 
		
		Properties prop = Util.readProperties(Constants.configpath);
		
		//String browserName = prop.getProperty("browser");
		
		if(browserName.equals(Constantvalues.CHROME.toString())){
			driver=WebDriverManager.chromedriver().capabilities(option).create();
		}
		else if(browserName.equals(Constantvalues.FF.toString())){
			driver=WebDriverManager.firefoxdriver().create();
		}
		else if(browserName.equals(Constantvalues.EDGE.toString())){
			driver=WebDriverManager.edgedriver().create();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
		
	}

	public void tearDown(){
		driver.quit();
	}
}
