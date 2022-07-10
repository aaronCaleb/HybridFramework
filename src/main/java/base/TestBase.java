package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import report.ExtentManager;
import utility.ReadConfigProperties;

import java.io.FileNotFoundException;
import java.time.Duration;

public class TestBase {

    /**
     * Creating a Browser instance for launching and tearingDown the Browser
     * An Instance variable is created when an object is created by using a keyword 'new' and destroyed when the object is destroyed.
     * Instance variable hold values that must be referenced by more than one method, constructor or block, or essential parts of an objects state that
     * be present throughout the class;
     * An instance variable can be declared at the class level before or after use;
     * Access modifiers can be given for instance variables;
     *
     */
    BrowserFactory browserFactory=new BrowserFactory();
       public static ExtentReports extentReports;
       public static ExtentTest logger;

    @BeforeMethod
    public void launchBrowser() throws Exception {
        String browser= ReadConfigProperties.getPropertyValueByKey("browser");
        String url=ReadConfigProperties.getPropertyValueByKey("url");

        DriverFactory.getInstance().setDriverThreadLocal(browserFactory.createBrowserInstance(browser));

        DriverFactory.getInstance().getDriverThreadLocal().manage().window().maximize();
        //DriverFactory.getInstance().getDriverThreadLocal().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverFactory.getInstance().getDriverThreadLocal().get(url);

        extentReports=ExtentManager.getExtentReport();


    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getInstance().closeBrowser();
        extentReports.flush();
    }
}
