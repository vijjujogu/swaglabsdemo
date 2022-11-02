package com.swaglabsdemo.util;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.swaglabsdemo.TestBase.TestBase;

public class CustomListener extends TestBase implements ITestListener {
	
	Util util=new Util();
	
public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.println("failed tests");
	try {
		Util.takeScreenshotAtEndOfTest(driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}