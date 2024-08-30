package com.example.Testcases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.time.Duration;

public class BaseTest {
	
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
    String WebsiteURL="https://practicetestautomation.com/practice-test-login/";

    @BeforeSuite
    public void setUpExtent() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setReportName("Selenium Web Automation");
        sparkReporter.config().setDocumentTitle("Web Automation Report");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Browser", "Chrome"); 
        extent.setSystemInfo("Browser Version", "128.0.6613.85"); 
        extent.setSystemInfo("Test Environment", "QA"); 
    }
    
    @BeforeClass
    public void setUp() throws InterruptedException {
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(WebsiteURL);
    }
    
    @AfterMethod
    public void afterMethod(ITestResult result) {
    	 // Handle Extent Report logging
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }
        
    }
    
    @AfterSuite
    public void tearDownExtent() {
        extent.flush();
        
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    
    public void takeScreenshot(String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots/" + testName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}