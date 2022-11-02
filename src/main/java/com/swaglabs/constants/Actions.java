package com.swaglabs.constants;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Actions {
	
	public void clickonElement(WebDriver driver,String locator)
	{
		driver.findElement(By.xpath(locator)).click();
	}
	
	public void sendvalues(WebDriver driver,String locator,String value) {
		driver.findElement(By.id(locator)).sendKeys(value);
		
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
	
	public String getTextOfElement(WebDriver driver,String locator)
	{
		String text=driver.findElement(By.xpath(locator)).getText();
		return text;
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locator)
	{
		boolean status=driver.findElement(By.xpath(locator)).isDisplayed();
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
			public  boolean verifyResult(Object actual,Object expected,String message) {
				try {
					Assert.assertEquals(actual, expected);
					System.out.println("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
					return true;
				}
					catch (AssertionError assertionError) {
						return false;
					}
				
			}
			
}

	
			
		
	


