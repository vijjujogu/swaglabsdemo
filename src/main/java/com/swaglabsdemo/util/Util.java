package com.swaglabsdemo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import com.swaglabs.constants.*;
import com.swaglabsdemo.TestBase.TestBase;

public class Util {
	
	//logic for reading properties file
		public static Properties readProperties(String path) {
			
			Properties properties = new Properties();
			try {
				FileInputStream inputStream = new FileInputStream(path);
				try {
					properties.load(inputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return properties;
		}
		
		
		
		//logic for reading excel data
		
		//public static String TESTDATA_SHEET_PATH = "testdata.xlsx";
		static Workbook swaglabsbook;
		static Sheet swaglabssheet;
		public static Object[][] getTestData(String sheetName) {
			FileInputStream file = null;
			try {
				file = new FileInputStream(Constants.testdata_path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				swaglabsbook = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			swaglabssheet = swaglabsbook.getSheet(sheetName);
			Object[][] data = new Object[swaglabssheet.getLastRowNum()][swaglabssheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < swaglabssheet.getLastRowNum(); i++) {
				for (int k = 0; k < swaglabssheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = swaglabssheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
				}
			}
			return data;
		}
		
				
		
		//logic for taking screenshots
	/**	public static void takeScreenshotAtEndOfTest(WebDriver driver,String methodName) throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + methodName + ".png"));
		}
		**/
		
		/**public void screenShot(ITestResult result,WebDriver driver){
			//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
			if(ITestResult.FAILURE==result.getStatus()){
			try{
			// To create reference of TakesScreenshot
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			// Call method to capture screenshot
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			// Copy files to specific location
			// result.getName() will return name of test case so that screenshot name will be same as test case name
			//FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(src, new File(currentDir + "/screenshots/" + result.getName() + ".png"));
			System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
			System.out.println("Exception while taking screenshot "+e.getMessage());
			}
			}**/
		
		/**public void takeScreenShot(String methodName, WebDriver driver) {
	    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //The below method will save the screen shot in d drive with test method name 
	            try {
					FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
					System.out.println("***Placed screen shot in "+filePath+" ***");
				} catch (IOException e) {
					e.printStackTrace();
				}
	    }
		
		/**public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots"
			// under src folder
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}**/
				
}		

