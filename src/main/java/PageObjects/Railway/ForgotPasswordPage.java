package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By emailInput = By.id("email");
    private final By sendInstructionsButton = By.xpath("//input[@value='Send Instructions']");
    private final By resetPasswordErrorMsg = By.xpath("//p[@class='message error']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void open() {
        driver.get("http://railwayb1.somee.com/Account/ForgotPassword.cshtml");
    }

    public void requestReset(String email) {
        driver.findElement(emailInput).sendKeys(email);

        WebElement sendBtn = driver.findElement(sendInstructionsButton);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sendBtn);

        wait.until(ExpectedConditions.elementToBeClickable(sendBtn));

        sendBtn.click();
    }
    public String getResetPasswordErrorMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordErrorMsg)).getText();
    }
}
