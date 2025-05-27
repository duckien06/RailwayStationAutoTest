package com.railway.test;

import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.railway.base.BaseTest;

public class TC05 extends BaseTest {

    @Test
    public void TC05_checkLoginAttemptLimitMessage() {
        driver.manage().window().fullscreen();

        LoginPage loginPage = new LoginPage(driver);
        String username = "leduckien060704@gmail.com";
        String invalidPassword = "wrongPassword";

        for (int i = 1; i <= 4; i++) {
            loginPage.login(username, invalidPassword);
            String errorMsg = loginPage.getErrorMessage();
            System.out.println("❌ Lần " + i + ": " + errorMsg);
        }

        String finalErrorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(finalErrorMsg.contains("You have used 4 out of 5 login attempts"),
                "❌ Không hiển thị thông báo số lần đăng nhập sai!");

        System.out.println("✅ Final error message: " + finalErrorMsg);
    }
}
