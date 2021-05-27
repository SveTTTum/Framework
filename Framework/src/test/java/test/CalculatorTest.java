package test;

import model.DataCalculator;
import page.CalculatorPage;
import page.CloudGoogleHomePage;
import page.TenMinuteMailPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class CalculatorTest extends AbstractTest {

    @Test()
    public void setDataOnPage() throws IOException, UnsupportedFlavorException {

        String textForSearchCalculator = "Google Cloud Platform Pricing Calculator";
        String vmClassResult = "VM class: regular";
        String instanceTypeResult= "Instance type: n1-standard-8";
        String regionResult = "Region: Frankfurt";
        String localSSDResult = "Total available local SSD space 2x375 GiB";
        String commitmentTermResult = "Commitment term: 1 Year";
        String totalCostResult = "Estimated Component Cost: USD 1,082.77 per 1 month";

        CalculatorPage pageHome = new CloudGoogleHomePage(driver)
                .openPage()
                .getSearchResults(textForSearchCalculator)
                .getPage()
                .goToCalculatorFrame()
                .activateComputeEngine()
                .fillInstances(DataCalculator.getNumberInstances())
                .chooseInstancesFor(DataCalculator.getWhatInstancesFor())
                .chooseOperatingSystemOrSoftware(DataCalculator.getOperatingSystem())
                .chooseMachineClass(DataCalculator.getMachineClass())
                .chooseSeries(DataCalculator.getSERIES())
                .chooseMachineType(DataCalculator.getMachineType())
                .fillAllFieldsGPUs(DataCalculator.getNumberGpus(), DataCalculator.getTypeGpus())
                .chooseLocalSSD(DataCalculator.getLocalSsd())
                .chooseDatacenterLocation(DataCalculator.getDatacenterLocation())
                .chooseCommitedUsage(DataCalculator.getCommitedUsage())
                .clickButtonAddToEstimate();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(pageHome.getVMClassResult(), vmClassResult);
        softAssert.assertEquals(pageHome.getInstanceType(), instanceTypeResult);
        softAssert.assertEquals(pageHome.getRegion(), regionResult);
        softAssert.assertEquals(pageHome.getLocalSSD(), localSSDResult);
        softAssert.assertEquals(pageHome.getCommitmentTerm(), commitmentTermResult);
        softAssert.assertEquals(pageHome.getTotalCost(), totalCostResult);
        softAssert.assertAll();

        String totalCostFromCalculatorPage = pageHome.getTotalCost();
        String sumOnlyFromTotalCost = totalCostFromCalculatorPage.substring(totalCostFromCalculatorPage.indexOf(":") + 2, totalCostFromCalculatorPage.indexOf("per") - 1);

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        TenMinuteMailPage tenMinuteMailPage = new TenMinuteMailPage(driver);
        tenMinuteMailPage.openPage()
                .saveEmailInBuffer();

        String emailFromBuffer = tenMinuteMailPage.getRandomEmail();

        driver.switchTo().window(tabs.get(0));

        pageHome.goToCalculatorFrame()
                .sendEmail(emailFromBuffer);

        driver.switchTo().window(tabs.get(1));

        tenMinuteMailPage.openLetter()
                .getTotalSumFromLetter();

        String totalCostFromLetter = tenMinuteMailPage.getTotalSumFromLetter();

        softAssert.assertTrue(sumOnlyFromTotalCost.equals(totalCostFromLetter));
    }
}