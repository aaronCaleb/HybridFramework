package pageobjects;

import base.DriverFactory;
import base.TestBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Iframes extends TestBase {

    public void calculatingNoOfFrames() {

        //By finding all the WebElements using iframe tag
        List<WebElement> iFrameElements = DriverFactory.getInstance().getDriverThreadLocal().findElements(By.tagName("iframe"));
        logger.log(Status.INFO, "Total Number of iframes are" + iFrameElements.size());

        //By executing a java script executor
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriverThreadLocal();
        Integer noOfFrames = Integer.parseInt(executor.executeScript("return window.length").toString());
        logger.log(Status.INFO, "No of iframes on the page are" + noOfFrames);

    }

    public void iFrameHandling() throws InterruptedException {
        DriverFactory.getInstance().getDriverThreadLocal().switchTo().frame(0);
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.cssSelector(".toggle")).click();
        Thread.sleep(3000);
        DriverFactory.getInstance().getDriverThreadLocal().switchTo().parentFrame();
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.cssSelector(".toggle")).click();
        Thread.sleep(3000);
        DriverFactory.getInstance().getDriverThreadLocal().switchTo().frame(1);
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.cssSelector("[aria-label='Play']")).click();
        Thread.sleep(20000);
    }
}



