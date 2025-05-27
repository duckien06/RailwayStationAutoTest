package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyTicketPage {
    private WebDriver driver;

    public MyTicketPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cancelButton = By.xpath("//table[@class='MyTable']//input[@value='Cancel']");

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public boolean isTicketDisappeared() {
        return driver.findElements(cancelButton).isEmpty();
    }
}
