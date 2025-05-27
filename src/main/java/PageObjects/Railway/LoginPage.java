package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailInput = By.xpath("//li[@class='username']//input");
    private By passwordInput = By.id("password");
    private By loginButton = By.xpath("//input[@type='submit' and @value='login']");
    private By errorMessage = By.cssSelector("p.message.error.LoginForm");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("http://railwayb1.somee.com/Account/Login.cshtml");
    }

    public void login(String email, String password) {
        navigateToLoginPage();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
    public boolean isLoginFormDisplayed() {
        try {
            return driver.findElement(emailInput).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void openLoginPage() {
        driver.get("http://railwayb1.somee.com/Account/Login.cshtml");
    }

}
