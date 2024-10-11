package com.example.Testcases;

import java.util.Set;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import pageObjects.LoginPage;
import pageObjects.PortalUsersPage;
import pageObjects.DashboardPage;

public class PortalUserTestcase extends BaseTest{

	@Test(priority=1)
	public void createUser() throws InterruptedException {
		String Email="3_employee@mailinator.com";
		String Password="Pass@1234";
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
			PortalUsersPage portalUser = new PortalUsersPage(driver, test);
			portalUser.createPortalUser();
			BaseTest.setTest(test);
		} else {
			System.err.println("ExtentTest is not initialized.");
		}

	}

	@Test(priority=2)
	public void editUser() throws Exception {
		ExtentTest test = extent.createTest("Edit Portal User Test");

		if (test != null) {
			PortalUsersPage portalUser = new PortalUsersPage(driver, test);
			portalUser.editPortalUser();
			BaseTest.setTest(test);
		} else {
			System.err.println("ExtentTest is not initialized.");
		} 
	}

	@Test(priority=3)
	public void searchUser() throws Exception {
		ExtentTest test = extent.createTest("Search Portal User Test");

		if (test != null) {
			PortalUsersPage portalUser = new PortalUsersPage(driver, test);
			portalUser.searchPortalUser();
			BaseTest.setTest(test);
		} else {
			System.err.println("ExtentTest is not initialized.");
		} 
	}

	@Test(priority=4)
	public void paginationFunctionality() throws Exception {

		ExtentTest test = extent.createTest("Pagination functionality on portal user page Test");

		if (test != null) {
			PortalUsersPage portalUser = new PortalUsersPage(driver, test);
			portalUser.paginationPortalUser();
			BaseTest.setTest(test);
		} else {
			System.err.println("ExtentTest is not initialized.");
		} 
	}

	@Test(priority=5)
	public void displayRecordsFunctionality() throws Exception {

		ExtentTest test = extent.createTest("Display Records functionality on portal user page Test");

		if (test != null) {
			PortalUsersPage portalUser = new PortalUsersPage(driver, test);
			portalUser.displayRecordsPortalUser();
			BaseTest.setTest(test);
		} else {
			System.err.println("ExtentTest is not initialized.");
		} 
	}
}
