package com.example.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.Testcases.BaseTest;

public class ListenerTest implements ITestListener {
	private static ExtentReports extent = new ExtentReports();
    private ExtentTest test;
    

    @Override
    public void onTestStart(ITestResult result) {
    	  System.out.println("Test started: " + result.getName());
          test = extent.createTest(result.getMethod().getMethodName());    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	  if (test != null) {
              test.pass("Test passed");
          }    }

    @Override
    public void onTestFailure(ITestResult result) {
    	  System.out.println("Test failed: " + result.getMethod().getMethodName());
          Throwable throwable = result.getThrowable();
          if (throwable != null) {
              System.out.println("Exception: " + throwable.getMessage());
          }
          BaseTest baseTest = (BaseTest) result.getInstance();
          baseTest.takeScreenshot(result.getName());
          if (test != null) {
              test.fail(result.getThrowable());
          } 
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	 if (test != null) {
             test.skip(result.getThrowable());
         }    }

    @Override
    public void onStart(ITestContext context) {
    	 System.out.println("Tests started: " + context.getName());
         ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReports.html");
         extent = new ExtentReports();
         extent.attachReporter(sparkReporter);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Tests finished: " + context.getName());
    }
}