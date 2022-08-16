package com.crm.utilities;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentManager {

private static ExtentReports extent;
	
	
	

    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName).filter().statusFilter().as(new Status [] {Status.FAIL,Status.PASS}).apply().viewConfigurer().viewOrder().as(new ViewName [] {ViewName.DASHBOARD,ViewName.TEST}).apply();    
       
        
       
        
        //htmlReporter.config().setTheme(Theme.STANDARD);
        //htmlReporter.config().setDocumentTitle(fileName);
        //htmlReporter.config().setEncoding("utf-8");
        //htmlReporter.config().setReportName(fileName);
        
        
        try {
			htmlReporter.loadXMLConfig(new File(".\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Pushkar Morey");
        extent.setSystemInfo("Organization", "CRMAutomation");
        extent.setSystemInfo("Build no", "CRM-1234");
        
        
        return extent;
    }
	
}
