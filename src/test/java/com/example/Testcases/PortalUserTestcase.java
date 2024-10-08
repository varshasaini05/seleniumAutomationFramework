package com.example.Testcases;

import java.util.Set;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.example.Utils.RetryAnalyzer;
import pageObjects.LoginPage;
import pageObjects.portalUsersPage;
import pageObjects.DashboardPage;

public class PortalUserTestcase extends BaseTest{
	
	 @Test(retryAnalyzer = RetryAnalyzer.class)
	    public void createUser() throws InterruptedException {
			String Email="3_employee@mailinator.com";
	    	String Password="Pass@123";
	        ExtentTest test = extent.createTest("Create Portal User Test");

	    	 if (test != null) {
	    		 
	    	        LoginPage loginPage = new LoginPage(driver, test);
	    	        loginPage.login(Email,Password);	    	        
	    	        DashboardPage dashboard = new DashboardPage(driver, test);
	    	        dashboard.clickOnDropdownMenu();
	    	        test.info("Click on dropdown");
	    	        dashboard.clickOnCrewAppIcon();
	    	        test.info("Click on crew app icon");
	    	      
	                String originalWindow = driver.getWindowHandle();
	                Set<String> allWindows = driver.getWindowHandles();
	                for (String windowHandle : allWindows) {
	                    if (!windowHandle.equals(originalWindow)) {
	                        driver.switchTo().window(windowHandle);
	                        break;
	                    }
	                }
	                
	                Thread.sleep(1000);
	    	        dashboard.clickOnHambergerIcon();
	                test.info("Click on hamburger Icon");
	    	        dashboard.clickOnUsersOption();
	                test.info("Click on Users option");
	    	        dashboard.clickOnPortalUsers();
	                test.info("Select portal users option");
	    	        portalUsersPage portalUser = new portalUsersPage(driver, test);
	    	        portalUser.createPortalUser();
	    	        BaseTest.setTest(test);
	    	    } else {
	    	        System.err.println("ExtentTest is not initialized.");
	    	    }
	    	
	    }
}
