package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetPasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By newPasswordInput = By.id("newPassword");
    private By confirmPasswordInput = By.id("confirmPassword");
    private By tokenInput = By.id("resetToken");
    private By resetButton = By.xpath("//input[@value='Reset Password']");
    private By generalErrorMsg = By.cssSelector("p.message.error");
    private By tokenFieldErrorMsg = By.xpath("//label[@for='resetToken']/following-sibling::label[@class='validation-error']");
    private By confirmPasswordErrorMsg = By.xpath("//label[@for='confirmPassword']/following-sibling::label[@class='validation-error']");

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void resetPassword(String newPassword, String confirmPassword, String token) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPasswordInput)).sendKeys(newPassword);
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
        driver.findElement(tokenInput).clear();
        driver.findElement(tokenInput).sendKeys(token);
        driver.findElement(resetButton).click();
    }
    public String getGeneralErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(generalErrorMsg)).getText();
    }

    public String getTokenFieldErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tokenFieldErrorMsg)).getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordErrorMsg)).getText();
    }
}