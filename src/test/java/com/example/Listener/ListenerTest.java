package com.example.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.example.Testcases.BaseTest;

public class ListenerTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	  System.out.println("Test failed: " + result.getMethod().getMethodName());
    	    Throwable throwable = result.getThrowable();
    	    if (throwable != null) {
    	        System.out.println("Exception: " + throwable.getMessage());
    	    }
           BaseTest baseTest = (BaseTest) result.getInstance();
           baseTest.takeScreenshot(result.getName());    
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Tests started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Tests finished: " + context.getName());
    }
}