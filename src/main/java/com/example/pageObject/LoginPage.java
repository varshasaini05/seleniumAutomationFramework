package com.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;

public class LoginPage extends BasePage {

	    private WebDriver driver;
	    private ExtentTest test;

	    public LoginPage(WebDriver driver, ExtentTest test) {
	        super(); 
	        this.driver = driver;
	        this.test = test;
	    }

	    
	    public void login(String username, String password) throws InterruptedException {
	        try {
	            test.info("Navigating to the login page!!!");
	            driver.findElement(getLocator("login.usernameField")).sendKeys(username);
	            test.info("Entered username: " + username);
	            Thread.sleep(1000);
	            driver.findElement(getLocator("login.passwordField")).sendKeys(password);
	            test.info("Entered password: " + password);
	            Thread.sleep(1000);
	            driver.findElement(getLocator("login.submitButton")).click();
	            test.info("Clicked on the submit button");
	            Thread.sleep(2000);
	            String successfulMsgText = driver.findElement(getLocator("login.successfulMsg")).getText();
	            Assert.assertEquals(successfulMsgText, "Logged In Successfully");
	            test.pass("Logged in Successfully!!!");
	        } catch (AssertionError e) {
	            test.fail("Login failed with exception: " + e.getMessage());
	            throw e; // Rethrow to ensure test fails
	        } catch (Exception e) {
	            test.fail("An error occurred: " + e.getMessage());
	            throw e; // Rethrow to ensure test fails
	        }
	    }
}