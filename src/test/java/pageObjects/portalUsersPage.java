package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentTest;
import com.example.Testcases.BaseTest;

public class portalUsersPage extends BaseTest{
	  private ExtentTest test;
	  
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
	    
	    
	    public portalUsersPage(WebDriver driver, ExtentTest test) {
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
	             String FirstName = "Varsha";
	             FirstNameField.sendKeys(FirstName);
	             test.info("Enter first name : " + FirstName);
	             String LastName = "Saini";
	             LastNameField.sendKeys(LastName);
	             test.info("Enter last name : " + LastName );
	             String email="abcdefg@mailinator.com";
	             EmailField.sendKeys(email);
                 test.info("Enter Email : " + email);
	             phoneCode.sendKeys("+91");
	             test.info("Enter phone code");
	             phoneNumber.click();
	             phoneNumber.sendKeys("8977478940");
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
	             String dynamicXPath = String.format("//span[normalize-space()='%s']", email);
	             WebElement emailElement = driver.findElement(By.xpath(dynamicXPath));
	             
	             // Validate if the email element is displayed
	             if (emailElement.isDisplayed()) {
	                 System.out.println("The email '" + email + "' is present on the webpage.");
	                 test.info("User created successfully.");
	             } else {
	                 System.out.println("The email '" + email + "' is NOT present on the webpage.");
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
}
