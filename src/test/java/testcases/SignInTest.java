package testcases;

import base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SignInPage;
import pageobjects.StoreHomePage;
import utility.TestDataProvider;

import java.io.IOException;



@Listeners(utility.TestNGListeners.class)

public class SignInTest extends TestBase {

    @Test(dataProvider = "testData")
    public void signInPageTest(String Username, String Password) throws Exception {
        logger=extentReports.createTest("Test Two");
        logger.log(Status.INFO, "Initialising the HomePage Page Object");
        //ExtentFactory.getInstance().getExtent().info("Test started");
        HomePage homePage=new HomePage();
        logger.log(Status.INFO, "CLicking test Store Page");
        homePage.clickTestStore();
        logger.log(Status.INFO, "entering StoreHome Page");
        StoreHomePage storeHomePage = new StoreHomePage();
        storeHomePage.clickSignInBtn();
        logger.log(Status.INFO, "entering SignIn Page");
        SignInPage signInPage = new SignInPage();
        signInPage.enterEmailID(Username);
        signInPage.enterPassword(Password);
        signInPage.signInBtn();
        signInPage.signOutBtn();
    }

    @DataProvider(name="testData")
    public Object[][] DataProviderForVerifyingSignInPage() throws IOException {
        return TestDataProvider.getTestData();
    }


}
