package com.railway.test;

import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import common.Constant.Constant;
import com.railway.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends BaseTest {

    @Test
    public void bookOneTicketSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.goToBookTicket();
        BookTicketPage bookTicketPage = new BookTicketPage(driver);

        String departDate = "4/30/2025";
        String departFrom = "Đà Nẵng";
        String arriveAt = "Sài Gòn";
        String seatType = "Hard seat";
        String ticketAmount = "1";

        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);

        String actualMsg = bookTicketPage.getSuccessMessage();
        Assert.assertEquals(actualMsg, "Ticket booked successfully!", "Success message mismatch.");

        Assert.assertEquals(bookTicketPage.getTicketInfo("Depart Station"), departFrom);
        Assert.assertEquals(bookTicketPage.getTicketInfo("Arrive Station"), arriveAt);
        Assert.assertEquals(bookTicketPage.getTicketInfo("Seat Type"), seatType);
        Assert.assertEquals(bookTicketPage.getTicketInfo("Depart Date"), departDate);
        Assert.assertEquals(bookTicketPage.getTicketInfo("Amount"), ticketAmount);
    }
}
