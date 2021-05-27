package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TenMinuteMailPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://10minutemail.com/";

    @FindBy(xpath = "//div[@id='copy_address']/span")
    private WebElement buttonForSaveRandomEmail;
    @FindBy(xpath = "//div[@class='message_top']")
    private WebElement buttonOpenLetter;
    @FindBy(xpath = "//tr[@id='mobilepadding']//td[2]/h3")
    private WebElement totalEstimatedMonthlyCost;

    private final By quantityLettersBy = By.xpath("//span[@id='inbox_count_number']");

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
    }

    public TenMinuteMailPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public TenMinuteMailPage saveEmailInBuffer() {
        buttonForSaveRandomEmail.click();
        return this;
    }

    public String getRandomEmail() throws IOException, UnsupportedFlavorException {
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    public TenMinuteMailPage openLetter() {
        wait.until(ExpectedConditions.textToBe(quantityLettersBy, "1"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonOpenLetter)).click();
        return this;
    }

    public String getTotalSumFromLetter() {
        return totalEstimatedMonthlyCost.getText();
    }

}
