package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloudGoogleResultPage extends AbstractPage {

    private final By linkCalculatorPageBy = By.xpath("//div[@class='gs-title']/a[@class='gs-title' and @href='https://cloud.google.com/products/calculator']");

    CloudGoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage getPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(linkCalculatorPageBy)).click();
        return new CalculatorPage(driver);
    }
}
