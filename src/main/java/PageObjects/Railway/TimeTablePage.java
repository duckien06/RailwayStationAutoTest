package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimeTablePage {
    private WebDriver driver;

    public TimeTablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBookTicketLink(String departFrom, String arriveAt) {
        String xpath = String.format(
                "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/a[text()='book ticket']",
                departFrom, arriveAt
        );
        driver.findElement(By.xpath(xpath)).click();
    }
}
