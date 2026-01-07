package com.app.resuse;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Report {
	//1
	public static ExtentSparkReporter sparkReport = null;
	public static ExtentReports extentreport = null;
	public static ExtentTest extenttest = null;
	public static String reportlocation = System.getProperty("user.dir")+ "/reports/Unitreports.html";
	
	//4
	public static ExtentReports getInstance() {
		if(extentreport==null) {
			return createInstance();
		}
		return extentreport;
		
	}
	
	//2 
	public static ExtentReports createInstance() {
		sparkReport = new ExtentSparkReporter(reportlocation);
		sparkReport.config().setDocumentTitle("Aiite");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Aiite Extent Report");
		extentreport = new ExtentReports();
		extentreport.attachReporter(sparkReport);
		extentreport.setSystemInfo("Inst", "Aiite Academy");
		extentreport.setSystemInfo("batch", "Jan");
		extentreport.setSystemInfo("Trainer", "Yuvaraj");
		extentreport.setSystemInfo("Testing", "Report");
		return extentreport;
		
		
	}
	//3
	public static void createReportTest(String name) {
		extenttest = extentreport.createTest(name);
	}
	
	//5
	public static void flushreport() {
		extentreport.flush();
	}

}
