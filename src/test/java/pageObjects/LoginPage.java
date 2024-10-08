package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.example.Testcases.BaseTest;

public class LoginPage extends BaseTest {

	    private ExtentTest test;

	    @FindBy(xpath = "//input[@placeholder='User Name']")
	    private WebElement Email;
	    
	    @FindBy(xpath = "//input[@id='LoginPass']")
	    private WebElement Password;
	    
	    @FindBy(xpath = "//button[@id='submit_btn']")
	    private WebElement LoginButton;
	    
	    @FindBy(xpath = "//h1[normalize-space()='Welcome!']")
	    private WebElement WelcomeText;
	    
	    
	    public LoginPage(WebDriver driver, ExtentTest test) {
	        super(); 
	        this.driver = driver;
	        this.test = test;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void login(String email, String password) throws InterruptedException {
	        try {
	        	
	        	test.info("Navigating to the login page!!!");
                Email.sendKeys(email);
	        	test.info("Entered email: " + email); 
	        	Thread.sleep(1000);
	        	Password.sendKeys(password);
	        	test.info("Entered password: " + password);
	        	Thread.sleep(1000);
	        	LoginButton.click();
	        	test.info("Clicked on the login button"); 
	        	Thread.sleep(2000);
	        	String welcome = WelcomeText.getText();
	        	Assert.assertEquals(welcome, "Welcome!");
	        	test.pass("Logged in Successfully!!!");
	        	
	        	String currentUrl = driver.getCurrentUrl();
	        	String ExpectedUrl = "https://new-qa2-deployer.getglobalgroup.com/apps";
	        	Assert.assertEquals(currentUrl, ExpectedUrl);
	        	
	        } catch (AssertionError e) {
	            test.fail("Login failed with exception: " + e.getMessage());
	            throw e; // Rethrow to ensure test fails
	        } catch (Exception e) {
	            test.fail("An error occurred: " + e.getMessage());
	            throw e; // Rethrow to ensure test fails
	        }
	    }
}