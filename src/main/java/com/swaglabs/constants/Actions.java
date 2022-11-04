package com.swaglabs.constants;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.swaglabsdemo.util.Constantvalues;
import com.swaglabsdemo.util.Util;


public class Actions {
	
	
	public String readPropertyFile(String locatorKey) {
	Properties prop = Util.readProperties(Constants.locator_path);
	String locator = prop.getProperty(locatorKey);
	return locator;
	}
	
	public void getUrl(WebDriver driver,String locatorKey)
	{
		String locatorValue=readPropertyFile(locatorKey);
		driver.get(locatorValue);
	}
	
	public void clickonElement(WebDriver driver,String locatorKey)
	{
		String locatorValue=readPropertyFile(locatorKey);
		driver.findElement(By.xpath(locatorValue)).click();
	}
	
	public void sendvalues(WebDriver driver,String locatorKey,String value) {
		String locatorValue=readPropertyFile(locatorKey);
		driver.findElement(By.id(locatorValue)).sendKeys(value);
		
	}
	public void ClickOnRadioBtn(WebDriver driver,String locator,String value,String comparevalue)
	{
		List<WebElement> radio =driver.findElements(By.xpath(locator));
		for(int i=0;i<radio.size();i++)
		{
			WebElement localradio =radio.get(i);
			String value1=localradio.getAttribute(value);
			if(value1.equalsIgnoreCase(comparevalue))
			{
				localradio.click();
			}
		}
	}
	public void clickOnCheckbox(WebDriver driver,String locator,String value,String comparevalue)
	{
		List<WebElement> checkbox =driver.findElements(By.xpath(locator));
		for(int i=0;i<checkbox.size();i++)
		{
			WebElement localcheckbox =checkbox.get(i);
			String value1=localcheckbox.getAttribute(value);
			if(value1.equalsIgnoreCase(comparevalue))
			{
				localcheckbox.click();
			}
		}
		
	}
	public void selectDropdownValue(WebDriver driver,String locator,String type,String value) {
		Select select=new Select(driver.findElement(By.xpath(locator)));
		switch(type)
		{
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
			
		case "value":
			select.selectByValue(value);
			break;
			
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("please pass correct value");
			break;
			
		}
		
		
		}
	public void switchToFrame(WebDriver driver,String framename) {
		driver.switchTo().frame(framename);
	}
	
	public String getTextOfElement(WebDriver driver,String locatorKey)
	{
		String locatorValue=readPropertyFile(locatorKey);
		String text=driver.findElement(By.xpath(locatorValue)).getText();
		return text;
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locatorKey)
	{
		String locatorValue=readPropertyFile(locatorKey);
		boolean status=driver.findElement(By.xpath(locatorValue)).isDisplayed();
		return status;
	}
	
	public boolean isElementEnabled(WebDriver driver,String locator)
	{
		boolean status=driver.findElement(By.xpath(locator)).isEnabled();
		return status;
		
	}
	public boolean isElementSelected(WebDriver driver,String locator)
	{
		boolean status=driver.findElement(By.xpath(locator)).isSelected();
		return status;
	}
	public String handleAlert(WebDriver driver,String locator)
	{
		Alert popup=driver.switchTo().alert();
		String text=popup.getText();
		return text;
	}
	public String getTitleOfPage(WebDriver driver)
	{
		String text=driver.getTitle();
		return text;
	}
	//verifying assert
			public  boolean verifyPositiveResult(Object actual,Object expected,String message) {
				try {
					Assert.assertEquals(actual, expected);
					System.out.println("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
					return true;
				}
					catch (AssertionError assertionError) {
						return false;
					}
				
			}
			
			public boolean verifyNegativeResults(Object actual,Object expected,String message)
			{
				try {
					Assert.assertNotEquals(actual, expected);
					System.out.println("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
					return true;
				}
					catch (AssertionError assertionError) {
						return false;
					}
			}
			public boolean verifyNumberResults(Object actual,Object expected,String message)
			{
				int actualresult=Integer.parseInt(((String) actual).replaceAll("[^0-9]", ""));
				int expectedresult=Integer.parseInt(((String) actual).replaceAll("[^0-9]", ""));
			
				try {
					Assert.assertEquals(actualresult, expectedresult);
					System.out.println("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
					return true;
					
				}
				catch (AssertionError assertionError) {
					return false;
				}
			}
			
			public void verifyPositiveLinks(WebDriver driver,String locatorKey)
			{
				String actualTitle=getTitleOfPage(driver);
				readPropertyFile(locatorKey);
				clickonElement(driver, locatorKey);
				System.out.println("clicked");
				String expectedTitle=getTitleOfPage(driver);
				verifyPositiveResult(actualTitle,expectedTitle,"verifed");
				

			}
			public void verifyNegativeLinks(WebDriver driver,String locatorKey)
			{
				String actualTitle=getTitleOfPage(driver);
				readPropertyFile(locatorKey);
				clickonElement(driver, locatorKey);
				System.out.println("clicked");
				String expectedTitle=getTitleOfPage(driver);
				verifyNegativeResults(actualTitle,expectedTitle,"verifed");
				

			}
			
			public void login(WebDriver driver,String locatorusername,String locatorpwd,String locatorloginbtn,String username,String pwd)
			{
				sendvalues(driver,locatorusername,username);
				System.out.println("entered username");
				
				sendvalues(driver,locatorpwd,pwd);
				System.out.println("entered pwd");
				
				clickonElement(driver, locatorloginbtn);
				System.out.println("clicked");
				
				
			}
			

			public void login(WebDriver driver,String locatorusername,String locatorpwd,String locatorloginbtn,String username,String pwd,String locatortitle,String title)
			{
				sendvalues(driver,locatorusername,username);
				System.out.println("entered username");
				
				sendvalues(driver,locatorpwd,pwd);
				System.out.println("entered pwd");
				
				clickonElement(driver, locatorloginbtn);
				System.out.println("clicked");
				
				String actualvalue=getTextOfElement(driver, locatortitle);
				System.out.println("text");
				
				verifyPositiveResult(actualvalue, title, "error msg verified");
				
				
				
				
			}
			
}

	
			
		
	


