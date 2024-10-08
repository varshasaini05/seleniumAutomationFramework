package com.example.Testcases;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.example.Utils.RetryAnalyzer;
import pageObjects.LoginPage; 

public class LoginTestcase extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLogin() throws InterruptedException {
    	String Email="3_employee@mailinator.com";
    	String Password="Pass@123";
        ExtentTest test = extent.createTest("Login Test");

    	 if (test != null) {
    	        test = extent.createTest("Login Test");
    	        LoginPage loginPage = new LoginPage(driver, test);
    	        loginPage.login(Email,Password);
    	        BaseTest.setTest(test);
    	    } else {
    	        System.err.println("ExtentTest is not initialized.");
    	    }
    	
    }
}