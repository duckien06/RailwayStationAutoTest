package com.railway.test;

import PageObjects.Railway.LoginPage;
import com.railway.base.BaseTest;
import common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends BaseTest {

    @Test
    public void TC03_loginWithInvalidPassword() {
        driver.manage().window().fullscreen();

        LoginPage loginPage = new LoginPage(driver);

        String invalidPassword = "wrongpassword";
        loginPage.login(Constant.USERNAME, invalidPassword);

        String errorMsg = loginPage.getErrorMessage();
        System.out.println("✅ Error message: " + errorMsg);

        Assert.assertEquals(errorMsg.trim(),
                "Invalid username or password. Please try again.",
                "❌ Thông báo lỗi không đúng khi nhập sai Password!");

    }
}
