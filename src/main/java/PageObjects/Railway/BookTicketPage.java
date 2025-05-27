package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BookTicketPage {
    private WebDriver driver;

    public BookTicketPage(WebDriver driver) {
        this.driver = driver;
    }

    private By departDateDropdown = By.name("Date");
    private By departFromDropdown = By.name("DepartStation");
    private By arriveAtDropdown = By.name("ArriveStation");
    private By seatTypeDropdown = By.name("SeatType");
    private By ticketAmountDropdown = By.name("TicketAmount");
    private By bookTicketButton = By.xpath("//input[@value='Book ticket']");
    private By successMessage = By.xpath("//div[@id='content']//h1");

    private String ticketInfoXpath = "//table//th[text()='%s']/following-sibling::td";

    public void bookTicket(String date, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        selectDropdown(departDateDropdown, date);
        selectDropdown(departFromDropdown, departFrom);
        selectDropdown(arriveAtDropdown, arriveAt);
        selectDropdown(seatTypeDropdown, seatType);
        selectDropdown(ticketAmountDropdown, ticketAmount);
        driver.findElement(bookTicketButton).click();
    }
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getTicketInfo(String field) {
        String xpath = String.format(ticketInfoXpath, field);
        return driver.findElement(By.xpath(xpath)).getText();
    }

    private void selectDropdown(By locator, String value) {
        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(value);
    }
    public void selectDepartStation(String departStation) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement departStationBox = wait.until(ExpectedConditions.elementToBeClickable(departFromDropdown));

        Select select = new Select(departStationBox);
        for (WebElement option : select.getOptions()) {
            System.out.println("Option: '" + option.getText() + "'");
            if (option.getText().trim().equalsIgnoreCase(departStation.trim())) {
                option.click();
                break;
            }
        }
    }
    public String getSelectedDepartStation() {
        return new Select(driver.findElement(By.name("DepartStation")))
                .getFirstSelectedOption().getText();
    }
    public String getSelectedArriveStation() {
        return new Select(driver.findElement(By.name("ArriveStation")))
                .getFirstSelectedOption().getText();
    }
    public String getSelectedDepartFrom() {
        Select select = new Select(driver.findElement(By.name("DepartStation")));
        return select.getFirstSelectedOption().getText();
    }
    public String getSelectedArriveAt() {
        Select select = new Select(driver.findElement(By.name("ArriveStation")));
        return select.getFirstSelectedOption().getText();
    }
}
