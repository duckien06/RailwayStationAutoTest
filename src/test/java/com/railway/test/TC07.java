package com.railway.test;

import PageObjects.Railway.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07 {
    WebDriver driver;
    RegisterPage registerPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createAccountSuccessfully() {
        driver.get("http://railwayb1.somee.com/Account/Register.cshtml");
        registerPage = new RegisterPage(driver);

        String email = "user" + System.currentTimeMillis() + "@test.com";
        String password = "12345678";
        String pid = "123456789";

        registerPage.registerAccount(email, password, password, pid);

        String actualMessage = registerPage.getSuccessMessage();
        String expectedMessage = "Thank you for registering your account";
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Success message not displayed as expected!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
