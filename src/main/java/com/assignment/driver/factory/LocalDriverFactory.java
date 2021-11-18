package com.assignment.driver.factory;

import com.assignment.config.factory.ConfigFactory;
import com.assignment.driver.enums.DriverType;
import com.assignment.driver.impl.ChromeManager;
import com.assignment.driver.impl.EdgeManager;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactory {

    private LocalDriverFactory(){}

    public static WebDriver getDriver(){
        WebDriver driver;
        if (ConfigFactory.getConfig().browser() == DriverType.EDGE) {
            driver = new EdgeManager().getDriver();
        } else {
            driver = new ChromeManager().getDriver();
        }
        return driver;
    }
}
