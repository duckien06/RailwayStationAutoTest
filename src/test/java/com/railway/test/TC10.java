package com.railway.test;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import com.railway.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;


public class TC10 extends BaseTest {

    @Test
    public void TC10_CannotRegisterWithConfirmPasswordMismatch() {
        System.out.println("TC10 - User can't create account with 'Confirm password' not matching 'Password'");

        HomePage homePage = new HomePage(driver);
        driver.get("http://railwayb1.somee.com/");

        driver.findElement(By.xpath("//a[@href='/Account/Register.cshtml']")).click();
        RegisterPage registerPage = new RegisterPage(driver);

        String email = "user" + System.currentTimeMillis() + "@test.com";
        String password = "123456789";
        String confirmPassword = "987654321";
        String pid = "123456789";

        registerPage.registerAccount(email, password, confirmPassword, pid);

        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualMsg = registerPage.getErrorMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "❌ Error message not displayed as expected!");
    }
}
