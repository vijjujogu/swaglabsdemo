package com.swaglabsdemo.testscripts;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.swaglabs.constants.Actions;

import com.swaglabsdemo.TestBase.TestBase;
import com.swaglabsdemo.util.Util;

public class VerifyMenuItemsTest extends TestBase{
	
	Actions actionsClass=new Actions();
	Util commonUtil=new Util();
	
	
	
	@DataProvider
	public Object[][] getLoginData()
	{
		Object data[][]=Util.getTestData("logindata");
		return data;
	}
	
	@Test(dataProvider="getLoginData")
	public void verifyMenuItems(String username,String password,String paymentInfo,String shippingInfo,String orderDetails) throws InterruptedException
	{
		
		actionsClass.login(driver, "locator.username", "locator.pwd", "locator.loginbutton",username,password);
		actionsClass.clickonElement(driver, "locator.menubtn");
		actionsClass.verifyPositiveLinks(driver, "locator.allItems");
		actionsClass.verifyNegativeLinks(driver, "locator.about");
		//actionsClass.isElementDisplayed(driver, "locator.signIn");
        actionsClass.getUrl(driver, "url");
		actionsClass.clickonElement(driver, "locator.menubtn");
		actionsClass.verifyPositiveLinks(driver, "locator.resetApp");
		actionsClass.verifyNegativeLinks(driver, "locator.logOut");
		actionsClass.isElementDisplayed(driver, "locator.signIn");
		
		driver.close();
	
	}
	
	


}
