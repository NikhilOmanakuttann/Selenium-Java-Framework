package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(dataProvider = "excelData", dataProviderClass = DataProviderUtils.class)
    public void testLogin(String username, String password) {


        LoginPage loginPage = new LoginPage(driver);

        System.out.println("Testing with user: " + username);


        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();


        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"), "Login failed for user: " + username);
    }
}