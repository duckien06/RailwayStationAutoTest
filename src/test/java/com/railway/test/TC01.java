package com.railway.test;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.railway.base.BaseTest;
import common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends BaseTest {

    @Test
    public void TC01_loginWithValidAccount() {
        driver.manage().window().fullscreen();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        HomePage homePage = new HomePage(driver);
        String welcomeText = homePage.getWelcomeMessage();
        System.out.println("✅ Welcome text: " + welcomeText);
        Assert.assertTrue(welcomeText.length() > 0, "❌ Không hiển thị thông điệp welcome!");

        Assert.assertTrue(homePage.isLogoutTabDisplayed(), "❌ Tab Logout không hiển thị sau khi đăng nhập!");
    }
}
