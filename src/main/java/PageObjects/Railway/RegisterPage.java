package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By confirmPasswordInput = By.id("confirmPassword");
    private final By pidInput = By.id("pid");
    private final By registerButton = By.xpath("//input[@value='Register']");
    private final By successMessage = By.xpath("//div[@id='content']/p");
    private final By formErrorMessage = By.xpath("//p[@class='message error']");
    private final By passwordErrorMessage = By.xpath("//label[@for='password']/following-sibling::label[@class='validation-error']");
    private final By pidErrorMessage = By.xpath("//label[@for='pid']/following-sibling::label[@class='validation-error']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void registerAccount(String email, String password, String confirmPassword, String pid) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
        driver.findElement(pidInput).sendKeys(pid);

        WebElement registerBtn = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerBtn);
        registerBtn.click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickRegisterButton() {
        WebElement registerBtn = driver.findElement(registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerBtn);
        registerBtn.click();
    }
    public String getSuccessMessage() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return messageElement.getText();
    }
    public String getFormErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(formErrorMessage)).getText();
    }
    public String getPasswordErrorMessage() {
        return driver.findElement(passwordErrorMessage).getText();
    }


    public String getPidErrorMessage() {
        return driver.findElement(pidErrorMessage).getText();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(formErrorMessage)).getText();
    }
}
