package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    //Create WebDriver Object for a given Browser;
    public WebDriver createBrowserInstance(String browser) throws MalformedURLException {

        RemoteWebDriver remoteDriver =null;

        if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            System.setProperty("WebDriver.chrome.silenceOutput", "true");

            ChromeOptions options=new ChromeOptions();
            options.setCapability("browserVersion", "103.0.5060.114");
            options.setCapability("platformName", "Windows 11");
            options.setCapability("se:name","My simple test");
            options.addArguments("--incognito");
            remoteDriver=new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            remoteDriver=new FirefoxDriver();

        }else {
            WebDriverManager.edgedriver().setup();
            remoteDriver=new EdgeDriver();
        }

        return remoteDriver;
    }
}
