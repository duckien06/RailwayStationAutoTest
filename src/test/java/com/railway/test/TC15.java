package com.railway.test;

import PageObjects.Railway.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC15 {
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
    public void bookTicketFromTimeTable() {
        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("knbadaomvp@gmail.com", "123456789");

        TimeTablePage timeTablePage = homePage.goToTimeTablePage();

        timeTablePage.clickBookTicketLink("Huế", "Sài Gòn");

        BookTicketPage bookTicketPage = new BookTicketPage(driver);
        String actualDepart = bookTicketPage.getSelectedDepartStation();
        String actualArrive = bookTicketPage.getSelectedArriveStation();

        softAssert.assertEquals(actualDepart, "Huế", "Depart station mismatch");
        softAssert.assertEquals(actualArrive, "Sài Gòn", "Arrive station mismatch");

        softAssert.assertAll();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) driver.quit();
    }
}
