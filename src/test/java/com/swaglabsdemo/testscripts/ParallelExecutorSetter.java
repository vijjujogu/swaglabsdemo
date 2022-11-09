package com.swaglabsdemo.testscripts;

import java.util.List;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

public class ParallelExecutorSetter implements IAlterSuiteListener {
	
	public void alter(List<XmlSuite> suites) {
        XmlSuite suite = suites.get(0);
        String parallelMode = System.getProperty("parallelMode");
        System.out.println(parallelMode);
        XmlSuite.ParallelMode mode = XmlSuite.ParallelMode.getValidParallel(parallelMode);
        if (mode != null) {
            suite.setParallel(mode);
        }
    }

}
