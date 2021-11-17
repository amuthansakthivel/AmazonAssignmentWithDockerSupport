package com.assignment.driver;

import com.assignment.driver.factory.DriverFactory;

import java.util.Objects;

public final class Driver {

    private static final Driver driver;

    static {
        driver = new Driver();
    }

    private Driver(){}

    public static Driver getInstance() {
        return driver;
    }

    public void setUpDriver(){
        if (Objects.isNull(DriverManager.getDriver()))
            DriverManager.setDriver(DriverFactory.getDriver());
    }

    public void tearDownDriver(){
        if(Objects.nonNull(DriverManager.getDriver()))
            DriverManager.getDriver().quit();
    }

}
