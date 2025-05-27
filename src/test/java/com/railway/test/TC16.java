package com.railway.test;

import PageObjects.Railway.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC16 {
    private WebDriver driver;
    private String baseUrl = "http://railwayb1.somee.com";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void cancelTicketSuccessfully() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("knbadaomvp@gmail.com", "123456789");

        homePage.goToBookTicket();
        BookTicketPage bookTicketPage = new BookTicketPage(driver);
        bookTicketPage.bookTicket("5/5/2025", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");

        homePage.clickMyTicketTab();
        MyTicketPage myTicketPage = new MyTicketPage(driver);

        myTicketPage.clickCancelButton();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertTrue(myTicketPage.isTicketDisappeared(), "Ticket was not cancelled successfully.");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) driver.quit();
    }
}
