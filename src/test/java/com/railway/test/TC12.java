package com.railway.test;

import PageObjects.Railway.HomePage;
import com.railway.base.BaseTest;
import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12 extends BaseTest {

    @Test
    public void TC12_ResetPasswordWithBlankToken() {
        System.out.println("TC12 - Errors display when password reset token is blank");

        HomePage homePage = new HomePage(driver);
        driver.get(Constant.RAILWAY_URL);

        WebElement loginTab = driver.findElement(By.xpath("//a[@href='/Account/Login.cshtml']"));
        loginTab.click();

        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password page"));
        forgotPasswordLink.click();

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(Constant.USERNAME);

        WebElement sendInstructionsButton = driver.findElement(By.cssSelector("input[type='submit'][value='Send Instructions']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sendInstructionsButton);
        sendInstructionsButton.click();

        driver.get("http://railwayb1.somee.com/Account/ResetPassword");

        WebElement newPasswordField = driver.findElement(By.id("newPassword"));
        newPasswordField.sendKeys("newPassword123");

        WebElement resetButton = driver.findElement(By.cssSelector("input[type='submit'][value='Reset Password']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resetButton);
        resetButton.click();

        WebElement generalError = driver.findElement(By.cssSelector("p.message.error"));
        WebElement tokenFieldError = driver.findElement(By.xpath("//label[@for='resetToken']/following-sibling::label[@class='validation-error']"));

        Assert.assertEquals(generalError.getText(), "The password reset token is invalid or may have expired. Please go to forgot password page to generate a new password reset request.");
        Assert.assertEquals(tokenFieldError.getText(), "The password reset token is invalid.");
    }
}
