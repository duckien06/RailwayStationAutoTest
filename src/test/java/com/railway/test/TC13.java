package com.railway.test;

import com.railway.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13 extends BaseTest {

    @Test
    public void TC13_ResetPasswordMismatch() {
        System.out.println("TC13 - Errors display if password and confirm password don't match when resetting password");

        driver.get("http://railwayb1.somee.com/Account/Login.cshtml");

        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password page"));
        forgotPasswordLink.click();

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("leduckien060704@gmail.com");

        WebElement sendInstructionsButton = driver.findElement(By.cssSelector("input[type='submit'][value='Send Instructions']"));
        sendInstructionsButton.click();

        driver.get("http://railwayb1.somee.com/Account/PasswordReset?resetToken=fake_token");

        WebElement newPasswordField = driver.findElement(By.id("newPassword"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        WebElement resetTokenField = driver.findElement(By.id("resetToken"));

        newPasswordField.sendKeys("Password123!");
        confirmPasswordField.sendKeys("Password456!");
        resetTokenField.clear();

        WebElement resetPasswordButton = driver.findElement(By.cssSelector("input[type='submit'][value='Reset Password']"));
        resetPasswordButton.click();

        WebElement generalError = driver.findElement(By.cssSelector("p.message.error"));
        Assert.assertEquals(generalError.getText().trim(), "Could not reset password. Please correct the errors and try again.",
                "❌ General error message is incorrect!");

        WebElement confirmPasswordError = driver.findElement(By.xpath("//label[@for='confirmPassword']/following-sibling::label[@class='validation-error']"));
        Assert.assertEquals(confirmPasswordError.getText().trim(), "The password confirmation did not match the new password.",
                "❌ Confirm password error message is incorrect!");
    }
}
