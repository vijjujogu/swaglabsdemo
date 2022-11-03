package com.swaglabsdemo.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;



public class TestNGRunner {

	public static void main(String[] args) {
		TestNG obj=new TestNG();
		List<String> suites =new ArrayList<String>();
		//suites.add(Constants.testng1);
		//suites.add(Constants.testng2);
		suites.add("C:\\Users\\vijayalakshmi.jogu\\eclipse-workspace\\swaglabsdemo\\resource\\suites\\verifyNegativeLoginTctestng.xml");
		suites.add("C:\\Users\\vijayalakshmi.jogu\\eclipse-workspace\\swaglabsdemo\\resource\\suites\\verifymenutestng.xml");
		obj.setTestSuites(suites);
		obj.run();

	}

}
