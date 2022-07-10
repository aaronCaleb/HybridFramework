package pageobjects;

import base.DriverFactory;
import base.TestBase;
import com.github.dockerjava.api.model.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {


    //By toggle=By.cssSelector(".toggle");

    public void  clickToggle(){
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.cssSelector(".toggle")).click();
    }

    public void menuItems(){
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.linkText("HOMEPAGE")).click();
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.linkText("ACCORDION")).click();
    }

    public void clickTestStore(){
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.linkText("TEST STORE")).click();
    }

    public void clickIFrames(){
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.linkText("IFRAMES")).click();
    }
}
