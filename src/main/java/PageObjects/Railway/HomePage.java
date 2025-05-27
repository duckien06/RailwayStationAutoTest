package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By welcomeMessage = By.cssSelector("div.account strong");
    private By logoutTab = By.xpath("//a[@href='/Account/Logout']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getWelcomeMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage)).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
    public boolean isLogoutTabDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutTab)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isMyTicketTabDisplayed() {
        return driver.findElement(By.xpath("//a[@href='/Page/ManageTicket.cshtml']")).isDisplayed();
    }
    public boolean isChangePasswordTabDisplayed() {
        return driver.findElement(By.xpath("//a[@href='/Account/ChangePassword.cshtml']")).isDisplayed();
    }
    public void clickMyTicketTab() {
        driver.findElement(By.xpath("//a[@href='/Page/ManageTicket.cshtml']")).click();
    }

    public void clickChangePasswordTab() {
        driver.findElement(By.xpath("//a[@href='/Account/ChangePassword.cshtml']")).click();
    }
    public HomePage open() {
        driver.get("http://railwayb1.somee.com");
        return this;
    }
    public LoginPage gotoLoginPage() {
        driver.findElement(By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']")).click();
        return new LoginPage(driver);
    }
    public BookTicketPage goToBookTicket() {
        driver.findElement(By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']")).click();
        return new BookTicketPage(driver);
    }
    public TimeTablePage goToTimeTablePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement timetableTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Timetable']")));
        timetableTab.click();
        return new TimeTablePage(driver);
    }
}
