package com.railway.test;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.railway.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends BaseTest {

    @Test
    public void TC06_verifyAdditionalPagesDisplayAfterLogin() {
        driver.manage().window().fullscreen();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        loginPage.login("leduckien060704@gmail.com", "kien060704");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isMyTicketTabDisplayed(), "❌ Tab 'My ticket' không hiển thị!");
        Assert.assertTrue(homePage.isChangePasswordTabDisplayed(), "❌ Tab 'Change password' không hiển thị!");
        Assert.assertTrue(homePage.isLogoutTabDisplayed(), "❌ Tab 'Logout' không hiển thị!");

        homePage.clickMyTicketTab();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("Ticket"), "❌ Không chuyển đến trang 'My ticket'!");

        driver.navigate().back();
        homePage.clickChangePasswordTab();
        String currentUrl2 = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl2.contains("ChangePassword"), "❌ Không chuyển đến trang 'Change password'!");
    }
}