package com.automation.tests;

import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataTest extends BaseTest {


    @DataProvider(name = "sauceUsers")
    public Object[][] getData() {
        return new Object[][] {

                { "standard_user", "secret_sauce" },
                { "locked_out_user", "secret_sauce" },
                { "problem_user", "secret_sauce" },
                { "performance_glitch_user", "secret_sauce" },
                { "error_user", "secret_sauce" }
        };
    }


    @Test(dataProvider = "sauceUsers")
    public void testLoginWithMultipleUsers(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        System.out.println("Testing with user: " + username);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();


        if (username.equals("locked_out_user")) {

            String pageSource = driver.getPageSource();
            Assert.assertTrue(pageSource.contains("Epic sadface"), "Error message should be displayed!");
        } else {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed for user: " + username);
        }
    }
}