package testcases;

import base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Listeners;
import pageobjects.HomePage;

@Listeners(utility.TestNGListeners.class)

public class HomePageTest extends TestBase {

    public void validatingHomePageButtonTest(){
        logger=extentReports.createTest("Test one");
        logger.log(Status.INFO, "Initialising the HomePage Page Object");
        HomePage homePage=new HomePage();
        homePage.clickToggle();
        homePage.menuItems();
        homePage.clickIFrames();
    }
}
