package com.railway.test;

import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.railway.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends BaseTest {

    @Test
    public void TC09_changePasswordSuccessfully() {
        HomePage homePage = new HomePage(driver);
        driver.get("http://railwayb1.somee.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("cuongngo.27062004@gmail.com", "111111111");

        homePage.clickChangePasswordTab();

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        String newPassword = "222222222";
        changePasswordPage.changePassword("111111111", newPassword);

        String actualMessage = changePasswordPage.getSuccessMessage();
        String expectedMessage = "Your password has been updated!";
        Assert.assertEquals(actualMessage, expectedMessage, "❌ Password update message is incorrect!");
    }
}
