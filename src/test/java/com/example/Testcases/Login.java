package com.example.Testcases;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.example.Utils.RetryAnalyzer;
import pageObjects.LoginPage; 

public class Login extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLogin() throws InterruptedException {
    	String Username="student";
    	String Password="Password123";
        ExtentTest test = extent.createTest("Login Test");

    	 if (test != null) {
    	        test = extent.createTest("Login Test");
    	        LoginPage loginPage = new LoginPage(driver, test);
    	        loginPage.login(Username,Password);
    	        BaseTest.setTest(test);
    	    } else {
    	        System.err.println("ExtentTest is not initialized.");
    	    }
    	
    }
}