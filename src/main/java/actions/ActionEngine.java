package actions;

import base.DriverFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import report.ExtentFactory;

public class ActionEngine {

    public void sendKeys_Custom(WebElement element,String fieldName, String stringToBeSent){
        try{
            element.sendKeys(stringToBeSent);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Entered String Value is: "+stringToBeSent);

        }catch(Exception e){
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Value entered in the field + "+fieldName +
                    " is failed due to an exception: "+e);
        }
    }

    public void click_Custom(WebElement element, String fieldName){
        element.click();

    }
}
