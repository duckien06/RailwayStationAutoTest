package com.railway.test;

import PageObjects.Railway.LoginPage;
import com.railway.base.BaseTest;
import common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends BaseTest {

    @Test
    public void TC02_loginWithBlankUsername() {
        driver.manage().window().fullscreen();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLoginPage();
        loginPage.login("", Constant.PASSWORD);

        String errorMsg = loginPage.getErrorMessage();
        System.out.println("✅ Error message: " + errorMsg);

        Assert.assertEquals(errorMsg.trim(),
                "There was a problem with your login and/or errors exist in your form.",
                "❌ Thông báo lỗi không đúng khi bỏ trống Username!");
    }
}
