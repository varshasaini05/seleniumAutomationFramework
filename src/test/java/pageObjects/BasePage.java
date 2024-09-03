package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BasePage {
    protected WebDriver driver;
    private Properties properties = new Properties(); 

    public BasePage() {
         loadLocators();
    }
    

    private void loadLocators() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("locators.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find locators.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected By getLocator(String key) {
        String locator = properties.getProperty(key);
        if (locator == null) {
            throw new IllegalArgumentException("Locator not found for key: " + key);
        }

        String[] parts = locator.split("=", 2);
        String strategy = parts[0].trim();
        String value = parts[1].trim();

        switch (strategy) {
            case "id":
                return By.id(value);
            case "name":
                return By.name(value);
            case "css":
                return By.cssSelector(value);
            case "xpath":
                return By.xpath(value);
            default:
                throw new IllegalArgumentException("Invalid locator strategy: " + strategy);
        }
    }
}