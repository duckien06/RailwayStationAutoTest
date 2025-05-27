package com.railway.test;

import PageObjects.Railway.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.railway.base.BaseTest;

public class TC04 extends BaseTest {

    @Test
    public void TC04_redirectToLoginWhenClickBookTicketWithoutLogin() {
        driver.manage().window().fullscreen();

        driver.findElement(By.xpath("//a[@href='/Page/BookTicketPage.cshtml']")).click();

        LoginPage loginPage = new LoginPage(driver);
        boolean isLoginFormVisible = loginPage.isLoginFormDisplayed();
        Assert.assertTrue(isLoginFormVisible, "❌ Không hiển thị Login Page khi chưa đăng nhập mà click Book Ticket!");
    }
}
