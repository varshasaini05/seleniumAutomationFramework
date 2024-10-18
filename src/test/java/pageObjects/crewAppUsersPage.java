package pageObjects;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import com.aventstack.extentreports.ExtentTest;
import com.example.Testcases.BaseTest;

public class CrewAppUsersPage extends BaseTest{
	private ExtentTest test;
	String FirstName = "John";
	String LastName = "Mavros";
	String Discipline1 = "CBM";
	String Nationality = "India";
	String UserRole1 = "Data Analyst";
	String YrsOfExperience = "4";
	String SubDiscipline1a = "Drilling";
	String userType = "APP";

	public CrewAppUsersPage(WebDriver driver, ExtentTest test) {
		super(); 
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Add user']")
	private WebElement AddUserButton;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement FirstNameField;

	@FindBy(xpath = "//input[@id='lname']")
	private WebElement LastNameField;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailField;

	@FindBy(xpath = "//span[@class='filter-option pull-left'][normalize-space()='Nationality']")
	private WebElement NationalityField;

	@FindBy(xpath = "//div[@class='dropdown-menu open show']//input[@aria-label='Search']")
	private WebElement NationalityFieldSearchBar;

	@FindBy(xpath = "//input[@id='dob']")
	private WebElement DOBDropdown;

	@FindBy(xpath = "//a[@class='ui-state-default'][normalize-space()='1']")
	private WebElement Date;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement monthDropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement yearDropdown;

	@FindBy(xpath = "//input[@id='phone_code']")
	private WebElement phoneCode;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneInputField;

	@FindBy(xpath = "//input[@id='totalexperience']")
	private WebElement TotalExperience;

	@FindBy(xpath = "//button[@title='Months']")
	private WebElement TotalExperienceMonths;

	@FindBy(xpath = "//input[@id='Trustscore']")
	private WebElement TrustScoreField;

	@FindBy(xpath = "//button[@title='User Role 1']")
	private WebElement UserRole1Field;

	@FindBy(xpath = "//button[@title='User Role 2']")
	private WebElement UserRole2Field;

	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement UserType;

	@FindBy(xpath = "//button[@title='Discipline 1']")
	private WebElement Discipline1Field;

	@FindBy(xpath = "//button[@title='Sub Discipline 1a']")
	private WebElement SubDiscipline1aField;

	@FindBy(xpath = "//button[@title='Discipline 2']")
	private WebElement Discipline2Field;

	@FindBy(xpath = "//button[@title='Sub Discipline 2a']")
	private WebElement SubDiscipline2aField;

	@FindBy(xpath = "//textarea[@id='current_address']")
	private WebElement CurrentAddressField;

	@FindBy(xpath = "//button[@title='Current Country']")
	private WebElement CurrentCountry;

	@FindBy(xpath = "//div[@class='dropdown-menu open show']//input[@aria-label='Search']")
	private WebElement CurrentCountrySearchBar;

	@FindBy(xpath = "//button[@title='Current State']//span[@class='caret']")
	private WebElement CurrentStateArrowButton;

	@FindBy(xpath = "//button[@title='Current State']")
	private WebElement CurrentState;

	@FindBy(xpath = "//input[@id='current_city']")
	private WebElement CurrentCity;

	@FindBy(xpath = "//input[@id='current_postal_code']")
	private WebElement CurrentPostalCode;

	@FindBy(xpath = "//input[@value='1']")
	private WebElement StatusActiveRadioButton;

	@FindBy(xpath = "//input[@id='profile_image']")
	private WebElement ChooseFileButton;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	private WebElement SubmitButton;

	@FindBy(xpath = "//a[normalize-space()='Cancel']")
	private WebElement CancelButton;

	@FindBy(xpath = "(//div[@id=\"dropidpopup\"])[1]")
	private WebElement ThreeDotIcon;

	@FindBy(xpath = "//ul[@class=\"dropdown-menu pop-up-menu show\"]/li/a")
	private WebElement ViewProfileButton;

	@FindBy(xpath = "//button[@id='changetoreadonly']")
	private WebElement EditButton;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[2]")
	private WebElement DeployerIdColumn;

	@FindBy(xpath = "//div[@id='184-display']")
	private WebElement DeployerIdHamburgerDropdown;

	@FindBy(xpath = "//div[@ref='eValueFrom1']//input[@placeholder='Filter...']")
	private WebElement DeployerIdHamburgerFilter;

	@FindBy(xpath = "//button[normalize-space()='Apply']")
	private WebElement ApplyButton;

	@FindBy(xpath = "//div[normalize-space() and number(normalize-space())]")
	private WebElement DeployerIdColumnValue;

	@FindBy(xpath = "(//a[@title='Reset filters'])[2]")
	private WebElement ResetFiltersButton;

	@FindBy(xpath = "//div[@ref=\"eValue1\"]//input[@placeholder='Filter...']")
	private WebElement NameHamburgerFilter;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[3]")
	private WebElement NameColumn;

	@FindBy(xpath = "(//div[@col-id='full_name_user'])[2]")
	private WebElement NameColumnValue;

	@FindBy(xpath = "//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable ag-header-cell-filtered']")
	private WebElement PhoneNumberColumn;

	@FindBy(xpath = "//div[@ref='eOptions1']//span[@class='ag-icon ag-icon-small-down']")
	private WebElement PhoneNumberHamburgerDropdown;

	@FindBy(xpath = "//div[@ref=\"eValueFrom1\"]//input[@placeholder='Filter...']")
	private WebElement PhoneNumberHamburgerFilter;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[4]")
	private WebElement EmailColumn;

	@FindBy(xpath = "//div[@ref='eValue1']//input[@placeholder='Filter...']")
	private WebElement EmailHamburgerFilter;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[6]")
	private WebElement ViewCVColumn;

	@FindBy(xpath = "(//div[@class='ag-set-filter-item-checkbox ag-labeled ag-label-align-right ag-checkbox ag-input-field']/div[@class='ag-input-field-label ag-label ag-checkbox-label'])[2]")
	private WebElement IsCVCheckbox;

	@FindBy(xpath = "(//div[@class='ag-set-filter-item-checkbox ag-labeled ag-label-align-right ag-checkbox ag-input-field']/div[@class='ag-input-field-label ag-label ag-checkbox-label'])[3]")
	private WebElement NotCVCheckbox;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[7]")
	private WebElement DisciplineColumn;

	@FindBy(xpath = "//div[@ref='eValue1']//input[@placeholder='Filter...']")
	private WebElement DisciplineFilter;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[8]")
	private WebElement PoolStatusColumn;

	@FindBy(xpath = "(//div[@ref=\"eCheckbox\"]//div[@class='ag-input-field-label ag-label ag-checkbox-label'])[3]")
	private WebElement PoolStatusCheckbox;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[9]")
	private WebElement CountryColumn;

	@FindBy(xpath = "//div[@ref='eValue1']//input[@placeholder='Filter...']")
	private WebElement CountryFilter;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[10]")
	private WebElement RoleColumn;

	@FindBy(xpath = "//div[@ref='eValue1']//input[@placeholder='Filter...']")
	private WebElement RoleFilter;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[11]")
	private WebElement YrsOfExperienceColumn;
	
	@FindBy(xpath = "//div[@ref='eValue1']//input[@placeholder='Filter...']")
	private WebElement YrsOfExperienceFilter;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[12]")
	private WebElement SubDisciplineColumn;
	
	@FindBy(xpath = "//div[@ref='eValue1']//input[@placeholder='Filter...']")
	private WebElement SubDisciplineFilter;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[13]")
	private WebElement UserTypeColumn;

	@FindBy(xpath = "//div[@class='ag-mini-filter ag-labeled ag-label-align-left ag-text-field ag-input-field']")
	private WebElement UserTypeSearchBar;
	
	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[14]")
	private WebElement CreatedOnColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[15]")
	private WebElement UpdatedOnColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[16]")
	private WebElement HoldOnColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[17]")
	private WebElement HoldReasonColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[18]")
	private WebElement FirstLoginColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[19]")
	private WebElement LastLoginAtColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[20]")
	private WebElement CVUploadedColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[21]")
	private WebElement AccountIDColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[22]")
	private WebElement StatusColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[23]")
	private WebElement BlockedProfileColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[24]")
	private WebElement ERPIDColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[25]")
	private WebElement UserNameColumn;

	@FindBy(xpath = "(//div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable'])[26]")
	private WebElement LastSyncDeployerColumn;


	// Method to generate a random 10-digit phone number
	public String generatePhoneNumber() {
		Random randomPHNumber = new Random();
		// The first digit of a phone number should not be 0 or 1
		int firstDigit = randomPHNumber.nextInt(9) + 1;  // Ensures first digit is between 1-9
		// Generate remaining 9 digits
		StringBuilder phoneNumber = new StringBuilder();
		phoneNumber.append(firstDigit);
		for (int i = 0; i < 9; i++) {
			phoneNumber.append(randomPHNumber.nextInt(10)); // Appends a random digit from 0 to 9
		}
		return phoneNumber.toString();
	}

	public String generateEmail() {
		// Define characters to be used in the email
		String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
		// Set the length for the random string part of the email
		int emailLength = 5;
		// Create a StringBuilder to construct the random email
		StringBuilder email = new StringBuilder();
		Random random = new Random();
		// Generate random characters
		for (int i = 0; i < emailLength; i++) {
			int index = random.nextInt(characters.length());
			email.append(characters.charAt(index));
		}
		// Append a domain to complete the email
		email.append("@mailinator.com");
		return email.toString();
	}


	public String[] createCrewAppUser() throws InterruptedException {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			String phoneNumber;
			String email;
			WebElement addUserButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Add user']")));

			test.info("Navigating to create crew app user!!!");
			addUserButton.click();
			test.info("Click on add user button");
			FirstNameField.sendKeys(FirstName);
			test.info("Enter first name : " + FirstName);
			LastNameField.sendKeys(LastName);
			test.info("Enter last name : " + LastName );

			email = generateEmail();
			EmailField.sendKeys(email);
			test.info("Enter Email : " + email);

			// Click on the dropdown to open it
			NationalityField.click();
			// Enter the search text
			NationalityFieldSearchBar.sendKeys(Nationality);
			Thread.sleep(1000);
			List<WebElement> nationality = driver.findElements(By.xpath("//button[@title=\"Nationality\"]/..//ul[@role=\"listbox\"]/li[not(@class=\"hidden\" or @class=\"selected hidden\")]"));
			for(WebElement option :nationality) {
				if(option.getText().equalsIgnoreCase("India")) {
					option.click();
					break;
				}
			}
			test.info("Enter Nationality");

			DOBDropdown.click();
			Select monthSelect = new Select(monthDropdown);
			Select yearSelect = new Select(yearDropdown);
			monthSelect.selectByVisibleText("Mar"); 
			yearSelect.selectByVisibleText("2017");   
			Date.click();
			test.info("Enter Date of birth");

			phoneCode.sendKeys("+91");
			test.info("Enter phone code");
			phoneInputField.click();

			phoneNumber = generatePhoneNumber();
			phoneInputField.sendKeys(phoneNumber);
			test.info("Enter phone number");

			TotalExperience.click();
			TotalExperience.clear();
			TotalExperience.sendKeys(YrsOfExperience);
			test.info("Enter Total Experience in yrs");

			Thread.sleep(3000);
			TotalExperienceMonths.click();
			List<WebElement> options = driver.findElements(By.xpath("//div[@class='dropdown-menu open show']/ul[@class=\"dropdown-menu inner\"]/li/a"));
			// Iterate through the options
			for (WebElement option : options) {
				if (option.getText().equals("11")) {
					// Use JavaScript to scroll the element into view
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
					break;
				}
			}
			test.info("Entered total experience in months: 11");

			TrustScoreField.click();
			TrustScoreField.clear();
			TrustScoreField.sendKeys("50");
			test.info("Enter Trust Score");

			UserRole1Field.click();
			List<WebElement> userRole1 = driver.findElements(By.xpath("//div[@class='dropdown-menu open show']/ul[@class=\"dropdown-menu inner\"]/li/a"));
			// Iterate through the options
			for (WebElement option : userRole1) {
				if (option.getText().equals(UserRole1)) {
					// Use JavaScript to scroll the element into view
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
					break;
				}
			}
			test.info("Enter user role 1");

			UserRole2Field.click();
			List<WebElement> userRole2 = driver.findElements(By.xpath("//div[@class='dropdown-menu open show']/ul[@class=\"dropdown-menu inner\"]/li/a"));
			// Iterate through the options
			for (WebElement option : userRole2) {
				if (option.getText().equals("Asst Driller")) {
					// Use JavaScript to scroll the element into view
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
					break;
				}
			}
			test.info("Enter user role 2");

			UserType.click();
			List<WebElement> UserType = driver.findElements(By.xpath("//div[@class='form-group m-form__group']/select[@class=\"form-control\"]/option"));
			// Iterate through the options
			for (WebElement option : UserType) {
				if (option.getText().equals(userType)) {
					// Use JavaScript to scroll the element into view
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
					break;
				}
			}
			test.info("Enter user type");

			Discipline1Field.click();
			List<WebElement> discipline1 = driver.findElements(By.xpath("//div[@class='dropdown-menu open show']/ul[@class=\"dropdown-menu inner\"]/li/a"));
			// Iterate through the options
			for (WebElement option : discipline1) {
				if (option.getText().equals(Discipline1)) {
					// Use JavaScript to scroll the element into view
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
					break;
				}
			}
			test.info("Enter discipline 1");

			SubDiscipline1aField.click();
			SubDiscipline1aField.sendKeys(SubDiscipline1a);
			List<WebElement> discipline1a = driver.findElements(By.xpath("//li[@class='active']//a[@role='option']"));
			Thread.sleep(3000);
			//Iterate through the options
			for (WebElement option : discipline1a) {
				if (option.getText().equals(SubDiscipline1a)) {
					// Use JavaScript to scroll the element into view
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
					break;
				}
			} 
			test.info("Enter sub Discipline 1a");

			Discipline2Field.click();
			Discipline2Field.sendKeys("CBM");
			List<WebElement> discipline2 = driver.findElements(By.xpath("//button[@title=\"Discipline 2\"]/..//ul[@class=\"dropdown-menu inner\"]/li/a"));
			Thread.sleep(1000);
			// Iterate through the options
			for (WebElement option : discipline2) {
				if (option.getText().equals("CBM")) {
					// Use JavaScript to scroll the element into view
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
					break;
				}
			}
			test.info("Enter discipline 2");

			Thread.sleep(5000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0, 0);");
			Thread.sleep(2000);
			SubDiscipline2aField.click();
			SubDiscipline2aField.sendKeys("Drilling");
			List<WebElement> discipline2a = driver.findElements(By.xpath("//li[@class='active']//a[@role='option']"));
			Thread.sleep(3000);
			//Iterate through the options
			for (WebElement option : discipline2a) {
				if (option.getText().equals("Drilling")) {
					// Use JavaScript to scroll the element into view
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
					break;
				}
			} 
			test.info("Enter sub Discipline 2a");

			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

			CurrentAddressField.click();
			CurrentAddressField.sendKeys("South Extension");
			test.info("Enter Address");

			CurrentCountry.click();
			CurrentCountrySearchBar.sendKeys("Ind");
			List<WebElement> currentCountry = driver.findElements(By.xpath("//div[@class='btn-group bootstrap-select form-control m_ dropdown show open']//li[103]//a[1]"));
			Thread.sleep(1000);
			//Iterate through the options
			for (WebElement option : currentCountry) {
				if (option.getText().equals("India")) {
					// Use JavaScript to scroll the element into view
					JavascriptExecutor jsex = (JavascriptExecutor) driver;
					jsex.executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
					break;
				}
			} 
			test.info("Enter Country");
			Thread.sleep(7000);

			CurrentStateArrowButton.click();
			CurrentState.sendKeys("Haryana");
			List<WebElement> currentState = driver.findElements(By.xpath("//ul[@aria-expanded='true']//li[@class='active']//a[@role='option']"));
			Thread.sleep(1000);
			//Iterate through the options
			for (WebElement option : currentState) {
				if (option.getText().equals("Haryana")) {
					// Use JavaScript to scroll the element into view
					JavascriptExecutor jsex = (JavascriptExecutor) driver;
					jsex.executeScript("arguments[0].scrollIntoView(true);", option);
					option.click();
					break;
				}
			} 
			test.info("Enter State");
			Thread.sleep(1000);

			CurrentCity.click();
			CurrentCity.sendKeys("New Delhi");
			test.info("Enter city");

			CurrentPostalCode.click();
			CurrentPostalCode.sendKeys("110049");
			test.info("Enter Postal Code");
			Thread.sleep(1000);

			StatusActiveRadioButton.click();
			test.info("Set status as Active");
			Thread.sleep(2000);

			ChooseFileButton.sendKeys("C:\\Users\\Varsha\\Desktop\\Img1.jpg");
			test.info("Upload profile picture");

			SubmitButton.click();
			test.info("Click on submit button");

			Thread.sleep(20000);

			JavascriptExecutor jsexec = (JavascriptExecutor) driver;
			jsexec.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			CancelButton.click();
			driver.navigate().refresh();
			Thread.sleep(10000);
			String dynamicXPath = String.format("//div[normalize-space()='%s']", email);
			WebElement emailElement = driver.findElement(By.xpath(dynamicXPath));
			Thread.sleep(5000);
			// Validate if the email element is displayed
			if (emailElement.isDisplayed()) {
				System.out.println("The email '" + email + "' is present on the webpage.");
				test.info("User created successfully.");
			} else {
				System.out.println("The email '" + email + "' is NOT present on the webpage.");
				test.info("User not created.");
			}

			String[] result = { phoneNumber, email };
			return result;


		} catch (AssertionError e) {
			test.fail("Login failed with exception: " + e.getMessage());
			throw e; // Rethrow to ensure test fails
		} catch (Exception e) {
			test.fail("An error occurred: " + e.getMessage());
			throw e; // Rethrow to ensure test fails
		}
	}

	public void editCrewAppUser() throws InterruptedException {

		ThreeDotIcon.click();
		test.info("Click on 3 dot icon");
		ViewProfileButton.click();
		test.info("Click on view profile icon");
		EditButton.click();
		test.info("Click on edit button");

		String firstName = "Riya";
		FirstNameField.clear();
		FirstNameField.sendKeys(firstName);
		test.info("Update name");

		SubmitButton.click();
		test.info("Click on submit button for edit Info.");

		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().refresh();
	}

	public WebElement getHamburgerIconWithLabel(String labelName) {
		WebElement hamburger = driver.findElement(By.xpath("//div[@class='ag-header-cell-label']/span[contains(text(),'"+labelName+"')]/../..//span[@class='ag-icon ag-icon-menu']"));
		return hamburger;
	}

	public void validateDeployerIdFilter() throws InterruptedException {

		Actions actions = new Actions(driver);
		actions.moveToElement(DeployerIdColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_deployerId = getHamburgerIconWithLabel("Deployer Id");
		HamburgerIcon_deployerId.click();
		Thread.sleep(1000);

		DeployerIdHamburgerDropdown.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ag-list-item ag-select-list-item']")));

		for (WebElement option : options) {
			if (option.getText().equals("Not equal")) {
				wait.until(ExpectedConditions.elementToBeClickable(option));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", option);
				break;
			}
		}

		Thread.sleep(3000);
		DeployerIdHamburgerFilter.click();
		String DeployerIdValue=String.valueOf(500);
		DeployerIdHamburgerFilter.sendKeys(DeployerIdValue);
		ApplyButton.click();
		Thread.sleep(2000);

		//Verify the Deployer Id Column filtered result
		String text = DeployerIdColumnValue.getText(); 
		int deployerId = Integer.parseInt(text);
		Assert.assertNotEquals(deployerId,Integer.parseInt(DeployerIdValue));
		test.info("Deployer id filter validate.");
		Thread.sleep(5000);

	}


	public void validateNameFilter() throws InterruptedException {
		ResetFiltersButton.click();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(NameColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_name = getHamburgerIconWithLabel("Name");
		HamburgerIcon_name.click();
		Thread.sleep(3000);
		NameHamburgerFilter.sendKeys(FirstName);
		ApplyButton.click();
		Thread.sleep(2000);

		List<WebElement> nameRecords = driver.findElements(By.xpath("//div[@col-id=\"full_name_user\" and @role=\"gridcell\"]"));
		// Loop through each element and check if it contains "tiyo"
		for (WebElement record : nameRecords) {
			String actualName = record.getText().toLowerCase();
			Assert.assertTrue(actualName.contains(FirstName.toLowerCase()), 
					"Name does not contain the expected part: " + FirstName);
		}	
		test.info("Name filter validate.");
		Thread.sleep(5000);
	}


	public void validatePhoneNumberFilter(String phoneNumber) throws InterruptedException {
		System.out.println("starting of phone number filter");
		ResetFiltersButton.click();
		System.out.println("after reset filter in phone number field");
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(PhoneNumberColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_phoneNumber = getHamburgerIconWithLabel("(+Code)Phone");
		HamburgerIcon_phoneNumber.click();
		Thread.sleep(3000);

		PhoneNumberHamburgerDropdown.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ag-list-item ag-select-list-item']")));

		for (WebElement option : options) {
			if (option.getText().equals("Not equal")) {
				wait.until(ExpectedConditions.elementToBeClickable(option));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", option);
				break;
			}
		}

		Thread.sleep(3000);
		PhoneNumberHamburgerFilter.click();
		DeployerIdHamburgerFilter.sendKeys(phoneNumber);
		Thread.sleep(2000);
		ApplyButton.click();
		Thread.sleep(5000);

		List<WebElement> nameRecords = driver.findElements(By.xpath("//div[@col-id='display_name' and @role='gridcell']"));

		for (WebElement record : nameRecords) {
			String actualName = record.getText();
			Assert.assertFalse(actualName.contains(phoneNumber), 
					"Test failed: Name contains the phone number, which is unexpected. Name: " + actualName);
		}
		test.info("Phone number filter validate.");
		Thread.sleep(5000);
	}

	public void validateEmailFilter(String email) throws InterruptedException {
		ResetFiltersButton.click();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(EmailColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_Email = getHamburgerIconWithLabel("Email");
		HamburgerIcon_Email.click();
		Thread.sleep(3000);

		EmailHamburgerFilter.click();
		EmailHamburgerFilter.sendKeys(email);
		Thread.sleep(2000);
		ApplyButton.click();
		Thread.sleep(5000);

		List<WebElement> nameRecords = driver.findElements(By.xpath("//div[@col-id='email' and @role='gridcell']"));

		for (WebElement record : nameRecords) {
			String actualName = record.getText();
			Assert.assertTrue(actualName.contains(email.toLowerCase()), 
					"Name does not contain the expected part: " + email);	
		}
		test.info("Email filter validate.");
		Thread.sleep(5000);
	}

	public void viewCVFilter() throws InterruptedException {
		ResetFiltersButton.click();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(ViewCVColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_ViewCV = getHamburgerIconWithLabel("View CV");
		HamburgerIcon_ViewCV.click();
		Thread.sleep(3000);
		IsCVCheckbox.click();
		Thread.sleep(2000);
		ApplyButton.click();
		Thread.sleep(7000);
		//Validate number of records equals to CV records
		List<WebElement> CVRecords= driver.findElements(By.xpath("//div[@col-id='viewcv' and @role='gridcell']//a[@title='View CV']"));
		int CVRecordsCount = CVRecords.size();
		// Locate all rows in the table (assuming the table has a <tbody>)
		List<WebElement> CVRecordsRows = driver.findElements(By.xpath("//div[@col-id='viewcv' and @role='gridcell']"));
		// Get the count of rows
		int CVRecordsrowCount = CVRecordsRows.size();
		Assert.assertEquals(CVRecordsCount, CVRecordsrowCount, "The number of CV records does not match the number of table records.");

		test.info("View CV filter validate.");
		Thread.sleep(5000);
	}

	public void disciplineFilter() throws InterruptedException {
		ResetFiltersButton.click();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(DisciplineColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_Discipline = getHamburgerIconWithLabel("Discipline");
		HamburgerIcon_Discipline.click();
		Thread.sleep(3000);

		DisciplineFilter.click();
		DisciplineFilter.sendKeys(Discipline1);
		Thread.sleep(2000);
		ApplyButton.click();
		Thread.sleep(5000);

		List<WebElement> disciplineRecords = driver.findElements(By.xpath("//div[@col-id='displine_name_user' and @role='gridcell']"));

		for (WebElement record : disciplineRecords) {
			String actualName = record.getText();
			Assert.assertTrue(actualName.contains(Discipline1), 
					"Name does not contain the expected part: " + Discipline1);	
		}
		test.info("Discipline filter validate.");
		Thread.sleep(5000);
	}

	public void poolStatusFilter() throws InterruptedException {
		ResetFiltersButton.click();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(PoolStatusColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_PoolStatus = getHamburgerIconWithLabel("Pool Status");
		HamburgerIcon_PoolStatus.click();
		Thread.sleep(3000);

		String poolStatusText = PoolStatusCheckbox.getText();
		PoolStatusCheckbox.click();
		Thread.sleep(2000);
		ApplyButton.click();
		Thread.sleep(5000);

		List<WebElement> poolStatusRecords = driver.findElements(By.xpath("//div[@col-id='pool_id' and @role='gridcell']"));

		for (WebElement record : poolStatusRecords) {
			String actualName = record.getText();
			Assert.assertTrue(actualName.contains(poolStatusText), 
					"Name does not contain the expected part: " + poolStatusText);	
		}
		test.info("Pool Status filter validate.");
		Thread.sleep(5000);	
	}

	public void countryFilter() throws InterruptedException {
		ResetFiltersButton.click();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(CountryColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_Country = getHamburgerIconWithLabel("Country");
		HamburgerIcon_Country.click();
		Thread.sleep(3000);

		CountryFilter.click();
		CountryFilter.sendKeys(Nationality);
		Thread.sleep(2000);
		ApplyButton.click();
		Thread.sleep(5000);

		List<WebElement> countryRecords = driver.findElements(By.xpath("//div[@col-id='country_name' and @role='gridcell']"));

		for (WebElement record : countryRecords) {
			String actualName = record.getText();
			Assert.assertTrue(actualName.contains(Nationality), 
					"Name does not contain the expected part: " + Nationality);	
		}
		test.info("Nationality filter validate.");
		Thread.sleep(5000);

	}

	public void roleFilter() throws InterruptedException {
		ResetFiltersButton.click();
		Thread.sleep(5000);

		WebElement cell = driver.findElement(By.xpath("//span[@class='ag-header-cell-text'][normalize-space()='Role']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", cell);
		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.moveToElement(RoleColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_Role = getHamburgerIconWithLabel("Role");
		HamburgerIcon_Role.click();
		Thread.sleep(3000);

		RoleFilter.click();
		RoleFilter.sendKeys(UserRole1);
		Thread.sleep(2000);
		ApplyButton.click();
		Thread.sleep(5000);

		List<WebElement> roleRecords = driver.findElements(By.xpath("//div[@col-id='role_name_user' and @role='gridcell']"));
		for (WebElement record : roleRecords) {
			String actualName = record.getText();
			Assert.assertTrue(actualName.contains(UserRole1), 
					"Name does not contain the expected part: " + UserRole1);	
		}
		test.info("Role filter validate.");
		Thread.sleep(5000);
	}

	public void yearOfExperienceFilter() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ResetFiltersButton);
		Thread.sleep(5000);

		WebElement cell = driver.findElement(By.xpath("//span[@class='ag-header-cell-text'][normalize-space()='Year of Experience']"));
		js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", cell);
		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.moveToElement(YrsOfExperienceColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_yrsOfExperience = getHamburgerIconWithLabel("Year of Experience");
		HamburgerIcon_yrsOfExperience.click();
		Thread.sleep(3000);

		YrsOfExperienceFilter.click();
		YrsOfExperienceFilter.sendKeys(YrsOfExperience);
		Thread.sleep(2000);
		ApplyButton.click();
		Thread.sleep(5000);

		List<WebElement> yrsOfExpRecords = driver.findElements(By.xpath("//div[@col-id='total_exp' and @role='gridcell']"));
		for (WebElement record : yrsOfExpRecords) {
			String actualName = record.getText();
			Assert.assertTrue(actualName.contains(YrsOfExperience), 
					"Name does not contain the expected part: " + YrsOfExperience);	
		}
		test.info("Years of Experience filter validate.");
		Thread.sleep(5000);
	}

	public void subDisciplineFilter() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ResetFiltersButton);
		Thread.sleep(5000);

		WebElement cell = driver.findElement(By.xpath("//span[@class='ag-header-cell-text'][normalize-space()='Sub Discipline']"));
		js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", cell);
		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.moveToElement(SubDisciplineColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_SubDiscipline = getHamburgerIconWithLabel("Sub Discipline");
		HamburgerIcon_SubDiscipline.click();
		Thread.sleep(3000);

		SubDisciplineFilter.click();
		SubDisciplineFilter.sendKeys(SubDiscipline1a);
		Thread.sleep(2000);
		ApplyButton.click();
		Thread.sleep(5000);

		List<WebElement> subDiscipline1aRecords = driver.findElements(By.xpath("//div[@col-id='sub_discipline_name_user' and @role='gridcell']"));
		for (WebElement record : subDiscipline1aRecords) {
			String actualName = record.getText();
			Assert.assertTrue(actualName.contains(SubDiscipline1a), 
					"Name does not contain the expected part: " + SubDiscipline1a);	
		}
		test.info("Sub-Discipline filter validate.");
		Thread.sleep(5000);
	}

	public void userTypeFilter() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ResetFiltersButton);
		Thread.sleep(5000);

		WebElement subDiscipline = driver.findElement(By.xpath("//span[@class='ag-header-cell-text'][normalize-space()='Sub Discipline']"));
		js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", subDiscipline);
		Thread.sleep(2000);
		WebElement userType = driver.findElement(By.xpath("//span[@class='ag-header-cell-text'][normalize-space()='User Type']"));
		js.executeScript("arguments[0].scrollIntoView({inline: 'center'});", userType);
		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.moveToElement(UserTypeColumn).perform();
		Thread.sleep(1000);
		WebElement HamburgerIcon_UserType = getHamburgerIconWithLabel("User Type");
		HamburgerIcon_UserType.click();
		Thread.sleep(5000);
		
		List<WebElement> checkboxOptions = driver.findElements(By.xpath("//div[@class='ag-input-field-label ag-label ag-checkbox-label']"));
		for (int i = 0; i < checkboxOptions.size(); i++) {
            String labelText = checkboxOptions.get(i).getText();
            if (labelText.equalsIgnoreCase("APP")) {
            	checkboxOptions.get(i).click();  
                break;  
            }
        	Thread.sleep(2000);
        }
		
		Thread.sleep(2000);
		ApplyButton.click();
		Thread.sleep(5000);
		test.info("User Type filter validate.");
		Thread.sleep(5000);

	}

	public void createdOnFilter() {

	}

	public void updatedOnFilter() {

	}

	public void holdOnFilter() {

	}

	public void holdReasonFilter() {

	}

	public void firstLoginFilter() {

	}

	public void lastLoginAtFilter() {

	}

	public void CVUploadedFilter() {

	}

	public void accountIDFilter() {

	}

	public void statusFilter() {

	}

	public void blockedProfile() {

	}

	public void ERPIDFilter() {

	}

	public void usernameFilter() {

	}

	public void lastSyncDeployer() {

	}

}
