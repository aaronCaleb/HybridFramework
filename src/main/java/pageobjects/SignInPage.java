package pageobjects;

import base.DriverFactory;
import org.openqa.selenium.By;

public class SignInPage {

    public void enterEmailID(String Username){
       DriverFactory.getInstance().getDriverThreadLocal().findElement(By.cssSelector("input[name='email']")).sendKeys(Username);
    }

    public void enterPassword( String Password){
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.cssSelector("input[name='password']")).sendKeys(Password);
    }

    public void signInBtn(){
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.cssSelector("button#submit-login")).click();
    }

    public void signOutBtn(){
        DriverFactory.getInstance().getDriverThreadLocal().findElement(By.cssSelector(".hidden-sm-down.logout")).click();
    }
}
