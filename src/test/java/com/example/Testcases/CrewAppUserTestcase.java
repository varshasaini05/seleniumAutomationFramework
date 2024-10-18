package com.example.Testcases;

import java.util.Set;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.CrewAppUsersPage;

public class CrewAppUserTestcase extends BaseTest {
	String phoneNumber;
	String email;

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
			String[] userInfo = crewAppUser.createCrewAppUser();
			phoneNumber = userInfo[0];
			email = userInfo[1];
			BaseTest.setTest(test);
		} else {
			System.err.println("ExtentTest is not initialized.");
		}

	}

	@Test(priority=2,enabled = false)
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

	@Test(priority=3)
	public void ColumnFilters() throws InterruptedException {

		ExtentTest test = extent.createTest("Filters validation for Crew App User Test");

		if (test != null) {

			CrewAppUsersPage crewAppUser = new CrewAppUsersPage(driver, test);

			//			crewAppUser.validateDeployerIdFilter();
			Thread.sleep(2000);
			crewAppUser.validateNameFilter();
			//			crewAppUser.validatePhoneNumberFilter(phoneNumber);
			crewAppUser.validateEmailFilter(email);
			crewAppUser.viewCVFilter();
			crewAppUser.disciplineFilter();
			crewAppUser.poolStatusFilter();
			crewAppUser.countryFilter();
			crewAppUser.roleFilter();
			crewAppUser.yearOfExperienceFilter();
			crewAppUser.subDisciplineFilter();
			crewAppUser.userTypeFilter();
			//			crewAppUser.createdOnFilter();
			//			crewAppUser.updatedOnFilter();
			//			crewAppUser.holdOnFilter();
			//			crewAppUser.holdReasonFilter();
			//			crewAppUser.firstLoginFilter();
			//			crewAppUser.lastLoginAtFilter();
			//			crewAppUser.CVUploadedFilter();
			//			crewAppUser.accountIDFilter();
			//			crewAppUser.statusFilter();
			//			crewAppUser.blockedProfile();
			//			crewAppUser.ERPIDFilter();
			//			crewAppUser.usernameFilter();
			//			crewAppUser.lastSyncDeployer();

			BaseTest.setTest(test);
		} else {
			System.err.println("ExtentTest is not initialized.");
		}

	}

}
