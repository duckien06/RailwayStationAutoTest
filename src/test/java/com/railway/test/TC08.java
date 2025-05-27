package com.railway.test;

import PageObjects.Railway.LoginPage;
import com.railway.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends BaseTest {

    @Test
    public void TC08_CannotLoginWithInactiveAccount() {
        System.out.println("TC08 - User can't login with an account hasn't been activated");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        String inactiveUsername = "inactiveUser";
        String inactivePassword = "12345678";
        loginPage.login(inactiveUsername, inactivePassword);

        String actualErrorMsg = loginPage.getErrorMessage();
        String expectedErrorMsg = "Invalid username or password. Please try again.";
        System.out.println("Actual error message: " + actualErrorMsg);
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "❌ Error message không đúng!");
    }
}
