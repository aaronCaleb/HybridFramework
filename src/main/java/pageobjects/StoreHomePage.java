package pageobjects;

import base.DriverFactory;
import org.openqa.selenium.By;

public class StoreHomePage {

    public void clickSignInBtn(){
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.cssSelector("[title] .hidden-sm-down")).click();
    }

    public void getProductOne(){
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.linkText("Hummingbird Printed T-Shirt")).click();
    }

    public void getProductTwo(){
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.linkText("Hummingbird Printed Sweater")).click();
    }
}
