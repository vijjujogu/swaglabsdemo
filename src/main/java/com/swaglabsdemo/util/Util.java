package com.swaglabsdemo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.swaglabs.constants.Constants;

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
		static Workbook book;
		static Sheet sheet;
		public static Object[][] getTestData(String sheetName) {
			FileInputStream file = null;
			try {
				file = new FileInputStream(Constants.testdata_path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
				}
			}
			return data;
		}
		
		
		
		
		//logic for taking screenshots
		public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		}
		
		
			

		
		

		
		
}
