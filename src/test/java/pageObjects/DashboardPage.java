package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.example.Testcases.BaseTest;

public class DashboardPage extends BaseTest {
	    
	    @FindBy(xpath = "//button[@class='dropbtn']")
	    private WebElement Dropdown;
	    
	    @FindBy(xpath = "//a[normalize-space()='CrewApp']")
	    private WebElement CrewApp;
	    
	    @FindBy(xpath = "//button[@id='open']")
	    private WebElement HamburgerIcon;
	    
	    @FindBy(xpath = "//span[normalize-space()='Users']")
	    private WebElement UsersOption;
	    
	    @FindBy(xpath = "//ul[@class='m-menu__subnav']//span[@class='m-menu__link-text'][normalize-space()='Portal Users']")
	    private WebElement portalUsers;
	    
	    @FindBy(xpath = "//ul[contains(@class,'m-menu__subnav')]//span[contains(@class,'m-menu__link-text')][normalize-space()='Crew App Users']")
	    private WebElement CrewAppUsers;
	    
	  
	    public DashboardPage(WebDriver driver, ExtentTest test) {
	        super(); 
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void clickOnDropdownMenu() {
	    	Dropdown.click();
	    }
	    
	    public void clickOnCrewAppIcon() {
	    	CrewApp.click();
	    }
	    
	    public void clickOnHambergerIcon() {
	    	HamburgerIcon.click();
	    }
	    
	    public void clickOnUsersOption() {
	    	UsersOption.click();
	    }
	    
	    public void clickOnPortalUsers() {
	    	portalUsers.click();
	    }
	  
	    public void clickOnCrewAppUsers() {
	    	CrewAppUsers.click();
	    }
}
