package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage {
    private WebDriver driver;

    private final By currentPasswordInput = By.id("currentPassword");
    private final By newPasswordInput = By.id("newPassword");
    private final By confirmPasswordInput = By.id("confirmPassword");
    private final By changePasswordButton = By.xpath("//input[@value='Change Password']");
    private final By successMessage = By.xpath("//p[@class='message success']");

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void changePassword(String currentPassword, String newPassword) {
        driver.findElement(currentPasswordInput).sendKeys(currentPassword);
        driver.findElement(newPasswordInput).sendKeys(newPassword);
        driver.findElement(confirmPasswordInput).sendKeys(newPassword);
        driver.findElement(changePasswordButton).click();
    }
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
