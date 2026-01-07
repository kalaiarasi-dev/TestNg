package com.app.resuse;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TestOne implements ITestListener{

	@Override
	public void onStart(ITestContext context) {
		Extent_Report.getInstance();
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		Extent_Report.createReportTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Extent_Report.extenttest.log(Status.PASS, "TestCsesPassed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Extent_Report.extenttest.log(Status.FAIL, "TestCsesFailed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Extent_Report.extenttest.log(Status.SKIP, "TestCaseSkipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}
	@Override
	public void onFinish(ITestContext context) {
		Extent_Report.flushreport();
		
	}

}
