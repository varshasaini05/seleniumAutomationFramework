package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;

public class LoginPageExcel extends BasePage {

	    private WebDriver driver;
	    private ExtentTest test;

	    public LoginPageExcel(WebDriver driver, ExtentTest test) {
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

	            // Check for success message
	            String SuccessfulMsgText = driver.findElement(getLocator("login.successfulMsg")).getText();
	            Assert.assertEquals(SuccessfulMsgText, "Logged In Successfully");
	            
	            // Log success in Extent Report
	            test.pass("Login was successful with username: " + username);

	        } catch (AssertionError e) {
	            // Log failure if success message is not found
	            test.fail("Login failed. Expected success message not found: " + e.getMessage());
	            throw e; // Rethrow to ensure the test status is failed

	        } catch (Exception e) {
	            try {
	                // Check for failure message if any other exception occurs
	                String NotSuccessfulMsgText = driver.findElement(getLocator("login.NotSuccessfulMsg")).getText();
	                Assert.assertEquals(NotSuccessfulMsgText, "Your username is invalid!");
	                test.pass("Login failure message verified: " + NotSuccessfulMsgText);
	            } catch (Exception innerException) {
	                // Log failure if neither success nor failure messages are found
	                test.fail("Login failed with exception: " + e.getMessage());
	            }
	            throw e; // Rethrow to ensure the test status is failed
	        }
	    }
}