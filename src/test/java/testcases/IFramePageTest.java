package testcases;

import base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.Iframes;

@Listeners(utility.TestNGListeners.class)

public class IFramePageTest extends TestBase {

    @Test
    public void validatingIframePage() throws InterruptedException {
        logger=extentReports.createTest("Test three");
        logger.log(Status.INFO, "Initialising the HomePage Page Object");
        HomePage homePage=new HomePage();
        logger.log(Status.INFO, "entering iFrame Page");
        homePage.clickIFrames();


        Iframes iframes=new Iframes();
        iframes.calculatingNoOfFrames();
        iframes.iFrameHandling();
    }
}
