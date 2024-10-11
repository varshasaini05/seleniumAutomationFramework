package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.example.Testcases.BaseTest;

public class PortalUsersPage extends BaseTest{
	private ExtentTest test;
	String FirstName = "Dhruvi";
	String Email="v45@mailinator.com";
	String UpdatedEmail="v46@mailinator.com";

	@FindBy(xpath = "//span[contains(text(),'Add User')]")
	private WebElement AddUserButton;

	@FindBy(xpath = "//select[@id='m_user_type']")
	private WebElement UserTypeDropdown;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement FirstNameField;

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement LastNameField;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailField;

	@FindBy(xpath = "//input[@id='phone_code']")
	private WebElement phoneCode;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//input[@id='pass']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='repass']")
	private WebElement confirmPassword;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	private WebElement submitButton;

	@FindBy(xpath = "(//a[@title=\"Edit\"])[1]")
	private WebElement editButton;

	@FindBy(xpath = "//button[normalize-space()='Update']")
	private WebElement updateButton;

	@FindBy(xpath = "//input[@id='generalSearch']")
	private WebElement searchBar;

	@FindBy(xpath = "//a[@title='Next']")
	private WebElement nextButton;

	@FindBy(xpath = "//a[@title='Last']")
	private WebElement lastButton;

	@FindBy(xpath = "//a[@title='Previous']")
	private WebElement previousButton;

	@FindBy(xpath = "//a[@title='First']")
	private WebElement firstButton;

	@FindBy(xpath = "//span[@class='filter-option pull-left']")
	private WebElement displayRecordsDropdown;

	@FindBy(xpath = "(//span[@class='text'][normalize-space() and string-length() > 0])[2]")
	private WebElement DropdownOption;

	@FindBy(css = "[title=\"Select page size\"]>.filter-option")
	private WebElement SelectedPageLimit;


	public PortalUsersPage(WebDriver driver, ExtentTest test) {
		super(); 
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public void createPortalUser() throws InterruptedException {
		try {

			test.info("Navigating to create portal user!!!");
			AddUserButton.click();
			test.info("Click on add user button");
			Select dropdown = new Select(UserTypeDropdown);
			dropdown.selectByVisibleText("Admin");
			test.info("Select user type : Admin");
			FirstNameField.sendKeys(FirstName);
			test.info("Enter first name : " + FirstName);
			String LastName = "Rawat";
			LastNameField.sendKeys(LastName);
			test.info("Enter last name : " + LastName );
			EmailField.sendKeys(Email);
			test.info("Enter Email : " + Email);
			phoneCode.sendKeys("+91");
			test.info("Enter phone code");
			phoneNumber.click();
			phoneNumber.sendKeys("8887827930");
			test.info("Enter phone number");
			password.sendKeys("Password@05");
			test.info("Enter password");
			confirmPassword.sendKeys("Password@05");
			test.info("Enter confirm password");
			submitButton.click();
			test.info("Click on submit button");

			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().refresh();
			String dynamicXPath = String.format("//span[normalize-space()='%s']", Email);
			WebElement emailElement = driver.findElement(By.xpath(dynamicXPath));

			// Validate if the email element is displayed
			if (emailElement.isDisplayed()) {
				System.out.println("The email '" + Email + "' is present on the webpage.");
				test.info("User created successfully.");
			} else {
				System.out.println("The email '" + Email + "' is NOT present on the webpage.");
				test.info("User not created.");
			}

		} catch (AssertionError e) {
			test.fail("Login failed with exception: " + e.getMessage());
			throw e; // Rethrow to ensure test fails
		} catch (Exception e) {
			test.fail("An error occurred: " + e.getMessage());
			throw e; // Rethrow to ensure test fails
		}
	}

	public void editPortalUser() throws Exception {
		try {

			editButton.click();
			test.info("Click on edit button");

			EmailField.clear();
			EmailField.sendKeys(UpdatedEmail);
			test.info("Update Email");

			phoneNumber.clear();
			phoneNumber.sendKeys("7644471340");
			test.info("Update phone number");

			updateButton.click();
			test.info("Click on update button");

			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().refresh();
			String dynamicXPath = String.format("//span[normalize-space()='%s']", UpdatedEmail);
			WebElement emailElement = driver.findElement(By.xpath(dynamicXPath));

			// Validate if the email element is displayed
			if (emailElement.isDisplayed()) {
				System.out.println("The email '" + UpdatedEmail + "' is present on the webpage.");
				test.info("User updated successfully.");
			} else {
				System.out.println("The email '" + UpdatedEmail + "' is NOT present on the webpage.");
				test.info("User not updated.");
			}
		} catch (AssertionError e) {
			test.fail("Login failed with exception: " + e.getMessage());
			throw e; // Rethrow to ensure test fails
		} catch (Exception e) {
			test.fail("An error occurred: " + e.getMessage());
			throw e; // Rethrow to ensure test fails
		}
	}

	public void searchPortalUser() throws Exception {

		try {

			searchBar.sendKeys(FirstName);
			Thread.sleep(1000);
			test.info("Enter name into search bar");

			String dynamicXPath = String.format("//span[normalize-space()='%s']", UpdatedEmail);
			WebElement emailElement = driver.findElement(By.xpath(dynamicXPath));

			// Validate if the email element is displayed
			if (emailElement.isDisplayed()) {
				System.out.println("The email '" + UpdatedEmail + "' is present on the webpage while search.");
				test.info("User searched successfully.");
			} else {
				System.out.println("The email '" + UpdatedEmail + "' is NOT present on the webpage while search.");
				test.info("User not found.");
			}

		} catch (AssertionError e) {
			test.fail("Login failed with exception: " + e.getMessage());
			throw e; // Rethrow to ensure test fails
		} catch (Exception e) {
			test.fail("An error occurred: " + e.getMessage());
			throw e; // Rethrow to ensure test fails
		}
	}

	public void paginationPortalUser() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(1000);

		//Automate next button
		nextButton.click();
		Thread.sleep(2000);
		WebElement emailElement1= driver.findElement(By.xpath("(//span[contains(normalize-space(), '@')])[1]"));
		String Email1 = emailElement1.getText();
		String Email2 = UpdatedEmail;
		// Assert that the mails are not equal
		Assert.assertNotEquals(Email1, Email2, "Test failed: Both email addresses are the same - " + Email1);
		// Pass confirmation message if mails are different
		System.out.println("Emails are different. Test passed. Email1: " + Email1 + ", Email2: " + Email2);
		test.info("Next button Validated.");
		Thread.sleep(1000);

		//Automate last button
		lastButton.click();
		Thread.sleep(2000);
		WebElement emailElement2= driver.findElement(By.xpath("(//span[contains(normalize-space(), '@')])[1]"));
		String Email11 = emailElement2.getText();
		// Assert that the mails are not equal
		Assert.assertNotEquals(Email11, Email2, "Test failed: Both email addresses are the same - " + Email11);
		// Pass confirmation message if mails are different
		System.out.println("Emails are different. Test passed. Email1: " + Email11 + ", Email2: " + Email2);
		test.info("Last button Validated.");
		Thread.sleep(1000);

		//Automate previous button
		previousButton.click();
		Thread.sleep(2000);
		WebElement emailElement3= driver.findElement(By.xpath("(//span[contains(normalize-space(), '@')])[1]"));
		String Email111 = emailElement3.getText();
		// Assert that the mails are not equal
		Assert.assertNotEquals(Email111, Email2, "Test failed: Both email addresses are the same - " + Email111);
		// Pass confirmation message if mails are different
		System.out.println("Emails are different. Test passed. Email1: " + Email111 + ", Email2: " + Email2);
		test.info("Previous button Validated.");
		Thread.sleep(1000);

		//Automate first button
		firstButton.click();
		Thread.sleep(2000);
		WebElement emailElement4= driver.findElement(By.xpath("(//span[contains(normalize-space(), '@')])[1]"));
		String Email1111 = emailElement4.getText();
		// Assert that the mails are equal
		Assert.assertEquals(Email1111, Email2, "Test failed: Both email addresses are not the same - Email1: " + Email1111 + ", Email2: " + Email2);
		// Pass confirmation message if mails are the same
		System.out.println("Emails are the same. Test passed. Email1: " + Email1111 + ", Email2: " + Email2);
		test.info("First button Validated.");

	}

	public void displayRecordsPortalUser() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(1000);
		displayRecordsDropdown.click();
		Thread.sleep(2000);
		test.info("Click on dropdown");
		DropdownOption.click();
		Thread.sleep(2000);
		test.info("Select option from dropdown");

		// Locate the table rows using XPath
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='m-datatable__table']//tbody/tr"));
		// Get the row count
		int rowCount = tableRows.size();
		// Print the row count
		System.out.println("Number of records in the table: " + rowCount);

		// Validate that the row count matches the dropdown selection
		int dropdownSelectionCount = Integer.parseInt(SelectedPageLimit.getText());
		System.out.println(dropdownSelectionCount);
		Assert.assertEquals(rowCount, dropdownSelectionCount, 
				"Test failed: The table row count (" + rowCount + ") does not match the dropdown selection (" + dropdownSelectionCount + ")");
		// If matched, print success message
		System.out.println("The table row count matches the dropdown selection. Test passed.");
        test.info("table row count matches the dropdown selection");
	}
}
