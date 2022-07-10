package report;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

    private ExtentFactory(){

    }

    private static ExtentFactory extentFactoryInstance=new ExtentFactory();

    public static ExtentFactory getInstance(){
        return extentFactoryInstance;
    }

    ThreadLocal<ExtentTest> extentTestThreadLocal=new ThreadLocal<ExtentTest>();

    public ExtentTest getExtent(){
        return extentTestThreadLocal.get();
    }

    public void setExtentTestThreadLocal(ExtentTest extentTestObject){
        extentTestThreadLocal.set(extentTestObject);
    }

    public void removeExtentObject(){
        extentTestThreadLocal.remove();
    }
}
