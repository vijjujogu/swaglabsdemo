package com.swaglabsdemo.testscripts;


import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.swaglabs.constants.Actions;
import com.swaglabsdemo.TestBase.TestBase;

import com.swaglabsdemo.util.Util;

public class verifyDetailsInCheckoutTest extends TestBase {
	
	Actions actionsClass=new Actions();
	Util commonUtil=new Util();
	
	
	
	@DataProvider
	public Object[][] getLoginData()
	{
		Object data[][]=Util.getTestData("logindata");
		return data;
	}
	@Test(dataProvider="getLoginData")
	public void verifyDetailsInCheckout(String username,String password,String paymentInfo,String shippingInfo,String orderDetails) 
	{
		actionsClass.login(driver, "locator.username", "locator.pwd", "locator.loginbutton",username,password);
		actionsClass.clickonElement(driver, "locator.productlink");
		String productName=actionsClass.getTextOfElement(driver, "locator.productName");
		String productPrice=actionsClass.getTextOfElement(driver, "locator.productprice");
		actionsClass.clickonElement(driver, "locator.addtoCart");
		actionsClass.clickonElement(driver, "locator.cart");
		actionsClass.clickonElement(driver, "locator.checkBtn");
		actionsClass.sendvalues(driver,"locator.firstname", "firstName");
		actionsClass.sendvalues(driver,"locator.lastname","lastname");
		actionsClass.sendvalues(driver, "locator.pincode","pincode");
		actionsClass.clickonElement(driver, "locator.continue");
		String productnameInCheckout=actionsClass.getTextOfElement(driver,"locator.productnameInCheckout");
		actionsClass.verifyPositiveResult(productName, productnameInCheckout, "productname verified");
		String paymentInformation=actionsClass.getTextOfElement(driver, "locator.paymentInfo");
		actionsClass.verifyPositiveResult(paymentInfo, paymentInformation,"verified paymentinfo");
		String shippingInformation=actionsClass.getTextOfElement(driver, "locator.shippingInfo");
		actionsClass.verifyPositiveResult(shippingInfo,shippingInformation,"verified shippinginfo");
		String itemTotal=actionsClass.getTextOfElement(driver, "locator.itemtotal");
		actionsClass.verifyNumberResults(itemTotal, productPrice, "price is verified");
		actionsClass.clickonElement(driver, "locator.finish");
		String orderconformation=actionsClass.getTextOfElement(driver, "locator.orderconformation");
		actionsClass.verifyPositiveResult(orderDetails, orderconformation,"order conformation verified");
		
	
	}
	
	
	
}
