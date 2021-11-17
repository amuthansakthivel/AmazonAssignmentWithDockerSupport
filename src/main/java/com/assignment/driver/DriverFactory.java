package com.assignment.driver;

import com.assignment.driver.enums.DriverType;
import com.assignment.driver.impl.ChromeManager;
import com.assignment.driver.impl.EdgeManager;
import com.assignment.exceptions.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver(){
        WebDriver driver;
        switch (DriverType.valueOf("CHROME")){
            case CHROME:
                driver = new ChromeManager().getDriver();
                break;
            case EDGE:
                driver = new EdgeManager().getDriver();
                break;
            default:
                throw new BrowserNotSupportedException("Only chrome and edge browsers are allowed");
        }
        return driver;
    }

}
