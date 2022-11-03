package com.swaglabsdemo.util;

import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.swaglabsdemo.TestBase.TestBase;

public class CustomListener extends TestBase implements ITestListener {
	
	Util util=new Util();
	public void onTestFailure(ITestResult result,String fileName) {
	// TODO Auto-generated method stub
	System.out.println("failed tests");
	try {
		Util.takeScreenshotAtEndOfTest(driver,fileName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
/**public void onTestExecution(ITestResult result,Capabilities capabilities) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable());
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS"+capabilities.getBrowserName());
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS"+capabilities.getBrowserVersion());//to add error/exception in extent report
			
			String screenshotPath =Util .getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			extentTest.log(LogStatus.SKIP,"Test case skipped is"+capabilities.getBrowserName());
			extentTest.log(LogStatus.FAIL, "TEST CASE skipped IS"+capabilities.getBrowserVersion());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
			extentTest.log(LogStatus.PASS, "TEST CASE passed IS"+capabilities.getBrowserName());
			extentTest.log(LogStatus.PASS, "TEST CASE passed IS"+capabilities.getBrowserVersion());

		}
		
		
		extent.endTest(extentTest);
}**/
}