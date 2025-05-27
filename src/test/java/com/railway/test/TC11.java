package com.railway.test;

import PageObjects.Railway.RegisterPage;
import com.railway.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends BaseTest {

    @Test
    public void TC11_UserCannotRegisterWithEmptyPasswordAndPID() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");

        RegisterPage registerPage = new RegisterPage(driver);
        driver.get("http://railwayb1.somee.com/Account/Register.cshtml");

        String email = "user" + System.currentTimeMillis() + "@test.com";
        registerPage.enterEmail(email);

        registerPage.clickRegisterButton();

        String formError = registerPage.getFormErrorMessage();
        Assert.assertTrue(formError.contains("There're errors in the form"), "❌ Form error message is incorrect!");

        String passwordError = registerPage.getPasswordErrorMessage();
        Assert.assertTrue(passwordError.contains("Invalid password length"), "❌ Password error message is incorrect!");

        String pidError = registerPage.getPidErrorMessage();
        Assert.assertTrue(pidError.contains("Invalid ID length"), "❌ PID error message is incorrect!");
    }
}
