package com.example.Testcases;

import java.util.Set;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.CrewAppUsersPage;

public class CrewAppUserTestcase extends BaseTest {
        @Test(priority=1)
	    public void createUser() throws InterruptedException {
			String Email="3_employee@mailinator.com";
	    	String Password="Pass@1234";
	        ExtentTest test = extent.createTest("Create Crew App User Test");

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
	                
	                Thread.sleep(500);
	    	        dashboard.clickOnHambergerIcon();
	                test.info("Click on hamburger Icon");
	    	        dashboard.clickOnUsersOption();
	                test.info("Click on Users option");
	    	        dashboard.clickOnCrewAppUsers();
	                test.info("Select crew app users option");
	                CrewAppUsersPage crewAppUser = new CrewAppUsersPage(driver, test);
	                crewAppUser.createCrewAppUser();
	    	        BaseTest.setTest(test);
	    	    } else {
	    	        System.err.println("ExtentTest is not initialized.");
	    	    }
	    	
	    }
        
        @Test(priority=2)
        public void updateUser() throws InterruptedException {
        	
        	 ExtentTest test = extent.createTest("Update Crew App User Test");

	    	 if (test != null) {
	    		 CrewAppUsersPage crewAppUser = new CrewAppUsersPage(driver, test);
	    		 crewAppUser.editCrewAppUser();
		         BaseTest.setTest(test);
	    	    } else {
	    	        System.err.println("ExtentTest is not initialized.");
	    	    }
        }
}
