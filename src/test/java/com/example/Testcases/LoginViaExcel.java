package com.example.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.example.Utils.ExcelUtils;
import pageObjects.LoginPageExcel;

public class LoginViaExcel extends BaseTest {

    private ExcelUtils excelUtils;

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
       
        String filePath = "src/test/resources/testdata/WebAutomationExcelFile.xlsx";
        excelUtils = new ExcelUtils(filePath);

        int totalRows = excelUtils.getRowCount("Sheet1");
        int totalCols = excelUtils.getColumnCount("Sheet1");

        Object[][] loginData = new Object[totalRows - 1][totalCols];

        for (int i = 1; i < totalRows; i++)
        { 
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = excelUtils.getCellData("Sheet1", i, j);
            }
        }
        return loginData;
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws InterruptedException {
        ExtentTest test = extent.createTest("Login Test");
        if (test == null) {
            test = extent.createTest("Login Test");
        }
        
        driver.get("https://practicetestautomation.com/practice-test-login/");

        LoginPageExcel loginPageExcel = new LoginPageExcel(driver, test);
        loginPageExcel.login(username, password);
        BaseTest.setTest(test);

    }
}