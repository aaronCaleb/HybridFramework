package base;

import org.openqa.selenium.WebDriver;

/**
 * A Singleton Class shlould have public visibilty so that the whole project can use it
 */

public class DriverFactory {

    /**
     * Singleton Design pattern - Developing a class in a fashion that it can have only one instance at anytime.
     * It is very useful when you need to use same object of a class across all classes or framework.
     * Singleton class must return the same instance again, if it is instantiated again
     */

    /**
     * To create a singleton class, we need to follow the following procedure.
     * (1) Declare a constructor of class as private so that no one can instantiate the class outside it,
     * (2) Declare a static reference variable of the class. Static is needed to make it available globally;
     * (3) Declare a static method with return type as object of class which should check if class is already instantiated once.
     */

    //Private constructor so that the class cannot be instantiated from outside this class
    private DriverFactory(){

    }

    //static reference variable of the class to make it available globally;
    private static DriverFactory driverFactoryInstance=new DriverFactory();

    // To instantiate DriverFactory class outside this class
    public static DriverFactory getInstance(){
        return driverFactoryInstance;
    }

    //Factory design Pattern --> Define separate factory for creating objects and create objects by calling that methods;
    //ThreadLocal Webdriver for parallel execution;

    ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();

    //To get this threadLocal WebDriver for pageObjects

    public WebDriver getDriverThreadLocal(){
        return driverThreadLocal.get();
    }
    //To set threadLocal WebDriver
    public void setDriverThreadLocal(WebDriver driverThreadLocalParm){
        driverThreadLocal.set(driverThreadLocalParm);
    }

    //To Quit and Remove threadLocal WebDriver for making it null for next thread

    public void closeBrowser(){
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }

}


