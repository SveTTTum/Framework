import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICanWinTaskTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = " input new paste, choose Expiration - 10 second, input name")
    public void setDataOnPage() {
        By forInputText = By.id("postform-text");
        By forInputName = By.id("postform-name");
        By forButtonExpiration = By.xpath("//div[@class='form-group field-postform-expiration']//span[@class='select2-selection__arrow']");
        By forChooseExpiration = By.xpath("//span[@class='select2-results']//li[contains(text(), '10 Minutes')]");
        driver.get("https://pastebin.com/");

        WebElement inputText = waitForElementLocatedBy(driver, forInputText);
        inputText.sendKeys("Hello from WebDriver");

        WebElement inputName = waitForElementLocatedBy(driver, forInputName);
        inputName.sendKeys("helloweb");

        WebElement buttonExpiration = waitForElementLocatedBy(driver, forButtonExpiration);
        buttonExpiration.click();

        WebElement chooseExpiration = waitForElementLocatedBy(driver, forButtonExpiration);
        chooseExpiration.click();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    private static WebElement waitForElementLocatedBy (WebDriver driver, By by) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
