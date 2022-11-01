package com.swaglabsdemo.TestBase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.swaglabs.constants.Constants;
import com.swaglabsdemo.util.Util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public static void initialization(String browserName) {
		Properties prop = Util.readProperties(Constants.configpath);
		
		//String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			driver=WebDriverManager.chromedriver().create();
		}
		else if(browserName.equals("FF")){
			driver=WebDriverManager.firefoxdriver().create();
		}
		else if(browserName.equals("edge")){
			driver=WebDriverManager.edgedriver().create();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
